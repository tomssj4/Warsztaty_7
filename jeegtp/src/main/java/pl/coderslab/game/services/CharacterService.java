package pl.coderslab.game.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.game.dto.CharacterFormDTO;
import pl.coderslab.game.models.Character;
import pl.coderslab.game.models.CharacterClass;
import pl.coderslab.game.repositories.CharacterRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CharacterService {
    private CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
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

    public void createCharacter(CharacterFormDTO newCharacter) {
        Character character = new Character();
        character.setName(newCharacter.getName());
        character.setExperiencePoint(0);
        character.setCharacterClass(createCharacterClass(newCharacter));
        character.setCreated(LocalDate.now());
        character.setLvl(1);
        characterRepository.save(character);
    }

    public void deleteCharacter(Long id){
        characterRepository.delete(id);
    }

    public List<Character> getList() {
        return characterRepository.findAll();
    }

    private CharacterClass createCharacterClass(CharacterFormDTO newCharacter) {
        CharacterClass characterClass = new CharacterClass();
        characterClass.setHealthPoints(getRandomNUmberBetweenRange(80, 120));
        characterClass.setArmor(getRandomNUmberBetweenRange(1, 5));
        if (newCharacter.getType().equals("Sorcerer") || newCharacter.getType().equals("Druid")) {
            characterClass.setManaPoints(getRandomNUmberBetweenRange(40, 60));
            characterClass.setMagicLvl(1);
            characterClass.setAttackSpeed((double) getRandomNUmberBetweenRange(180, 200));
            characterClass.setMagicPower((int) Math.round(characterClass.getManaPoints() * 15 / 100));
        } else {
            characterClass.setAttackSpeed((double) getRandomNUmberBetweenRange(180, 200));
            characterClass.setAttackDamage(getRandomNUmberBetweenRange(2, 8));
        }
        return characterClass;
    }

    private int getRandomNUmberBetweenRange(int min, int max) {
        return (int) Math.round((Math.random() * ((max - min) + 1)) + min);
    }
}
