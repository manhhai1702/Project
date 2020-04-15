import mysql.connector
mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  passwd="123456",
  database="'db_sql"

)

print(mydb)
