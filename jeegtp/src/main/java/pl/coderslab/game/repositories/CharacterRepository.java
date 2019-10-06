package pl.coderslab.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.game.models.Character;

public interface CharacterRepository extends JpaRepository <Character, Long> {

    long countByName (String name);


    Character findById(Long characterId);
}
