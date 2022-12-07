package priceflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priceflow.service.KakaoService;
import priceflow.service.OAuthService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@ResponseBody
@RequiredArgsConstructor
public class UserController {

    @Autowired
    OAuthService oAuthService;

    @Autowired
    KakaoService kakaoService;

    @ResponseBody
    @GetMapping("/oauth/kakao")
    public void UserInfoSet(@RequestParam String code){
        String access_token = oAuthService.getKakaoAccessToken(code);
        kakaoService.getInfoByKakaoToken(access_token);
    }
}

