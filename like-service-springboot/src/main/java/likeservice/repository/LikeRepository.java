package likeservice.repository;

import likeservice.model.Like;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("select l from Like l where l.userId = ?1 and l.itemId = ?1")
    Optional<Like> findByUserIdAndItemId(String user_id, String item_id);

    @Query("select l from Like l where l.userId = ?1 and l.itemId = ?1")
    List<Like> findListByUserIdAndItemId(String user_id, String item_id);

    @Query("select l from Like l where l.userId = ?1")
    List<Like> findByUserId(String user_id);

    @Query("select l from Like l where l.itemId = ?1")
    List<Like> findByItemId(String item_id);

    @Query("delete from Like l where l.userId = ?1 and l.itemId = ?1")
    void deleteByUserIdAndItemId(String user_id, String item_id);

}
