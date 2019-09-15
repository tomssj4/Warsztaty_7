package pl.coderslab.game.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Creature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int healthPoints;
    private int amror;
    private int damagePoints;
    private double attackSpeed;
    private int experiencePoints;

    public Creature() {
    }

    public Creature(String name, int healthPoints, int amror, int damagePoints, double attackSpeed, int experiencePoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.amror = amror;
        this.damagePoints = damagePoints;
        this.attackSpeed = attackSpeed;
        this.experiencePoints = experiencePoints;
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

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAmror() {
        return amror;
    }

    public void setAmror(int amror) {
        this.amror = amror;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return id == creature.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", healthPoints=" + healthPoints +
                ", amror=" + amror +
                ", damagePoints=" + damagePoints +
                ", attackSpeed=" + attackSpeed +
                ", experiencePoints=" + experiencePoints +
                '}';
    }
}
