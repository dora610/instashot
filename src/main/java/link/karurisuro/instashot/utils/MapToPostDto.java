package link.karurisuro.instashot.utils;

import link.karurisuro.instashot.entities.Post;
import link.karurisuro.instashot.model.PostDto;

public class MapToPostDto {
    public static PostDto mapper(Post post) {
        return new PostDto(post.getId(),
                post.getTitle(),
                post.getBody(),
                post.getComments(),
                post.getLikes(),
                post.getUser().getName(),
                post.getUser().getId());
    }
}
