package pl.coderslab.game.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.game.dto.CharacterFormDTO;
import pl.coderslab.game.models.Character;
import pl.coderslab.game.models.CharacterClass;
import pl.coderslab.game.models.User;
import pl.coderslab.game.repositories.CharacterRepository;
import pl.coderslab.game.repositories.UserRepository;

import javax.persistence.EntityManager;
import java.time.LocalDate;

@Service
@Transactional
public class CharacterService {
    private CharacterRepository characterRepository;
    private UserRepository userRepository;
    private UserService userService;

    public CharacterService(CharacterRepository characterRepository, EntityManager entityManager, UserRepository userRepository, UserService userService) {
        this.characterRepository = characterRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public boolean isNameAvailable(String name) {
        long count = characterRepository.countByName(name);
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }

    public Character readCharacter(Long id){
       return characterRepository.findOne(id);
    }

    public void createCharacter(CharacterFormDTO newCharacter, CharacterClass characterClass, String userLogin) {
        User user = userRepository.findByLogin(userLogin);
        Character character = new Character();
        character.setName(newCharacter.getName());
        character.setExperiencePoint(0);
        character.setCreated(LocalDate.now().toString());
        character.setLvl(1);
        character.setCharacterClass(characterClass);
        user.getCharacterList().add(character);
        character.setUser(user);
        characterRepository.save(character);
        userService.updateUser(user);
    }

    public void deleteCharacter(Long id){
        characterRepository.delete(id);
    }


    public CharacterClass createCharacterClass(String type) {
        CharacterClass characterClass = new CharacterClass();
        characterClass.setHealthPoints(getRandomNUmberBetweenRange(80, 120));
        characterClass.setArmour(getRandomNUmberBetweenRange(1, 5));
        characterClass.setType(type);
        if (type.equals("Sorcerer") || type.equals("Druid")) {
            characterClass.setManaPoints(getRandomNUmberBetweenRange(40, 60));
            characterClass.setMagicLvl(1);
            characterClass.setAttackSpeed(getRandomNUmberBetweenRange(180, 200));
            characterClass.setMagicPower(Math.round(characterClass.getManaPoints() * 15 / 100));
        } else {
            characterClass.setAttackSpeed(getRandomNUmberBetweenRange(180, 200));
            characterClass.setAttackDamage(getRandomNUmberBetweenRange(2, 8));
        }
        return characterClass;
    }

    private int getRandomNUmberBetweenRange(int min, int max) {
        return (int) Math.round((Math.random() * ((max - min) + 1)) + min);
    }
}
