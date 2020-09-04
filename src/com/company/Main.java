package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    public static ArrayList<JButton> buttons_list = new ArrayList<>();
    public static JButton[][] button_tab;

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);


        for (int i = 0; i < 100; i++) {
            buttons_list.add(new JButton());
            //buttons_list.get(i).setSize(25,25);
        }

        JPanel game_panel = new JPanel();
        game_panel.setLayout(new GridLayout((int)(Math.sqrt(buttons_list.size())),(int)(Math.sqrt(buttons_list.size()))));
        game_panel.setBounds(40,25,300,300);

        buttons_list.forEach((button)->{

            game_panel.add(button);
            button.setBackground(Color.WHITE);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(button.getBackground() == Color.WHITE){
                        button.setBackground(Color.BLACK);
                    }else{
                        button.setBackground(Color.WHITE);
                    }
                }
            });
        });

        button_tab = new JButton[(int)(Math.sqrt(buttons_list.size()))][(int)(Math.sqrt(buttons_list.size()))];

        for (int i = 0; i < button_tab.length; i++) {
            for (int j = 0; j < button_tab[i].length; j++) {
                button_tab[i][j] = buttons_list.get((i*10)+j);
            }
        }


        JPanel control_panel = new JPanel();
        control_panel.setLayout(new GridLayout(1,3,10,10));
        control_panel.setBounds(40,330,300,30);
        JButton start_button = new JButton("START");
        JButton restart_button = new JButton("RESTART");
        control_panel.add(start_button);
        control_panel.add(restart_button);
        Life_Thread life_thread = new Life_Thread();

        start_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!life_thread.started) {
                    life_thread.start();
                    life_thread.started = true;
                }
                life_thread.run = true;
            }
        });

        restart_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                life_thread.run = false;
                buttons_list.forEach((button)->{
                    button.setBackground(Color.WHITE);
                    life_thread.number = 0;
                    for (int i = 0; i < life_thread.colors.length; i++) {
                        for (int j = 0; j < life_thread.colors[i].length; j++) {
                            life_thread.colors[i][j] = "x";
                        }
                    }
                });
            }
        });






        frame.add(control_panel);
        frame.add(game_panel);
        frame.setVisible(true);
    }
}
