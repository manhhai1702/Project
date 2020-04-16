from chalice import Chalice
from chalicelib import db
from chalicelib import auth
from chalice import AuthResponse

app = Chalice(app_name='pythonproj')
app.debug = True
_DB = None

def get_users_db():
    global _DB
    if _DB is None:
        _DB = db.mysqlTodoDB()
    return _DB

@app.route('/hello-post', methods=['POST'])
def hello_post():
    request_body = app.current_request.json_body
    return {'hello': request_body}

@app.authorizer()
def jwt_auth(auth_request):
    token = auth_request.token
    decoded = auth.decode_jwt_token(token)
    return AuthResponse(routes=['*'], principal_id=decoded['sub'])

@app.route('/login', methods=['POST'])
def login():
    body = app.current_request.json_body
    record = get_users_db().get_item(body['username'])
    jwt_token = auth.get_jwt_token(body['username'], body['password'], record[0])
    return {'token': jwt_token}



@app.route('/api', methods=['GET'], authorizer=jwt_auth)
def get_list():
    return get_users_db().list_items()


@app.route('/todos', methods=['POST'])
def add_new_todo():
    body = app.current_request.json_body
    return get_users_db().add_item(
        description=body['description'],
        metadata=body.get('metadata'),
    )