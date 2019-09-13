package com.company.game;

import com.company.players.*;

public class RPGGame {

    public static void startGame() {
        Boss boss = new Boss(400, 30);
        Hero[] heroes = getHeroes();
        printStatistics(heroes, boss);
        while (!isFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static void round(Hero[] heroes, Boss boss) {
        bossHit(heroes, boss);
        heroesHit(heroes, boss);
        printStatistics(heroes, boss);
        applyAbilities(heroes, boss);
        printStatistics(heroes, boss);
    }

    private static void applyAbilities(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0) {
                heroes[i].useAbility(heroes, boss);
            }
        }
    }


    private static void bossHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= boss.getDamage()) {
                heroes[i].setHealth(0);
            } else {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }

        }

    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() <= heroes[i].getDamage()) {
                boss.setHealth(0);
                return;
            }
            if (heroes[i].getAbility() != Ability.HEAL) {
                if (heroes[i].getAbility() == Ability.SAVE_DAMAGE_AND_REVERT) {
                    boss.setHealth(boss.getHealth() - (boss.getDamage() + heroes[i].getDamage()));
                }

                if (heroes[i].getAbility() == Ability.CRITICAL_DAMAGE) {
                    boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                }

                if (heroes[i].getAbility() == Ability.BOOST) {
                    boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                }


            }
        }

        }


    private static boolean isFinished(Hero[] heroes, Boss boss) {

      if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!");
            return true;
        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }
        }
        if (allHeroesDied) {
            System.out.println("Boss won!");
        }
        return allHeroesDied;
    }

    private static Hero[] getHeroes() {
        Warrior warrior = new Warrior(100, 10);
        Medic medic = new Medic(50, 10);
        Buffer buffer = new Buffer(100, 10);
        Tank tank = new Tank(100, 10);
        Hero[] heroes = {warrior, medic, buffer, tank};
        return heroes;
    }

    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("______________________________");
        System.out.println("Boss health = " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println("Hero " + heroes[i].getClass().getSimpleName() + " = "
                    + heroes[i].getHealth());
        }
        System.out.println("______________________________");
    }
}
