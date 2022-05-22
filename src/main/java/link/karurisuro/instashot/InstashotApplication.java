package link.karurisuro.instashot;

import link.karurisuro.instashot.dao.CommentRepository;
import link.karurisuro.instashot.dao.PostRepository;
import link.karurisuro.instashot.dao.UserRepository;
import link.karurisuro.instashot.entities.Comment;
import link.karurisuro.instashot.entities.Post;
import link.karurisuro.instashot.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class InstashotApplication {

    private static final Logger log = LoggerFactory.getLogger(InstashotApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(InstashotApplication.class, args);
    }

    // For sample data migration
    @Bean
    public CommandLineRunner initializeDb(PostRepository postRepo, UserRepository userRepo, CommentRepository commentRepo) {
        return (args -> {
            User user1 = new User("Kiara", "kiara@kiara.com", "It's Kiara", "kiara@123", "kiara01", "ROLE_USER");
            User user2 = new User("Binod", "binod@binod.com", "It's Binod", "binod@123", "binod01", "ROLE_USER");

            Post p1 = new Post("post1","Lorem, ipsum dolor sit amet", user1);
            Post p2 = new Post("post2","Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ipsa, quisquam.", user1);
            Post p3 = new Post("pots3", "consectetur adipisicing elit. Ipsa, quisquam",  user2);

            Comment c1 = new Comment("comment 1", user1, p1);
            Comment c2 = new Comment("comment 2", user2, p1);
            Comment c3 = new Comment("comment 3", user1, p2);
            p1.setLikes(100);

            userRepo.save(user1);
            userRepo.save(user2);
            postRepo.save(p1);
            postRepo.save(p2);
            postRepo.save(p3);
            commentRepo.saveAll(Arrays.asList(c1, c2, c3));

//            userRepo.findAll().forEach(u -> log.info("user: {}", u));
//            postRepo.findAll().forEach(p -> log.info("post: {}", p));
//            commentRepo.findAll().forEach(c -> log.info("comment: {}", c));
        });
    }

}
