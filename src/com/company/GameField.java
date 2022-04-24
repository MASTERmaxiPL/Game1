package com.company;

import com.company.classes.CharacterClass;
import com.company.classes.EntitiesClass;
import com.company.classes.monsters.Goblin;
import com.company.classes.monsters.MonsterFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;

import static com.company.classes.AttackType.*;

public class GameField extends JPanel {
    private Team team;
    private CharacterClass[] players;
    private Monster monster;
    private ArrayList<EntitiesClass> monsters = new ArrayList<>();

    public GameField(Team team) {
        this.team = team;
        this.players = team.getTeamMembers();
        this.monster = monster;
        //this.monsters = monster.getMonstersMembers();
        setFocusable(true);
        addKeyListener(new FieldKeyListener());

        Timer timer = new Timer();
        MonsterFactory monsterFactory = new MonsterFactory(this, monsters);
        timer.schedule(monsterFactory, 0, 3000);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CharacterClass player : players) {
            if(player.getHealthPoints() > 0){
                g.drawImage(player.getImage(), player.getX(), player.getY(), this);
                g.drawString(""+player.getHealthPoints(), player.getX(), player.getY()+12);
                g.drawString("steps", player.getX(), player.getY() + 26);
                System.out.println(player.getName() +"'s HP = " + player.getHealthPoints());
            } else {}
        }
        for (EntitiesClass monster : monsters) {
            if(monster.getHealthPoints() > 0){
                g.drawImage(monster.getImage(), monster.getX(), monster.getY(), this);
                g.drawString(""+monster.getHealthPoints(), monster.getX(), monster.getY()+12);
                System.out.println(monster.getClass() +"'s HP = " + monster.getHealthPoints());
            } else {}
        }
        //for(EntitiesClass monster : monsters){
        //   if(monster.getHealthPoints() > 0){
        //        g.drawImage(monster.getImage(), monster.getX(), monster.getY(), this);
        //        g.drawString(""+monster.getHealthPoints(), monster.getX(), monster.getY()+12);
        //        System.out.println("HP =   " + monster.getHealthPoints());
        //    }
        //    else {}
        //}
        System.out.println("----------------------");
    }
    //////LEFT ATTACKS//////
    protected void AttackOneOnLeft(CharacterClass player){
        player.attack(players[CharacterClass.occupiedCells[player.getX() - Constants.CHARACTER_WIDTH][player.getY()] - 1]);
    }
    protected void AttackTwoOnLeft(CharacterClass player){
        player.attack(players[CharacterClass.occupiedCells[player.getX() - Constants.CHARACTER_WIDTH - 40][player.getY()] - 1]);
    }
    protected void AttackThreeOnLeft(CharacterClass player){
        player.attack(players[CharacterClass.occupiedCells[player.getX() - Constants.CHARACTER_WIDTH - 80][player.getY()] - 1]);
    }
    //////RIGHT ATTACKS//////
    protected void AttackOneOnRight(CharacterClass player){
        player.attack(players[CharacterClass.occupiedCells[player.getX() + Constants.CHARACTER_WIDTH][player.getY()] - 1]);
    }
    protected void AttackTwoOnRight(CharacterClass player){
        player.attack(players[CharacterClass.occupiedCells[player.getX() + Constants.CHARACTER_WIDTH + 40][player.getY()] - 1]);
    }
    protected void AttackThreeOnRight(CharacterClass player){
        player.attack(players[CharacterClass.occupiedCells[player.getX() + Constants.CHARACTER_WIDTH + 80][player.getY()] - 1]);
    }

    //Monsters Attacks//
    protected void MonstersAttackOneLeft(EntitiesClass monster){
        monster.attack(players[CharacterClass.occupiedCells[monster.getX() - Constants.CHARACTER_WIDTH][monster.getY()] - 1]);
    }
    protected void MonstersAttackOneRight(EntitiesClass monster){
        monster.attack(players[CharacterClass.occupiedCells[monster.getX() + Constants.CHARACTER_WIDTH][monster.getY()] - 1]);
    }


    public class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            for (CharacterClass player : players) {

                if (key == player.getLeftKey()) {
                    //player.setX(player.getX() - 40);
                    player.left();
                }
                if (key == player.getRightKey()) {
                    //player.setX(player.getX() + 40);
                    player.right();
                }
                if (key == player.getUpKey()) {
                    //player.setY(player.getY() - 40);
                    player.up();
                }
                if (key == player.getDownKey()) {
                    //player.setY(player.getY() + 40);
                    player.down();
                }

                //////LEFT ATTACKS//////
                if (key == player.getLeftAttackKey()) {
                    player.setAttackLeftImage();

                    if(player.getAttackType() == PHYSICAL ||  player.getAttackType() == MAGICAL ){
                        if (player.getX() > 0 && CharacterClass.occupiedCells[player.getX() - Constants.CHARACTER_WIDTH][player.getY()] > 0) {
                            AttackOneOnLeft(player);
                        }
                    }
                    else if(player.getAttackType() == PHYSICAL_RANGED ){
                        if (player.getX() > 0 && CharacterClass.occupiedCells[player.getX() - Constants.CHARACTER_WIDTH][player.getY()] > 0) {
                            AttackOneOnLeft(player);
                        }
                        else if (player.getX() > 0 && CharacterClass.occupiedCells[player.getX() - Constants.CHARACTER_WIDTH - 40][player.getY()] > 0) {
                            AttackTwoOnLeft(player);
                        }
                        else if (player.getX() > 0 && CharacterClass.occupiedCells[player.getX() - Constants.CHARACTER_WIDTH - 80][player.getY()] > 0) {
                            AttackThreeOnLeft(player);
                        }
                    }
                    else if(player.getAttackType() == MAGICAL_RANGED ){
                        if (player.getX() > 0 && CharacterClass.occupiedCells[player.getX() - Constants.CHARACTER_WIDTH][player.getY()] > 0) {
                            AttackOneOnLeft(player);
                        }
                        else if (player.getX() > 0 && CharacterClass.occupiedCells[player.getX() - Constants.CHARACTER_WIDTH - 40][player.getY()] > 0) {
                            AttackTwoOnLeft(player);
                        }
                    }
                    //timer
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    player.setBaseImage();
                                    repaint();
                                }
                            }, 200
                    );
                }
                //////RIGHT ATTACKS//////
                if (key == player.getRightAttackKey()) {
                    player.setAttackRightImage();

                    if(player.getAttackType() == PHYSICAL ||  player.getAttackType() == MAGICAL ){
                        if (player.getX() < 300 && CharacterClass.occupiedCells[player.getX() + Constants.CHARACTER_WIDTH][player.getY()] > 0) {
                            AttackOneOnRight(player);
                        }
                    }
                    else if(player.getAttackType() == PHYSICAL_RANGED ){
                        if (player.getX() < 300 && CharacterClass.occupiedCells[player.getX() + Constants.CHARACTER_WIDTH][player.getY()] > 0) {
                            AttackOneOnRight(player);
                        }
                        else if (player.getX() < 300 && CharacterClass.occupiedCells[player.getX() + Constants.CHARACTER_WIDTH + 40][player.getY()] > 0) {
                            AttackTwoOnRight(player);
                        }
                        else if (player.getX() < 300 && CharacterClass.occupiedCells[player.getX() + Constants.CHARACTER_WIDTH + 80][player.getY()] > 0) {
                            AttackThreeOnRight(player);
                        }
                    }
                    else if(player.getAttackType() == MAGICAL_RANGED ){
                        if (player.getX() < 300 && CharacterClass.occupiedCells[player.getX() + Constants.CHARACTER_WIDTH][player.getY()] > 0) {
                            AttackOneOnRight(player);
                        }
                        else if (player.getX() < 300 && CharacterClass.occupiedCells[player.getX() + Constants.CHARACTER_WIDTH + 40][player.getY()] > 0) {
                            AttackTwoOnRight(player);
                        }
                    }
                    //timer
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    player.setBaseImage();
                                    repaint();
                                }
                            }, 200
                    );
                }
            }
            repaint();
        }
    }
}
