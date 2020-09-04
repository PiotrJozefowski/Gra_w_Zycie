package com.company;

import javax.swing.*;
import java.awt.*;

public class Life_Thread extends Thread {

    boolean run = true;
    boolean started = false;
    String[][] colors = new String[Main.button_tab.length][Main.button_tab.length];
    int number;

    public void run(){

        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                colors[i][j] = "x";
            }
        }




        while(true){

            if(run){

                for (int i = 0; i < Main.button_tab.length; i++) {
                    for (int j = 0; j < Main.button_tab[i].length; j++) {

                        number = check(i,j);
                        if(Main.button_tab[i][j].getBackground() == Color.BLACK){
                            if(number != 2 && number != 3){
                                colors[i][j] = "W";
                            }
                        }
                        if(Main.button_tab[i][j].getBackground() == Color.WHITE){
                            if(number == 3){
                                colors[i][j] = "B";
                            }
                        }

                    }
                }


                for (int i = 0; i < Main.button_tab.length; i++) {
                    for (int j = 0; j < Main.button_tab[i].length; j++) {
                        if(colors[i][j].equals("W")){
                            Main.button_tab[i][j].setBackground(Color.WHITE);
                        }
                        if(colors[i][j].equals("B")){
                            Main.button_tab[i][j].setBackground(Color.BLACK);
                        }
                    }
                }


            }

            wait(1000);
        }
    }

    void wait(int mls){
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    int check(int x, int y){

        int number_of_alive = 0;

        for (int i = 0; i < Main.button_tab.length; i++) {
            for (int j = 0; j < Main.button_tab[i].length; j++) {

                if((int)(Math.sqrt(((x-i)*(x-i)+(y-j)*(y-j)))) == 1 && Main.button_tab[i][j].getBackground()==Color.BLACK){
                    number_of_alive++;
                }

            }
        }
        return number_of_alive;
    }

}
