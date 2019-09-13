package com.company.players;

import java.util.Random;

public class Warrior extends Hero {

    private int randomNumber;

    public Warrior(int health, int damage) {
        super(health, damage, Ability.CRITICAL_DAMAGE);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {

        setRandomNumber();
        this.randomNumber = getDamage() * randomNumber;
        System.out.println("Warrior use critical damage " + randomNumber);
    }

    public void setRandomNumber () {
        this.randomNumber = new Random().nextInt(5 - 2) + 2;
        return;
    }
}
