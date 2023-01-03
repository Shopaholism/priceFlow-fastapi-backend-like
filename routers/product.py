from typing import Optional, Any

from fastapi import Depends
from fastapi.routing import APIRouter
from pydantic.utils import GetterDict

import peewee
from app.dependencies import get_db
from pydantic import BaseModel

from models.product import search_shopping_list, update_product_to_db, get_product_info

product_router = APIRouter(
    prefix='/product',
    tags=['product'],
    dependencies=[Depends(get_db)]
)


class PeeweeGetterDict(GetterDict):
    def get(self, key: Any, default: Any = None):
        res = getattr(self._obj, key, default)
        if isinstance(res, peewee.ModelSelect):
            return list(res)
        return res


class ProductModel(BaseModel):
    productId: str
    title: str
    link: str
    image: str
    lprice: str
    hprice: Optional[str]
    mallName: Optional[str]
    productType: Optional[str]
    brand: Optional[str]
    maker: Optional[str]
    category1: Optional[str]
    category2: Optional[str]
    category3: Optional[str]
    category4: Optional[str]

    class Config:
        orm_mode = True
        getter_dict = PeeweeGetterDict


class ItemName(BaseModel):
    item: str


@product_router.post("/search")
def get_search_results(item_name: ItemName):
    item = item_name.dict()['item']
    products = search_shopping_list(item)
    return products['items']


@product_router.post("/update")
def insert_new_product(product_item: ProductModel):
    item_dict = product_item.dict()
    update_product_to_db(item_dict)


@product_router.get("/{product_id}")
def get_product_by_product_id(product_id: str):
    return get_product_info(product_id)
