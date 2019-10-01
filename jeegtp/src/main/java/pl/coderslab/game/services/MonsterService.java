package pl.coderslab.game.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.game.models.Character;
import pl.coderslab.game.models.Creature;
import pl.coderslab.game.repositories.MonsterRepository;

@Service
@Transactional
public class MonsterService {
    private MonsterRepository monsterRepository;
    private CharacterService characterService;


    public MonsterService(MonsterRepository monsterRepository, CharacterService characterService) {
        this.monsterRepository = monsterRepository;
        this.characterService = characterService;
    }

    public Creature getRandomMonster(Long characterId){
        Creature creature = new Creature();
        Character character = characterService.readCharacter(characterId);
        if (character.getLvl() <= 10){
           creature = monsterRepository.findOne(Long.valueOf(getRandomNUmberBetweenRange(1,10)));
        }
        if (character.getLvl() > 10 && character.getLvl() <= 30){
            creature = monsterRepository.findOne(Long.valueOf(getRandomNUmberBetweenRange(11, 20)));
        }
        if (character.getLvl() > 30){
            creature = monsterRepository.findOne(Long.valueOf(getRandomNUmberBetweenRange(21, 50)));
        }
        return creature;
    }

    private int getRandomNUmberBetweenRange(int min, int max) {
        return (int) Math.round((Math.random() * ((max - min) + 1)) + min);
    }
}
