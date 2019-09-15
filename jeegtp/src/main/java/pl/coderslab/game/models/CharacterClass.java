package pl.coderslab.game.models;

import com.sun.istack.internal.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;


public class CharacterClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String type;
    @NotNull
    private int healthPoints;
    @Nullable
    private int manaPoints;
    @Nullable
    private int magicLvl;
    @NotNull
    private int armor;
    @NotNull
    private double attackSpeed;
    @Nullable
    private int attackDamage;
    @Nullable
    private int magicPower;

    public CharacterClass() {
    }

    public CharacterClass(String type, int healthPoints, int manaPoints, int magicLvl, int armor, double attackSpeed, int attackDamage, int magicPower) {
        this.type = type;
        this.healthPoints = healthPoints;
        this.manaPoints = manaPoints;
        this.magicLvl = magicLvl;
        this.armor = armor;
        this.attackSpeed = attackSpeed;
        this.attackDamage = attackDamage;
        this.magicPower = magicPower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public int getMagicLvl() {
        return magicLvl;
    }

    public void setMagicLvl(int magicLvl) {
        this.magicLvl = magicLvl;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterClass that = (CharacterClass) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CharacterClasses{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", healthPoints=" + healthPoints +
                ", manaPoints=" + manaPoints +
                ", magicLvl=" + magicLvl +
                ", armor=" + armor +
                ", attackSpeed=" + attackSpeed +
                ", attackDamage=" + attackDamage +
                ", magicPower=" + magicPower +
                '}';
    }
}
