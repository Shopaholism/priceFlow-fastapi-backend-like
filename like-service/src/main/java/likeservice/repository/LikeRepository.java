package likeservice.repository;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class LikeRepository {
    Map<Integer, User> memoryDB = new ConcurrentHashMap<>();

    public Collection<Like> findAllLikeList(userId){
        return this.memoryDB.get(userId)
    }

    public void deleteLikeItem(String userId, String itemId) {

    }

}
