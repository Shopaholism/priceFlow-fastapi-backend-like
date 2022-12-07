package priceflow.model.dto;


import lombok.*;
import priceflow.model.User;


@Getter
@NoArgsConstructor
@ToString
public class UserDto {
    private String user_name;

    private String user_email;

    private String user_age;

    private String user_gender;

    private String user_token;

    public UserDto(User user){
        this.user_age = user.getUser_age();
        this.user_email = user.getUser_email();
        this.user_gender = user.getUser_gender();
        this.user_token=user.getUser_token();
    }

}
