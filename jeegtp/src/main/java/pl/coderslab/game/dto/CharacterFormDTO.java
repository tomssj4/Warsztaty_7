package pl.coderslab.game.dto;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.game.models.CharacterClass;

import javax.persistence.ManyToOne;

public class CharacterFormDTO {

    @NotEmpty
    private String name;

    private Long experiencePoint;

    private String type;

    @ManyToOne
    private CharacterClass characterClass;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getExperiencePoint() {
        return experiencePoint;
    }

    public void setExperiencePoint(Long experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

}
