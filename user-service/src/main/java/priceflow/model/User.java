package priceflow.model;


import lombok.*;
import priceflow.model.dto.UserDto;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_email")
    private String user_email;

    @Column(name = "gender")
    private String user_gender;

    @Column(name = "age")
    private String user_age;

    @Column(name = "token")
    private String user_token;

    public User(String user_name, String user_email, String gender, String age, String token){
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_age = age;
        this.user_gender = gender;
        this.user_token = token;
    }

    public void setByDto(UserDto userDto){
        this.user_name = userDto.getUser_name();
        this.user_email = userDto.getUser_email();
        this.user_age = userDto.getUser_age();
        this.user_gender = userDto.getUser_gender();
        this.user_token = userDto.getUser_token();
    }

}

