package pl.coderslab.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.game.models.Monster;


public interface MonsterRepository extends JpaRepository<Monster, Long> {

    Monster findById(Long monsterId);
}
