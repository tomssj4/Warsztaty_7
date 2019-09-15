package pl.coderslab.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.game.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    long countByEmail(String email);
}
