package com.company.players;

import java.util.Random;

public class Buffer extends Hero {

    private int addStrength;

    public Buffer(int health, int damage) {
        super(health, damage, Ability.BOOST);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {

        for (int i = 0; i < heroes.length; i++) {
            setAddStrength();
            heroes[i].setDamage(heroes[i].getDamage() + getAddStrength());
            System.out.println("Buffer added strength " + heroes[i].getClass().getSimpleName()
                        + " " + getAddStrength());
            }


        }





    public int getAddStrength() {
        return addStrength;
    }

    public void setAddStrength() {
        this.addStrength = new Random().nextInt(15);
    }
}
