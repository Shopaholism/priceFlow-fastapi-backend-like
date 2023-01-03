from peewee import MySQLDatabase

USER = 'root'
PWD = '1q2w3e'
HOST = '127.0.0.1'
PORT = '3306'
DB_NAME = 'price_flow'
# DB_URL = f'mysql+pymysql://{USER}:{PWD}@{HOST}:{PORT}/{DB_NAME}'

conn = MySQLDatabase(
    DB_NAME, user=USER,
    password=PWD,
    host=HOST
)
