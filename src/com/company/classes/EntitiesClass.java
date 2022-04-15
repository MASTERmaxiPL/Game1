package com.company.classes;

import javax.swing.*;
import java.awt.*;
import static com.company.classes.CharacterClass.occupiedCells;
import static com.company.classes.CharacterClass.playerCount;

public abstract class EntitiesClass implements MonsterBaseClass{
    private int number = 4;
    private static int monsterCount = 0;
    private int maxHealthPoints;
    private int healthPoints = 200;
    private AttackType attackType;
    private int attackAmount;
    protected String className;

    public EntitiesClass(
            int x, int y) {
        this.number = ++monsterCount;
        occupiedCells[x][y] = this.number;
        this.x = x;
        this.y = y;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints < 0) {
            this.healthPoints = 0;
        } else if (healthPoints > this.maxHealthPoints) {
            this.healthPoints = this.maxHealthPoints;
        }
        else {
            this.healthPoints = healthPoints;
        }
    }

    /// Getters AND Setters
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public static int getMonsterCount() {
        return monsterCount;
    }
    public static void setMonsterCount(int monsterCount) {
        EntitiesClass.monsterCount = monsterCount;
    }
    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }
    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public AttackType getAttackType() {
        return attackType;
    }
    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
    public int getAttackAmount() {
        return attackAmount;
    }
    public void setAttackAmount(int attackAmount) {
        this.attackAmount = attackAmount;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }


    public void attack(CharacterClass attackedPlayer) {
        attackedPlayer.reduceHealth(this.attackAmount);
        System.out.println(this.className + "  attacked " + attackedPlayer.className + " for " + this.attackAmount);
        if(attackedPlayer.getHealthPoints() == 0){
            System.out.println(attackedPlayer.className + " died");
            attackedPlayer.setImage(null);
            occupiedCells[attackedPlayer.getX()][attackedPlayer.getY()] = 0;
            attackedPlayer.setAttackAmount(0);
            attackedPlayer.setMaxHealthPoints(0);
            playerCount--;
        }
        //if(playerCount == 1){
        //   System.out.println("Player " + this.name + " Won!");
        //}
    }

    @Override
    public void loseHealth(int amount) {
        setHealthPoints(this.getMaxHealthPoints() - amount);
    }
    @Override
    public void info() {
        System.out.println(this.className + " Spawned!");
    }

    private Image image, baseImage, attackLeftImage, attackRightImage;

    private int x, y;

    public void setImage(Image image) {
        this.image = image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void uploadImage(String baseImage, String attackLeftImage, String attackRightImage) {
        this.baseImage = new ImageIcon(baseImage).getImage();
        this.attackLeftImage = new ImageIcon(attackLeftImage).getImage();
        this.attackRightImage = new ImageIcon(attackRightImage).getImage();
        setBaseImage();
    }

    public void setBaseImage() {
        this.image = this.baseImage;
    }

    public void setAttackLeftImage() {
        this.image = this.attackLeftImage;
    }

    public void setAttackRightImage() {
        this.image = this.attackRightImage;
    }

    public void tryChangePosition(int newPositionX, int newPositionY) {
        if (occupiedCells[newPositionX][newPositionY] == 0) {
            occupiedCells[this.x][this.y] = 0;
            occupiedCells[newPositionX][newPositionY] = this.number;
            this.x = newPositionX;
            this.y = newPositionY;
        }// else {
    //        reduceHealth(10);
    //    }
    }
    protected void reduceHealth(int amount) {
        setHealthPoints(this.getHealthPoints() - amount);
    }

    public abstract void left();

    public abstract void right();

    public abstract void up();

    public abstract void down();
}
