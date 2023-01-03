import requests
from peewee import IntegerField, TextField, AutoField

from models.Base import BaseModel


class Product(BaseModel):
    id = AutoField(primary_key=True)
    product_id = IntegerField()
    min_price = IntegerField()
    title = TextField()
    link = TextField()
    image = TextField()
    lprice = IntegerField()
    hprice = IntegerField()
    mall_name = TextField()
    product_type = IntegerField()
    brand = TextField()
    maker = TextField()
    category1 = TextField()
    category2 = TextField()
    category3 = TextField()
    category4 = TextField()

    class Meta:
        db_table = 'product'


def search_shopping_list(item: str):
    # TODO: 추후 수정
    client_id = 'svK3mbZO57vglsTDlD1y'
    client_secret = 'L29COdYMwm'
    url = 'https://openapi.naver.com/v1/search/shop?query'
    headers = {
        "X-Naver-Client-Id": client_id,
        "X-Naver-Client-Secret": client_secret
    }

    response = requests.get(
        url=url,
        params=f'query={item}',
        headers=headers
    )
    response_json = response.json()
    return response_json


def update_product_to_db(item: Product):
    # required_fields = ["productId", "title", "link", "image", "lprice"]
    Product.create(
        product_id=int(item['productId']),
        min_price=None if 'min_price' not in item.keys() else int(item['min_price']),
        title=item['title'],
        link=item['link'],
        image=item['image'],
        lprice=int(item['lprice']) if item['lprice'] != "" else None,
        hprice=int(item['hprice']) if item['hprice'] != "" else None,
        mall_name=item['mallName'],
        product_type=int(item['productType']) if item['productType'] != "" else None,
        brand=item['brand'],
        maker=item['maker'],
        category1=item['category1'],
        category2=item['category2'],
        category3=item['category3'],
        category4=item['category4']
    )


def get_product_info(product_id: int):
    selected_product = Product.get(Product.product_id == product_id)
    product = {
        "product_id": selected_product.product_id,
        "min_price": selected_product.min_price,
        "title": selected_product.title,
        "link": selected_product.link,
        "image": selected_product.image,
        "lprice": selected_product.lprice,
        "hprice": selected_product.hprice,
        "mall_name": selected_product.mall_name,
        "product_type": selected_product.product_type,
        "brand": selected_product.brand,
        "maker": selected_product.maker,
        "category1": selected_product.category1,
        "category2": selected_product.category2,
        "category3": selected_product.category3,
        "category4": selected_product.category4,
    }
    return product
