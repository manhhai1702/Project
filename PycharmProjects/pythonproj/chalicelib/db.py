import mysql.connector
from chalicelib import user
mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  passwd="123456",
  database="db_sql"
)
my_database = mydb.cursor()

class mysqlTodoDB(object):

  def __init__(self, state=None):
    if state is None:
      state = {}
    self._state = state

  def list_items(self):
    sql_statement = "SELECT * FROM USERS"
    my_database.execute(sql_statement)
    output = my_database.fetchall()
    return output

  def get_item(self,  username):
    sql = "SELECT * FROM users WHERE username = %s"
    my_database.execute(sql, (username,))
    output = my_database.fetchall()
    return output

  def delete_item(self, username):
    sql = "DELETE FROM users where username = %s"
    my_database.execute(sql, (username,))
    mydb.commit()
    return "ok"

  def add_item(self, param):
    uid = param["uid"]
    username = param["username"]
    password = user.encodeBcrypt_password(param["password"])
    salt = param["salt"]
    rounds = param["rounds"]
    sql = "INSERT INTO users (uuid,username,salt,rounds, hashed) values(%s,%s,%s,%s,%s)"
    param = (uid, username, salt, rounds, password)
    my_database.execute(sql, param)
    mydb.commit()
    return "done"