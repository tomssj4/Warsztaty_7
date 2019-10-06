package pl.coderslab.game.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.game.models.Character;
import pl.coderslab.game.models.Monster;
import pl.coderslab.game.repositories.CharacterRepository;
import pl.coderslab.game.repositories.MonsterRepository;


@Service
@Transactional
public class BattleService {
    private MonsterRepository monsterRepository;
    private CharacterRepository characterRepository;

    public BattleService(MonsterRepository monsterRepository, CharacterRepository characterRepository) {
        this.monsterRepository = monsterRepository;
        this.characterRepository = characterRepository;
    }

    public String goBattle (Long characterId, Long monsterId){
        Character character = characterRepository.findById(characterId);
        Monster monster = monsterRepository.findById(monsterId);
        int characterHP = character.getCharacterClass().getHealthPoints();
        double characterAS = character.getCharacterClass().getAttackSpeed();
        int characterEXP = character.getExperiencePoint();
        int characterLVL = character.getLvl();
        boolean characterFirstMove = false;
        int characterDamage = 0;
        if (character.getCharacterClass().getType().equals("Sorcerer") || character.getCharacterClass().getType().equals("Druid")){
            characterDamage = character.getCharacterClass().getMagicPower() - (character.getCharacterClass().getArmor()/12);
        } else {
            characterDamage = character.getCharacterClass().getAttackDamage() - (character.getCharacterClass().getArmor()/12);
        }

        int monsterHP = monster.getHealthPoints();
        double monsterAS = monster.getAttackSpeed();
        int monsterDamage = monster.getDamagePoints() - (monster.getArmour()/12);

        if (characterAS > monsterAS){
            characterFirstMove = true;
        }

       while (!(characterHP <= 0) || !(monsterHP <= 0)){
           if (characterFirstMove == true){
               monsterHP = monsterHP - (((int) characterAS/100) * characterDamage);
           } else {
               characterHP = characterHP - (((int) monsterAS/100) * monsterDamage);
           }
       }

       String result = "";
       if (monsterHP <= 0){
           character.setExperiencePoint(characterEXP + monster.getExperiencePoints());
           result =  "You WON! Our Kingdom is grateful, that We have so powerful SQUIRE!\n";
       } else {
           character.setExperiencePoint(characterEXP - characterEXP/10);
           result = "You LOSE! uahahahaha, better go and find another job. :-P\n";
       }

       String lvlCheck = checkIfLvlCanChange(character);

       return result + lvlCheck;
   }

   private String checkIfLvlCanChange(Character character){
        int exp = character.getExperiencePoint();
        int lvl = character.getLvl();
        int lowerLvl = lvl -1;
        int previousExp = (int) ((50/3) * (Math.pow(lowerLvl, 3) - 6 * Math.pow(lowerLvl, 2) + 17*lowerLvl - 12));
        int requiredExp = (int) ((50/3) * (Math.pow(lvl, 3) - 6 * Math.pow(lvl, 2) + 17*lvl - 12));

        String result = "";
        if (exp > requiredExp){
            character.setLvl(lvl + 1);
            result = "Congratulation! Your LVL has increased form " + lvl + " , to " + character.getLvl() + " !!!";
        } else if (exp < previousExp){
            character.setLvl(lvl - 1);
            result = "Your skills are getting worse, You have to get yourself to WORK!!\n" +
                    "Unfortunately your LVL is decreased to " + character.getLvl() + " .\n" +
                    "Don't be sad, try HARDER!";
        }

        return result;
   }

}
