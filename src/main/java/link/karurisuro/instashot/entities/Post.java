package link.karurisuro.instashot.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

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
    private String body;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;
    @ColumnDefault("0")
    private Integer likes;
//    @CreatedDate
//    private LocalDateTime createdDateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User user;

    /*public Post(String title, String body, List<Comment> comments, Integer likes) {
        this.title = title;
        this.body = body;
        this.comments = comments;
        this.likes = likes;
    }*/

    public Post(String title, String body, Integer likes) {
        this.title = title;
        this.body = body;
        this.likes = likes;
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }
}
