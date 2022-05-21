package link.karurisuro.instashot.controller;

import link.karurisuro.instashot.entities.Post;
import link.karurisuro.instashot.error.CustomDataNotFoundException;
import link.karurisuro.instashot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllPosts() throws CustomDataNotFoundException {
        List<Post> posts = postService.getAllPosts();
        if (posts.size() == 0) {
            throw new CustomDataNotFoundException("No Posts available in db!!");
        }
        return ResponseEntity.of(Optional.of(posts));
    }

    @GetMapping("/find")
    public ResponseEntity<Post> getSinglePost(@RequestParam(value = "id") Long postId) throws CustomDataNotFoundException {
        Optional<Post> post = postService.getSinglePost(postId);
        if (post.isPresent()) {
            throw new CustomDataNotFoundException("Requested post not found");
        }
        return ResponseEntity.of(post);
    }

    @PostMapping("/")
    public ResponseEntity<String> savePost(@RequestBody Post post) {
        Long newPostId = postService.savePost(post);
        String response = "Successfully create new post with postid: " + newPostId;
        return ResponseEntity.of(Optional.ofNullable(response));
    }

}
