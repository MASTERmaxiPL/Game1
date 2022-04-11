package com.company;

import com.company.classes.arenas.Syberia;
import com.company.classes.characters.Archer;
import com.company.classes.characters.Healer;
import com.company.classes.characters.Mage;
import com.company.classes.characters.Warrior;

import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) {
        //Warrior war1 = new Warrior("NAme");
        //war1.info();

        Team team = new Team (
            new Warrior("Aragorn", 0, 0, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_Q, KeyEvent.VK_E),

            new Archer("Legolas", 320, 0, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_N, KeyEvent.VK_M),

            new Mage("Gordon", 320, 320, KeyEvent.VK_J, KeyEvent.VK_L, KeyEvent.VK_I, KeyEvent.VK_K, KeyEvent.VK_U, KeyEvent.VK_O),

            new Healer("Helia", 0, 320, KeyEvent.VK_F, KeyEvent.VK_H, KeyEvent.VK_T, KeyEvent.VK_G, KeyEvent.VK_R, KeyEvent.VK_Y)
        );
        team.info();
        Syberia arena1 = new Syberia();
        if (team.enterArena(arena1)) {
            team.setArena(arena1);
            team.runArena();
        } else {
            System.out.println("Game over");
        }
    }
}
