package link.karurisuro.instashot;

import link.karurisuro.instashot.dao.PostRepository;
import link.karurisuro.instashot.entities.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InstashotApplication {

	private static final Logger log = LoggerFactory.getLogger(InstashotApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InstashotApplication.class, args);
	}

	// For sample data migration
	//	@Bean
	/*public CommandLineRunner initializeDb(PostRepository repo) {
		return (args -> {
			List<Post> li = new ArrayList<>();
			li.add(new Post("pots_1", "author_1",
					"Post descriptions", "comments_1", 5));
			li.add(new Post("pots_2", "author_2",
					"Post descriptions", "comments_2", 20));
			li.add(new Post("pots_3", "author_1",
					"Post descriptions", "comments_3", 15));
			li.add(new Post("pots_4", "author_2",
					"Post descriptions", "comments_4", 2));
			li.add(new Post("pots_5", "author_2",
					"Post descriptions", "comments_5", 25));
			repo.saveAll(li);
			repo.findAll().forEach(p -> log.info("post: {}", p));
		});
	}*/

}
