package link.karurisuro.instashot.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String email;
    private String bio;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
    private String userName;
    private Boolean enabled;
    private String roles;

    public User(String name, String email, String bio, String password, String userName, String roles) {
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.password = password;
        this.userName = userName;
        this.roles = roles;
        this.enabled = true;
    }
}
