package link.karurisuro.instashot.service;

import link.karurisuro.instashot.dao.PostRepository;
import link.karurisuro.instashot.dao.UserRepository;
import link.karurisuro.instashot.entities.Post;
import link.karurisuro.instashot.entities.User;
import link.karurisuro.instashot.error.CustomDataNotFoundException;
import link.karurisuro.instashot.error.CustomErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> getAllPosts() throws CustomErrorException {
        List<Post> posts = postRepo.findAll();
        if (posts.size() == 0) {
            throw new CustomErrorException("No post is present in db!!", HttpStatus.NOT_FOUND);
        }
        log.debug("posts fetched from db: {}", posts);
        return posts;
    }

    @Override
    public Post getSinglePost(Long id) throws CustomDataNotFoundException {
        Post post = postRepo.findById(id).orElseThrow(CustomDataNotFoundException::new);
        log.debug("post: {}", post);
        return post;
    }

    public Long savePost(Post post) throws CustomErrorException {
        log.debug("post: {}", post);
        if (!userRepository.existsById(post.getUser().getId())) {
            throw new CustomErrorException("Author does not exists", HttpStatus.BAD_REQUEST);
        }
        Post newPost = postRepo.save(post);
        return newPost.getId();
    }

    @Override
    public Long updatePost(Post post) throws CustomDataNotFoundException, CustomErrorException {
        log.debug("post : {}", post);
        if (!postRepo.existsById(post.getId())) {
            throw new CustomDataNotFoundException("Requested post not found");
        }
        if (!userRepository.existsById(post.getUser().getId())) {
            throw new CustomErrorException("Author does not exists", HttpStatus.BAD_REQUEST);
        }
        User user = userRepository.getReferenceById(post.getUser().getId());
        post.setUser(user);
        Post updatedPost = postRepo.save(post);
        return updatedPost.getId();
    }

    @Override
    public void deletePost(Long postId) throws CustomDataNotFoundException {
        log.debug("PostId: {}", postId);
        if (!postRepo.existsById(postId)) {
            throw new CustomDataNotFoundException("Requested post not found");
        }
        postRepo.deleteById(postId);
    }
}
