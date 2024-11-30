package org.example.Models;

import java.util.HashMap;

public class PosostaAnaplirosis extends HashMap<Integer, Double>
{
    public PosostaAnaplirosis()
    {
        this.put(0, 0.0);

        for (int i = 1; i < 16; i++) {
            this.put(i, 11.55);
        }

        this.put(16, 12.39);
        this.put(17, 13.23);
        this.put(18, 14.07);
        this.put(19, 14.97);
        this.put(20, 15.87);
        this.put(21, 16.77);
        this.put(22, 17.73);
        this.put(23, 18.69);
        this.put(24, 19.65);
        this.put(25, 20.68);
        this.put(26, 21.71);
        this.put(27, 22.74);
        this.put(28, 23.95);
        this.put(29, 25.16);
        this.put(30, 26.37);
        this.put(31, 28.35);
        this.put(32, 30.33);
        this.put(33, 32.31);
        this.put(34, 34.81);
        this.put(35, 37.31);
        this.put(36, 39.81);
        this.put(37, 42.36);
        this.put(38, 44.91);
        this.put(39, 47.46);
        this.put(40, 50.01);
    }
    
}
