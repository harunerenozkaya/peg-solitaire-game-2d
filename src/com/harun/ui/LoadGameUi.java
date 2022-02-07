package com.harun.ui;

import com.harun.PegSolitaireGame;
import com.harun.customComponents.SavedGameButtons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadGameUi extends JPanel {
    public LoadGameUi(PegSolitaireGame frame){
        super();
        ArrayList<String> savedGameNames = new ArrayList<String>();

        //Find saved games and fill array
        findSavedGames(savedGameNames);

        //Layout settings
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        /*
         * Components
         */

        //Title Text
        JLabel helperText = new JLabel("Select Saved Game",SwingConstants.CENTER);
        helperText.setFont(new Font("Arial",Font.PLAIN,25));

        //Back button
        JButton backToMenubtn = new JButton();

        try {
            URL urlBackBtn = this.getClass().getClassLoader().getResource("com/harun/assets/back.png");
            backToMenubtn.setIcon(new ImageIcon(ImageIO.read(urlBackBtn)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        backToMenubtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showMainMenu();
            }
        });


        //Saved Games List Panel
        JPanel inner = new JPanel();
        inner.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
        inner.setLayout(new BoxLayout(inner,BoxLayout.Y_AXIS));
        for (String i : savedGameNames){
            inner.add(new SavedGameButtons(i,frame));
            inner.add(new JPanel());
        }

        JScrollPane pn = new JScrollPane(inner);
        pn.setPreferredSize(new Dimension(500,250));


        /*
         * Adding components to panel
        */

        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 10;
        c.ipadx = 10;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(30,0,0,200);
        add(backToMenubtn,c);

        c.gridx = 1;
        c.gridy = 1;
        c.ipady = 50;
        c.anchor = GridBagConstraints.CENTER;
        add(helperText,c);

        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        add(pn,c);

    }

    //Read "saves.txt" and find saved games and fill savedGamesNames array
    private void findSavedGames(ArrayList<String> savedGamesNames){
        boolean isFound = false;
        try{

            //Scan saves.txt
            Scanner sc = new Scanner(new File("saves.txt"));

            //If there is next line then continue
            while(sc.hasNextLine()){

                //If this line is under line of NEW GAME then it is game name line so add this array
                if(isFound == true){
                    savedGamesNames.add(sc.nextLine());
                    isFound = false;
                }

                //If this line is NEW GAME so it means new game is found
                if(sc.nextLine().matches("NEW GAME")){
                    isFound = true;
                }
            }
        }
        catch (Exception f){}
    }
}
