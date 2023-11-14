import pyodbc
import json
import os

with open("data.json", encoding="utf-8") as f:
    data = f.read()
    json_obj = json.loads(data)

#json_data = json.dumps(data)

def validate_string(val):
    if(val != None):
        if(type(val) is int):
            return str(val).encode('utf-8')
        else:
            return val


connection_string = pyodbc.connect('DRIVER={ODBC Driver 17 for SQL Server};SERVER= localhost\\SQLEXPRESS;DATABASE=practiccedb;Trusted_Connection=yes')
connection_string.timeout = 60
connection_string.autocommit = True


cursor = connection_string.cursor()
cursor.execute('DROP TABLE Staff')

cursor.execute("""CREATE TABLE Staff (
  id INT IDENTITY(1,1) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  postalZip VARCHAR(255) NOT NULL,
  region VARCHAR(255) NOT NULL,
  country VARCHAR(255) NOT NULL,
  list VARCHAR(255) NOT NULL,
  numberrange VARCHAR(255) ,
  currency VARCHAR(255) NOT NULL,
  alphanumeric VARCHAR(255) NOT NULL
);""")

for i,item in enumerate(json_obj):
    name = validate_string(item.get("name",None))
    phone = validate_string(item.get("phone",None))
    email= validate_string(item.get("email",None))
    address= validate_string(item.get("address",None))
    postalZip = validate_string(item.get("postalZip",None))
    region = validate_string(item.get("region",None))
    country = validate_string(item.get("country",None))
    list = validate_string(item.get("list",None))
    numberrange =validate_string(item.get("numberrange",None))
    currency = validate_string(item.get("currency",None))
    alphanumeric = validate_string(item.get("alphanumeric",None))
    cursor.execute("INSERT INTO dbo.Staff([name],[phone],[email],[address],[postalZip],[region],[country],[list],[numberrange],[currency],[alphanumeric]) VALUES (?,?,?,?,?,?,?,?,?,?,?)" , (name,phone,email,address,postalZip,region,country,list,numberrange,currency,alphanumeric))

