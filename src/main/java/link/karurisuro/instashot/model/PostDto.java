package link.karurisuro.instashot.model;


import link.karurisuro.instashot.entities.Comment;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDto {
    private Long id;
    private String title;
    private String body;
    private UserDto author;
    private Integer likes;
    private List<CommentDto> comments;

    public PostDto(Long id, String title, String body, Integer likes) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.likes = likes;
    }
}
