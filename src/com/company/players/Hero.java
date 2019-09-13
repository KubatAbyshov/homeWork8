package com.company.players;

public abstract class Hero extends GameEntity
        implements HavingAbility{

    private Ability ability;

    public Ability getAbility() {
        return ability;
    }

    public Hero(int health, int damage, Ability ability) {
        super(health, damage);
        this.ability = ability;
    }
}
