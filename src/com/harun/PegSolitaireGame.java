package com.harun;

import com.harun.ui.*;

import javax.swing.*;
import javax.swing.text.html.ListView;
import java.awt.*;
import java.util.ArrayList;

public class PegSolitaireGame extends JFrame implements Cloneable{

    private JPanel mainGamePanel;
    public Board board;

    public PegSolitaireGame(){
        super("Peg Solitaire Game");
        board = new Board(this);

        //Set frame resolution settings
        setSize(1280,720);
        setMinimumSize(new Dimension(1350,800));

        //Add main panel to frame
        mainGamePanel = new JPanel();
        add(mainGamePanel);

        //Open Menu Panel
        showMainMenu();

        setVisible(true);
    }

    //This function clear mainGamePanel and add MenuUi to show Main Menu Screen
    public void showMainMenu(){
        mainGamePanel.removeAll();
        mainGamePanel.add(new MenuUi(this));
        mainGamePanel.revalidate();
        mainGamePanel.repaint();
    }

    //This function clear mainGamePanel and add LoadGameUi to show Load Game Screen
    public void showLoadGameScreen(){
        mainGamePanel.removeAll();
        mainGamePanel.add(new LoadGameUi(this));
        mainGamePanel.revalidate();
        mainGamePanel.repaint();
    }

    //This function clear mainGamePanel and add SelectBoardUi to show Select Board Screen
    public void showSelectBoardScreen(){
        mainGamePanel.removeAll();
        mainGamePanel.add(new SelectBoardUi(this));
        mainGamePanel.revalidate();
        mainGamePanel.repaint();
    }

    //This function clear mainGamePanel and add LoadArbitraryBoardUi to show Load Arbitrary Board Screen
    public void showLoadArbitraryBoardScreen(){
        mainGamePanel.removeAll();
        mainGamePanel.add(new LoadArbitraryBoardUi(this));
        mainGamePanel.revalidate();
        mainGamePanel.repaint();
    }

    //This function clear mainGamePanel and add SelectPlayerUi to show Select Player Screen
    public void showSelectPlayerScreen(){
        mainGamePanel.removeAll();
        mainGamePanel.add(new SelectPlayerUi(this));
        mainGamePanel.revalidate();
        mainGamePanel.repaint();
    }

    //This function clear mainGamePanel and add GameHumanUi to show Game Human Screen
    public void showGameHumanScreen(){
        mainGamePanel.removeAll();
        mainGamePanel.add(new GameHumanUi(this));
        mainGamePanel.revalidate();
        mainGamePanel.repaint();
    }

    //This function clear mainGamePanel and add GameComputerUi to show Game Computer Screen
    public void showGameComputerScreen(){
        mainGamePanel.removeAll();
        mainGamePanel.add(new GameComputerUi(this));
        mainGamePanel.revalidate();
        mainGamePanel.repaint();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PegSolitaireGame pg = new PegSolitaireGame();
        pg.board = this.board;
        pg.mainGamePanel = this.mainGamePanel;
        return pg;
    }
}
