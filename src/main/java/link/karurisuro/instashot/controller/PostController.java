package link.karurisuro.instashot.controller;

import link.karurisuro.instashot.entities.Post;
import link.karurisuro.instashot.error.CustomDataNotFoundException;
import link.karurisuro.instashot.error.CustomErrorException;
import link.karurisuro.instashot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    private final String responseTempate="Successfully %s post with postId: %s";

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() throws CustomErrorException {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.of(Optional.of(posts));
    }

    @GetMapping("/")
    public ResponseEntity<Post> getSinglePost(@RequestParam(value = "id") Long postId) throws CustomDataNotFoundException {
        Post post = postService.getSinglePost(postId);
        return ResponseEntity.of(Optional.of(post));
    }

    @PostMapping("/")
    public ResponseEntity<String> savePost(@RequestBody Post post) {
        Long newPostId = postService.savePost(post);
        String responseMessage = String.format(responseTempate, "created", newPostId);
        return ResponseEntity.of(Optional.of(responseMessage));
    }

    @PutMapping("/")
    public ResponseEntity<String> updatePost(@RequestBody Post post) throws CustomDataNotFoundException {
        Long updatedPostId = postService.updatePost(post);
        String responseMessage = String.format(responseTempate, "updated", updatedPostId);
        return ResponseEntity.of(Optional.of(responseMessage));
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deletePost(@RequestParam("id") Long postId) throws CustomDataNotFoundException {
        postService.deletePost(postId);
        String responseMessage = String.format(responseTempate, "deleted", postId);
        return ResponseEntity.of(Optional.of(responseMessage));
    }

}
