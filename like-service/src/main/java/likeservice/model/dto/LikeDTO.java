package likeservice.model.dto;

import likeservice.model.Like;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LikeDTO {
    private String user_id;
    private String item_id;

    public LikeDTO(Like like){
        this.user_id = like.getUserId();
        this.item_id = like.getItemId();
    }

}
