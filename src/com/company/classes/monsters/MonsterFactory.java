package com.company.classes.monsters;

import com.company.Constants;
import com.company.GameField;
import com.company.Monster;
import com.company.classes.CharacterClass;
import com.company.classes.EntitiesClass;

import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

public class MonsterFactory extends TimerTask{
    public GameField gameField;
    private ArrayList<EntitiesClass> monsters;

    public MonsterFactory(GameField gameField, ArrayList<EntitiesClass> monsters){
        this.gameField = gameField;
        this.monsters = monsters;
    }

    @Override
    public void run(){
        if(this.monsters.size() < 3){
            Random rnd = new Random();
            int x, y;
            do {
                x = rnd.nextInt(9) * Constants.CHARACTER_WIDTH;
                y = rnd.nextInt(5) * Constants.CHARACTER_HEIGHT;
            } while (CharacterClass.occupiedCells[x][y] > 0);
            EntitiesClass monster = new Goblin(x, y) {
                @Override
                public void left() {

                }

                @Override
                public void right() {

                }

                @Override
                public void up() {

                }

                @Override
                public void down() {

                }
            };
            monsters.add(monster);
            System.out.println(monsters.size());
            gameField.repaint();
        }
    }
}
