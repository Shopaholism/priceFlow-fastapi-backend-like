package priceflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priceflow.model.User;
import priceflow.service.DtoService;
import priceflow.service.KakaoService;
import priceflow.service.OAuthService;

import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@ResponseBody
@RequiredArgsConstructor
public class UserController {

    @Autowired
    OAuthService oAuthService;

    @Autowired
    DtoService dtoService;

    @Autowired
    KakaoService kakaoService;

    @ResponseBody
    @GetMapping("/oauth/kakao")
    public void UserInfoSet(@RequestParam String code){
        String access_token = oAuthService.getKakaoAccessToken(code);
        kakaoService.getInfoByKakaoToken(access_token);
    }

    @ResponseBody
    @GetMapping("/user/{userId}")
    public Optional<User> getUserInfoByUserID(@PathVariable Long userId){
        return dtoService.getUserInfoByUserId(userId);
    }



}

