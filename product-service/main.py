import uvicorn
from fastapi import FastAPI, Request
from fastapi.responses import JSONResponse
from pydantic import ValidationError

from routers.product import product_router
from app.database import conn
import py_eureka_client.eureka_client as eureka_client

product_service_port = 8084
eureka_host = "admin:admin@127.0.0.1:8761"
eureka_client.init(eureka_server=f"http://{eureka_host}/eureka/",
                   app_name="product-service",
                   instance_host="127.0.0.1",
                   instance_port=product_service_port)
app = FastAPI(
    title='PriceFlow Product Service',
    description='PriceFlow Product Service API',
    version='0.0.1'
)


@app.get("/")
def root():
    return {"message": "see '/docs' more information"}


app.include_router(product_router)


@app.on_event("startup")
def startup():
    if conn.is_closed():
        print('startup: connect success')
        conn.connect()


@app.on_event("shutdown")
def shutdown():
    if not conn.is_closed():
        print('shutdown: connect close')
        conn.close()


if __name__ == '__main__':
    uvicorn.run(app, host="0.0.0.0", port=8000)
