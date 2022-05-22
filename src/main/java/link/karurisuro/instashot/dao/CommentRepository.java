package link.karurisuro.instashot.dao;

import link.karurisuro.instashot.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
