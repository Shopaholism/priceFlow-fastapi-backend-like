package likeservice.model.dto;

import likeservice.model.Like;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString
public class LikeDto {
    private String user_id;
    private String item_id;

    public LikeDto(Like like){
        this.user_id = like.getUserId();
        this.item_id = like.getItemId();
    }
}
