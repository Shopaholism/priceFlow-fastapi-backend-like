package likeservice.model;

import likeservice.model.dto.LikeDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="like_id")
    private Long likeId;

    @Column(name="user_id", nullable = false)
    private String userId;

    @Column(name = "item_id", nullable = false)
    private String itemId;

    public Like(String userId, String itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }

    public void setByDto(LikeDto likeDto){
        this.userId = likeDto.getUser_id();
        this.itemId = likeDto.getItem_id();
    }
}
