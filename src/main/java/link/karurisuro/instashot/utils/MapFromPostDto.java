package link.karurisuro.instashot.utils;

import link.karurisuro.instashot.entities.Post;
import link.karurisuro.instashot.model.PostDto;

public class MapFromPostDto {
    public static Post mapper(PostDto postDto) {
        Post post = new Post(postDto.getTitle(),
                postDto.getBody(),
                postDto.getComments(),
                postDto.getLikes());
        return post;
    }
}
