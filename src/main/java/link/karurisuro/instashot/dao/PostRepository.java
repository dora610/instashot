package link.karurisuro.instashot.dao;

import link.karurisuro.instashot.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
