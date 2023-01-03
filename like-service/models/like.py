from typing import List

from peewee import IntegerField, TextField
from models.Base import BaseModel

fields = ['user_id', 'item_id']


class Like(BaseModel):
    like_id = IntegerField(primary_key=True)
    user_id = TextField()
    item_id = TextField()

    class Meta:
        db_table = 'like'


def get_user_likes(user_id: str):
    # filter condition
    if_where = True
    if user_id:
        if_where = (Like.user_id == user_id)

    selected_likes = Like.select().where(if_where)

    if fields and isinstance(fields, List):
        for n in selected_likes:
            if 'user_id' not in fields:
                n.user_id = None
            if 'item_id' not in fields:
                n.item_id = None

    return list(selected_likes)


def update_like(like_id, user_id, item_id):
    #TODO: like_id가 같을 경우, 추가가 아니라 업데이트가 됨, 다중키 적용?
    save_num = Like(like_id=like_id, user_id=user_id, item_id=item_id).save()
    if save_num == 0:
        print(f"like table not updated, item: {like_id, user_id, item_id}")


def delete_like_user_id_item_id(like_id: int):
    #TODO: 지우려는 데이터가 없을 경우, exception 처리
    selected_like_id = Like.filter().where(Like.like_id == like_id).first()
    like = Like.get(Like.like_id == selected_like_id.like_id)
    like.delete_instance()
