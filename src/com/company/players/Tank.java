package com.company.players;

import java.util.Random;

public class Tank extends Hero {

    private int revertDamage;

    public Tank(int health, int damage) {
        super(health, damage, Ability.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {


    }
}
