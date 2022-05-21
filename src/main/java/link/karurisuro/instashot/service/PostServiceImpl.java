package link.karurisuro.instashot.service;

import link.karurisuro.instashot.dao.PostRepository;
import link.karurisuro.instashot.entities.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepo;

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = postRepo.findAll();
        log.debug("posts fetched from db: {}", posts);
        return posts;
    }

    @Override
    public Optional<Post> getSinglePost(Long id) {
        Optional<Post> post = postRepo.findById(id);
        log.debug("post: {}", post);
        return post;
    }

    public Long savePost(Post post) {
        Post newPost = postRepo.save(post);
        return newPost.getId();
    }
}
