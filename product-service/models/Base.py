from peewee import Model

from app.database import conn


class BaseModel(Model):
    class Meta:
        database = conn
