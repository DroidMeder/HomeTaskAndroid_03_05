package com.example.hometaskandroid_03_05.world;

public class World {
    private String Name;
    private int flags;

    public World(String name, int flags) {
        Name = name;
        this.flags = flags;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }
}
