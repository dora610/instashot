package link.karurisuro.instashot;

import link.karurisuro.instashot.dao.PostRepository;
import link.karurisuro.instashot.dao.UserRepository;
import link.karurisuro.instashot.entities.Post;
import link.karurisuro.instashot.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InstashotApplication {

    private static final Logger log = LoggerFactory.getLogger(InstashotApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(InstashotApplication.class, args);
    }

    // For sample data migration
    /*@Bean
    public CommandLineRunner initializeDb(PostRepository postRepo, UserRepository userRepo) {
        return (args -> {
            User user = new User("Kiara", "kiara@kiara.com", "It's kiara", "kiara@123", "normal user");
            Post p1 = new Post("post1","Post descriptions", "comments_1", 50);
            Post p2 = new Post("pots_2", "Post descriptions", "comments_2", 100);
			p1.setUser(user);
			p2.setUser(user);

            userRepo.save(user);
            postRepo.save(p1);
            postRepo.save(p2);


//            userRepo.findAll().forEach(u -> log.info("user: {}", u));
//            postRepo.findAll().forEach(p -> log.info("post: {}", p));
        });
    }*/

}
