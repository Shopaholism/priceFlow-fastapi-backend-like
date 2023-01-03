from typing import Optional, Any, List

from fastapi import Depends
from fastapi.routing import APIRouter
from pydantic.utils import GetterDict

import peewee
from app.dependencies import get_db
from pydantic import BaseModel

from models.like import get_user_likes, delete_like_user_id_item_id, update_like

like_router = APIRouter(
    prefix='/like',
    tags=['like'],
    dependencies=[Depends(get_db)]
)


class PeeweeGetterDict(GetterDict):
    def get(self, key: Any, default: Any = None):
        res = getattr(self._obj, key, default)
        if isinstance(res, peewee.ModelSelect):
            return list(res)
        return res


class LikeModel(BaseModel):
    like_id: int
    user_id: Optional[str]
    item_id: Optional[str]

    class Config:
        orm_mode = True
        getter_dict = PeeweeGetterDict


class LikeListModel(BaseModel):
    likes: List[LikeModel]


@like_router.get("/{user_id}")
def get_specific_user_like_list(user_id: str):
    likes = get_user_likes(user_id)
    likes_list = LikeListModel(likes=likes)
    return likes_list


@like_router.post("/update")
def insert_new_like(like_item: LikeModel):
    item_dict = like_item.dict()
    like_id = item_dict['like_id']
    user_id = item_dict['user_id']
    item_id = item_dict['item_id']
    update_like(like_id, user_id, item_id)


@like_router.get("/delete/{like_id}")
def delete_like(like_id: int):
    delete_like_user_id_item_id(like_id)
