package com.harun.customComponents;

import com.harun.Cell;
import com.harun.PegSolitaireGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ArbitraryBoardButtons extends JPanel implements MouseListener{
    private String boardName;
    private PegSolitaireGame frame;

    public ArbitraryBoardButtons(String boardName, PegSolitaireGame frame){
        this.boardName = boardName;
        this.frame = frame;
        this.setBackground(new Color(245,195,95));
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        this.addMouseListener(this);

        GridBagConstraints c = new GridBagConstraints();

        ///Delete saved game button
        JButton deleteBtn = new JButton();
        deleteBtn.setPreferredSize(new Dimension(50,50));
        try {
            URL urlDeleteBtn = this.getClass().getClassLoader().getResource("com/harun/assets/delete.png");
            deleteBtn.setIcon(new ImageIcon(ImageIO.read(urlDeleteBtn)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> newTextList = new ArrayList<String>();
                boolean isFound = false;

                try{
                    //Get all saved game infos
                    File file = new File("arbitraries.txt");
                    byte[] encoded = Files.readAllBytes(Path.of(file.toURI()));
                    String str = new String(encoded,StandardCharsets.UTF_8);

                    //Create new text without game which will be deleted
                    Scanner scanner = new Scanner(str);
                    while (scanner.hasNextLine()) {
                        String buffer = scanner.nextLine();

                        if(buffer.matches("NEW BOARD")){
                            isFound = false;
                        }

                        if(buffer.matches(boardName)){
                            isFound = true;
                            //Delete last item of newTextList which is NEW BOARD text
                            newTextList.remove(newTextList.size()-1);
                        }

                        if(isFound == false){
                            newTextList.add(buffer+"\n");
                        }
                    }
                    scanner.close();

                    /*
                    Write new text
                    */

                    // Creates a Writer using FileWriter
                    FileWriter output = new FileWriter("arbitraries.txt");

                    // Writes string to the file
                    for(String i : newTextList){
                        output.write(i);
                    }
                    // Closes the writer
                    output.close();

                }catch (IOException f){}

                frame.showLoadArbitraryBoardScreen();
            }
        });

        //Game name text
        JLabel boardNameText = new JLabel(boardName,SwingConstants.LEFT);
        boardNameText.setPreferredSize(new Dimension(350,50));

        /*
        Add components to panel
        */

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        this.add(boardNameText,c);

        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        this.add(deleteBtn,c);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    //Select Arbitrary Board
    @Override
    public void mouseReleased(MouseEvent e) {
        boolean isFound = false;
        ArrayList<ArrayList<Cell>> tempBoard = new ArrayList<>();
        ArrayList<Cell> temp = new ArrayList<Cell>();

        try{
            Scanner sc = new Scanner(new File("arbitraries.txt"));

            while(sc.hasNextLine()){
                String buffer = sc.nextLine();

                if(buffer.matches("NEW BOARD")){
                    isFound = false;
                }
                if(isFound == true){
                    for(int i=0;i<buffer.length();i++){
                        switch (buffer.charAt(i)){
                            case '?':
                                temp.add(Cell.OUT);
                                break;
                            case 'p':
                                temp.add(Cell.PEG);
                                break;
                            case '.':
                                temp.add(Cell.EMPTY);
                                break;
                        }
                    }

                    tempBoard.add((ArrayList<Cell>) temp.clone());
                    temp.clear();
                }
                if(buffer.matches(boardName)){
                    isFound = true;
                }

            }
        }
        catch (Exception f){}

        frame.board.setBoard(tempBoard);
        frame.board.setFirstClickedCellX(-1);
        frame.board.setFirstClickedCellY(-1);
        frame.board.setSecondClickedCellX(-1);
        frame.board.setSecondClickedCellY(-1);
        frame.showSelectPlayerScreen();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
}
