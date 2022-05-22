package link.karurisuro.instashot.utils;

import link.karurisuro.instashot.entities.Comment;
import link.karurisuro.instashot.entities.Post;
import link.karurisuro.instashot.entities.User;
import link.karurisuro.instashot.model.CommentDto;
import link.karurisuro.instashot.model.PostDto;
import link.karurisuro.instashot.model.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class MapToDto {
    public static PostDto postMapper(Post post) {
        PostDto postDto = new PostDto(
                post.getId(),
                post.getTitle(),
                post.getBody(),
                post.getLikes());
        UserDto author = userMapper(post.getUser());
        List<CommentDto> comments = post.getComments()
                .stream()
                .map(MapToDto::commentMapper)
                .collect(Collectors.toList());
        postDto.setAuthor(author);
        postDto.setComments(comments);
        return postDto;
    }

    public static UserDto userMapper(User user) {
        return new UserDto(user.getId(), user.getName());
    }

    public static CommentDto commentMapper(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getText(),
                comment.getUser().getName(),
                comment.getPost().getId());
    }
}
