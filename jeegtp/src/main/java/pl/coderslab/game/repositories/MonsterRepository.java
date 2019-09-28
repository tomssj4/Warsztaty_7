package pl.coderslab.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.game.models.Creature;


public interface MonsterRepository extends JpaRepository<Creature, Long> {

}
