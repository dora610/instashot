package link.karurisuro.instashot.model;

import link.karurisuro.instashot.entities.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CommentDto {
    private Long id;
    private String text;
    private String author;
    private Long postId;
}
