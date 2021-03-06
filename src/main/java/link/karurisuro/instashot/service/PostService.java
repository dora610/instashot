package link.karurisuro.instashot.service;

import link.karurisuro.instashot.entities.Post;
import link.karurisuro.instashot.error.CustomDataNotFoundException;
import link.karurisuro.instashot.error.CustomErrorException;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts() throws CustomErrorException;

    Post getSinglePost(Long id) throws CustomDataNotFoundException;

    Long savePost(Post post) throws CustomErrorException;

    Long updatePost(Post post) throws CustomDataNotFoundException, CustomErrorException;

    void deletePost(Long postID) throws CustomDataNotFoundException;
}
