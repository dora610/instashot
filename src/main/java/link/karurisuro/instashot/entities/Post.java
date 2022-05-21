package link.karurisuro.instashot.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String title;
    // TODO: change it to user
    private String author;
    private String body;
    // TODO: change it to list of comments
    private String comments;
    private Integer likes;
    @CreatedDate
    private LocalDateTime createdDateTime;

    public Post(String title, String author, String body, String comments, Integer likes) {
        this.title = title;
        this.author = author;
        this.body = body;
        this.comments = comments;
        this.likes = likes;
    }
}
