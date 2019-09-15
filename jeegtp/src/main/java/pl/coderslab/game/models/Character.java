package pl.coderslab.game.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    private Long experiencePoint;
    @NotNull
//    private CharacterClass characterClass;
    private LocalDate created;

    public Character() {
    }

    public Character(String name, Long experiencePoint, CharacterClass characterClass, LocalDate created) {
        this.name = name;
        this.experiencePoint = experiencePoint;
//        this.characterClass = characterClass;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public CharacterClass getCharacterClass() {
//        return characterClass;
//    }

//    public void setCharacterClass(CharacterClass characterClass) {
//        this.characterClass = characterClass;
//    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id == character.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experiencePoint=" + experiencePoint +
//                ", characterClass=" + characterClass +
                ", created=" + created +
                '}';
    }
}