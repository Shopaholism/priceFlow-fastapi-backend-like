package likeservice.controller;

import likeservice.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {
    @Autowired
    private final LikeService likeService;

    @GetMapping("")
    public ResponseEntity<List<LikeResponse>> getUserLike(@RequestParam("userId") String userId) {
        LikeResponse likeResponse = likeService.getUserLike(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(likeResponse);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<List<LikeResponse>> addLikeItem(@PathVariable("userId") String userId, @RequestBody Item item) {
        LikeResponse user = likeService.addLikeItem(userId, item);
        return ResponseEntity.status(HttpStatus.OK).body(userId, item);
    }

    @DeleteMapping(value="/{userId}/{itemId}")
    public ResponseEntity<List<LikeResponse>> deleteLikeItem(@PathVariable("userId") String userId, @PathVariable("itemId") int itemId) {
        likeService.deleteLikeItem(userId, itemId);
        return ResponseEntity.status(HttpStatus.OK).body(userId);
    }
}
