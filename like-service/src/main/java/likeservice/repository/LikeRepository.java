package likeservice.repository;

import likeservice.model.Like;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("select l from Like l where l.userId = ?1 and l.itemId = ?1")
    Optional<Like> findByUser_email(String user_email);

}
