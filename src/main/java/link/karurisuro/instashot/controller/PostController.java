package link.karurisuro.instashot.controller;

import link.karurisuro.instashot.entities.Post;
import link.karurisuro.instashot.error.CustomDataNotFoundException;
import link.karurisuro.instashot.error.CustomErrorException;
import link.karurisuro.instashot.model.PostDto;
import link.karurisuro.instashot.service.PostService;
import link.karurisuro.instashot.utils.MapFromPostDto;
import link.karurisuro.instashot.utils.MapToPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    private final String responseTemplate = "Successfully %s post with postId: %s";

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> getAllPosts() throws CustomErrorException {
        List<PostDto> postRespList =
                postService.getAllPosts()
                        .stream()
                        .map(MapToPostDto::mapper)
                        .collect(Collectors.toList());
        return ResponseEntity.of(Optional.of(postRespList));
    }

    @GetMapping("/")
    public ResponseEntity<PostDto> getSinglePost(@RequestParam(value = "id") Long postId) throws CustomDataNotFoundException {
        Post post = postService.getSinglePost(postId);
        PostDto postResp = MapToPostDto.mapper(post);
        return ResponseEntity.of(Optional.of(postResp));
    }

    @PostMapping("/")
    public ResponseEntity<String> savePost(@RequestBody PostDto postDto) throws CustomErrorException {
        Post post = MapFromPostDto.mapper(postDto);
        Long newPostId = postService.savePost(post, postDto.getAuthorId());
        String responseMessage = String.format(responseTemplate, "created", newPostId);
        return ResponseEntity.of(Optional.of(responseMessage));
    }

    @PutMapping("/")
    public ResponseEntity<String> updatePost(@RequestBody PostDto postDto) throws CustomDataNotFoundException, CustomErrorException {
        Post post = MapFromPostDto.mapper(postDto);
        post.setId(postDto.getId());
        // validate if the author is editing post or not
        Long updatedPostId = postService.updatePost(post, postDto.getAuthorId());
        String responseMessage = String.format(responseTemplate, "updated", updatedPostId);
        return ResponseEntity.of(Optional.of(responseMessage));
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deletePost(@RequestParam("id") Long postId) throws CustomDataNotFoundException {
        postService.deletePost(postId);
        String responseMessage = String.format(responseTemplate, "deleted", postId);
        return ResponseEntity.of(Optional.of(responseMessage));
    }

}
