package com.company.classes;

import com.company.MainWindow;
import com.company.classes.EntitiesClass;
import com.company.classes.arenas.Syberia;

public class Monster {
    int Count = 0;
    private EntitiesClass[] monster;

    public Monster(EntitiesClass... members) {
        monster = new EntitiesClass[members.length];
        for (int i = 0; i < monster.length; i++) {
            monster[i] = members[i];
        }
    }

    public EntitiesClass[] getMonstersMembers() {
        return monster;
    }

    public void info() {
        for (EntitiesClass monster : monster) {
            Count++;
            monster.info();
            System.out.println("*********");
        }
    }
}
