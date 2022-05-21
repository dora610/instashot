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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String body;
    // TODO: change it to list of comments
    private String comments;
    private Integer likes;
//    @CreatedDate
//    private LocalDateTime createdDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User user;

    public Post(String title, String body, String comments, Integer likes) {
        this.title = title;
        this.body = body;
        this.comments = comments;
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", comments='" + comments + '\'' +
                ", likes=" + likes +
                ", userName=" + user.getName() +
                '}';
    }
}
