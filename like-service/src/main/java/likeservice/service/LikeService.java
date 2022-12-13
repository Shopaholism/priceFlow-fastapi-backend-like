package likeservice.service;

import io.swagger.v3.core.util.Json;
import likeservice.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;

    public static List<User> users;
    static {
        users = new ArrayList<>();
        users.add(new User("12345", "sally", new ArrayList("11111")))
    }

    public List<Item> getUserLike(String userId){
        return likeRepository.getAllLikeItems(userId);
    }

    public void addLikeItem(String userId, Item item){
        return likeRepository.updateLikeItem(userId, item);
    }

    public void deleteLikeItem(String userId, String itemId){
        return likeRepository.deleteLikeItem(userId, itemId);
    }
}
