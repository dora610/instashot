package link.karurisuro.instashot.dao;

import link.karurisuro.instashot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
