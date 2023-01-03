package likeservice.controller;

import likeservice.model.Like;
import likeservice.model.dto.LikeDto;
import likeservice.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@ResponseBody
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {
    @Autowired
    private final LikeService likeService;

    @PostMapping("/update")
    public void addLikeItemByUserId(@RequestBody LikeDto likeDto) {
        likeService.saveLikeItemByUserId(likeDto);
    }

    @GetMapping("")
    public List<Like> getUserLike(@RequestParam("userId") String userId) {
        return likeService.getUserLike(userId);
    }

    @DeleteMapping(value="/{userId}/{itemId}")
    public void deleteLikeItemByUserIdItemId(@PathVariable("userId") String userId, @PathVariable("itemId") String itemId) {
        likeService.deleteLikeItemByUserIdItemId(userId, itemId);
    }
}
