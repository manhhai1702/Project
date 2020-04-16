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
