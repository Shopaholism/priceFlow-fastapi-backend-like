package likeservice.service;

import likeservice.model.Like;
import likeservice.model.dto.LikeDto;
import likeservice.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public void saveLikeItemByUserId(LikeDto likeDto) {
        if (likeRepository.findByUserIdAndItemId(likeDto.getUser_id(), likeDto.getItem_id()).isPresent()) {
            Optional<Like> like = likeRepository.findByUserIdAndItemId(likeDto.getUser_id(), likeDto.getItem_id());
            like.get().setLike(likeDto.getLike());
            likeRepository.save(like.get());

        } else {
            Like like = null;
            like.setByDto(likeDto);
            likeRepository.save(like);
        }
    }

    public List<Like> getUserLike(String userId) {
        List<Like> likes = likeRepository.findByUserId(userId);
        return likes;
    }

    public void deleteLikeItemByUserIdItemId(String userId, String itemId) {
        likeRepository.deleteByUserIdAndItemId(userId, itemId);
    }
}
