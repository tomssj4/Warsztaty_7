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
        int characterMP = 0;
        int characterMLVL = 0;
        if (character.getCharacterClass().getType().equals("Sorcerer") || character.getCharacterClass().getType().equals("Druid")){
            characterDamage = character.getCharacterClass().getMagicPower();
            characterMP = character.getCharacterClass().getManaPoints();
            characterMLVL = character.getCharacterClass().getMagicLvl();
        } else {
            characterDamage = character.getCharacterClass().getAttackDamage();
        }

        int monsterHP = monster.getHealthPoints();
        double monsterAS = monster.getAttackSpeed();
        int monsterDamage = monster.getDamagePoints() - (monster.getArmour()/12);

        if (characterAS > monsterAS){
            characterFirstMove = true;
        }

       while (!(characterHP <= 0) || !(monsterHP <= 0)){
           if (characterFirstMove == true){
               if (character.getCharacterClass().getType().equals("Sorcerer") || character.getCharacterClass().getType().equals("Druid")) {
                   if (characterMP > characterMLVL * 2 + characterLVL/2) {
                       monsterHP = monsterHP - (((int) characterAS / 100) * characterDamage);
                       characterMP = characterMP - characterMLVL * 2 + characterLVL/2;
                       characterMP = characterMP + characterMLVL * 4;
                       characterFirstMove = false;
                   } else {
                       characterMP = characterMP + characterMLVL * 4;
                       characterFirstMove = false;
                   }
               } else {
                   monsterHP = monsterHP - (((int) characterAS / 100) * characterDamage);
                   characterFirstMove = false;
               }
           } else {
               characterHP = characterHP - (((int) monsterAS/100) * monsterDamage);
               characterFirstMove = true;
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
        int hp = character.getCharacterClass().getHealthPoints();
        int mp = character.getCharacterClass().getManaPoints();
        int mlvl = character.getCharacterClass().getMagicLvl();
        int magicPower = character.getCharacterClass().getMagicPower();
        int armour = character.getCharacterClass().getArmour();
        int attackDamage = character.getCharacterClass().getAttackDamage();
        double attackSP = character.getCharacterClass().getAttackSpeed();

        int exp = character.getExperiencePoint();
        int lvl = character.getLvl();
        int lowerLvl = lvl - 1;
        int previousExp = (int) ((50/3) * (Math.pow(lowerLvl, 3) - 6 * Math.pow(lowerLvl, 2) + 17*lowerLvl - 12));
        int requiredExp = (int) ((50/3) * (Math.pow(lvl + 1, 3) - 6 * Math.pow(lvl + 1, 2) + 17*(lvl+1) - 12));

        String result = "";
        if (exp > requiredExp && requiredExp > 0){
            character.setLvl(lvl + 1);
            lvl += 1;
            if (character.getCharacterClass().getType().equals("Sorcerer") || character.getCharacterClass().getType().equals("Druid")) {
                character.getCharacterClass().setHealthPoints(hp + hp*15/100);
                character.getCharacterClass().setManaPoints(mp + mp*20/100);
                character.getCharacterClass().setArmour(armour + lvl/3);
                character.getCharacterClass().setAttackSpeed(attackSP + attackSP*20/100);
                character.getCharacterClass().setMagicPower(magicPower + lvl + 4 * mlvl);

                int requiredMP = (int) ((100/3) * (Math.pow(mlvl + 1, 3) - 6 * Math.pow(mlvl + 1, 2) + 17*(mlvl + 1) - 12));
                if (character.getCharacterClass().getManaPoints() > requiredMP && requiredMP > 0){
                    character.getCharacterClass().setMagicLvl(mlvl + 1);
                }
            } else if (character.getCharacterClass().getType().equals("Knight")){
                character.getCharacterClass().setHealthPoints(hp + hp*22/100);
                character.getCharacterClass().setArmour(armour + 2*lvl/3);
                character.getCharacterClass().setAttackSpeed(attackSP + attackSP*18/100);
                character.getCharacterClass().setAttackDamage((int) (attackDamage + character.getLvl()*1.5));
            } else if (character.getCharacterClass().getType().equals("Palladyn")){
                character.getCharacterClass().setHealthPoints(hp + hp*18/100);
                character.getCharacterClass().setArmour(armour + lvl/2);
                character.getCharacterClass().setAttackSpeed(attackSP + attackSP*22/100);
                character.getCharacterClass().setAttackDamage((int) (attackDamage + character.getLvl()*1.5));
            }
                result = "Congratulation! Your LVL has increased form " + (lvl - 1) + " , to " + character.getLvl() + " !!!";
        } else if (exp < previousExp && previousExp > 0){

            result = "Your skills are getting worse, You have to get yourself to WORK!!\n" +
                    "Don't be sad, try HARDER!";
        }

        return result;
   }

}
