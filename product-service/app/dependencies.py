from app.database import conn


def get_db():
    """매 요청시 connect, 응답 후 close """
    try:
        if conn.is_closed():
            print("MySql Connecting...")
            conn.connect()
            yield
    finally:
        if not conn.is_closed():
            print("MySql Connection Closing...")
            conn.close()
