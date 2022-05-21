package link.karurisuro.instashot.service;

import link.karurisuro.instashot.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts();

    Optional<Post> getSinglePost(Long id);

    Long savePost(Post post);
}
