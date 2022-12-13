package likeservice.model;

public class Like {
    private String userId;
    private String itemId;

    public Like() {

    }

    public Like(String userId, String itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public String getItemId() {
        return itemId;
    }
}
