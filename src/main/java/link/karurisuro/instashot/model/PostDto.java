package link.karurisuro.instashot.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDto {
    private Long id;
    private String title;
    private String body;
    private String comments;
    private Integer likes;
    private String authorName;
    private Long authorId;
}
