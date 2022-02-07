package com.harun.ui;

import com.harun.PegSolitaireGame;
import com.harun.customComponents.ArbitraryBoardButtons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadArbitraryBoardUi extends JPanel {
    public LoadArbitraryBoardUi(PegSolitaireGame frame){
        super();

        ArrayList<String> arbitraryBoards = new ArrayList<String>();
        findArbitraryBoards(arbitraryBoards);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        /*
         * Components
         */

        JLabel helperText = new JLabel("Select Arbitrary Game",SwingConstants.CENTER);
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


        /*
        Arbitrary Boards List
        */
        JPanel inner = new JPanel();
        inner.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
        inner.setLayout(new BoxLayout(inner,BoxLayout.Y_AXIS));
        for (String i : arbitraryBoards){
            inner.add(new ArbitraryBoardButtons(i,frame));
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

    //Read "arbitraries.txt" and find arbitaries boards and fill arbitraryBoards array
    private void findArbitraryBoards(ArrayList<String> arbitraryBoards){
        boolean isFound = false;
        try{
            Scanner sc = new Scanner(new File("arbitraries.txt"));

            while(sc.hasNextLine()){

                if(isFound == true){
                    arbitraryBoards.add(sc.nextLine());
                    isFound = false;
                }

                if(sc.nextLine().matches("NEW BOARD")){
                    isFound = true;
                }
            }
        }
        catch (Exception f){}

    }
}
