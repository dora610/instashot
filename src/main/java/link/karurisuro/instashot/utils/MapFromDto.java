package link.karurisuro.instashot.utils;

import link.karurisuro.instashot.entities.Comment;
import link.karurisuro.instashot.entities.Post;
import link.karurisuro.instashot.entities.User;
import link.karurisuro.instashot.model.CommentDto;
import link.karurisuro.instashot.model.PostDto;
import link.karurisuro.instashot.model.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class MapFromDto {
    public static Post postMapper(PostDto postDto) {
        Post post= new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setBody(postDto.getBody());
        post.setLikes(postDto.getLikes());

        User user = userMapper(postDto.getAuthor());
        if(postDto.getComments()!=null){
            List<Comment> comments = postDto.getComments()
                    .stream()
                    .map(MapFromDto::commentMapper)
                    .collect(Collectors.toList());
            post.setComments(comments);
        }
        post.setUser(user);
        return post;
    }

    public static User userMapper(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        return user;
    }

    public static Comment commentMapper(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setText(commentDto.getText());
        return comment;
    }


}
