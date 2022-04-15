package com.company.classes.monsters;

import com.company.classes.EntitiesClass;
import static com.company.classes.AttackType.PHYSICAL;

public class Goblin extends EntitiesClass {
    public Goblin(int x, int y){
        super(x, y);
        this.setAttackAmount(30);
        this.setMaxHealthPoints(100);
        setHealthPoints(100);
        this.className = "Goblin";
        this.setAttackType(PHYSICAL);
        this.uploadImage("goblin.png",  "goblinLeftAttack.png", "goblinRightAttack.png");
    }
    public void left() {
        int newPositionX = this.getX() > 40 ?  this.getX() - 40 : 0;
        tryChangePosition(newPositionX, this.getY());
    }
    public void right() {
        int newPositionX = this.getX() < 320 ?  this.getX() + 40 : 320;
        tryChangePosition(newPositionX, this.getY());
    }
    public void up() {
        int newPositionY = this.getY() >= 80 ?  this.getY() - 80 : 0;
        tryChangePosition(this.getX(), newPositionY);
    }
    public void down() {
        int newPositionY = this.getY() < 320 ?  this.getY() + 80 : 320;
        tryChangePosition(this.getX(), newPositionY);
    }
}
