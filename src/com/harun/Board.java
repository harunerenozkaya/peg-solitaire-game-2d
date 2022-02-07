package com.harun;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private PegSolitaireGame frame;
    private ArrayList<ArrayList<Cell>> board;
    private ArrayList<ArrayList<Integer>> moves;
    private int boardType;
    private int playerType;
    private boolean gameStatus;
    private boolean isComputerGameStarted;

    private int firstClickedCellX;
    private int firstClickedCellY;
    private int secondClickedCellX;
    private int secondClickedCellY;

    public Board(PegSolitaireGame frame){
        board = new ArrayList<ArrayList<Cell>>();
        moves = new ArrayList<ArrayList<Integer>>();
        this.frame = frame;
        this.gameStatus = true;
        this.isComputerGameStarted = false;

        //Initialize clicked cells
        setFirstClickedCellX(-1);
        setFirstClickedCellY(-1);
        setSecondClickedCellX(-1);
        setSecondClickedCellY(-1);
    }

    public int getBoardType(){
        return boardType;
    }

    public void setBoardType(int type){
        boardType = type;
    }

    public Cell getCell(int x, int y){
        return board.get(x).get(y);
    }

    public void setCell(int x ,int y , Cell value){
        board.get(x).set(y,value);
    }

    public ArrayList<ArrayList<Cell>> getBoard(){
        return board;
    }

    public void setBoard(ArrayList<ArrayList<Cell>> newBoard){
        board = newBoard;
    }

    public int getPlayerType(){
        return playerType;
    }

    public void setPlayerType(int newPlayerType){
        playerType = newPlayerType;
    }

    public int getFirstClickedCellX() {
        return firstClickedCellX;
    }

    public int getFirstClickedCellY() {
        return firstClickedCellY;
    }

    public int getSecondClickedCellX() {
        return secondClickedCellX;
    }

    public int getSecondClickedCellY() {
        return secondClickedCellY;
    }

    public void setFirstClickedCellX(int firstClickedCellX) {
        this.firstClickedCellX = firstClickedCellX;
    }

    public void setFirstClickedCellY(int firstClickedCellY) {
        this.firstClickedCellY = firstClickedCellY;
    }

    public void setSecondClickedCellX(int secondClickedCellX) {
        this.secondClickedCellX = secondClickedCellX;
    }

    public void setSecondClickedCellY(int secondClickedCellY) {
        this.secondClickedCellY = secondClickedCellY;
    }

    public boolean getComputerGameStarted(){return isComputerGameStarted;}

    public void setComputerGameStarted(boolean val){this.isComputerGameStarted = val;}

    public ArrayList<ArrayList<Integer>> getMoves(){ return moves;}

    public boolean getGameStatus(){return gameStatus;}

    public void setGameStatus(boolean status){this.gameStatus = status;}

    public void initializeBoard(){
        ArrayList<Cell> row0 = new ArrayList<Cell>();
        ArrayList<Cell> row1 = new ArrayList<Cell>();
        ArrayList<Cell> row2 = new ArrayList<Cell>();
        ArrayList<Cell> row3 = new ArrayList<Cell>();
        ArrayList<Cell> row4 = new ArrayList<Cell>();
        ArrayList<Cell> row5 = new ArrayList<Cell>();
        ArrayList<Cell> row6 = new ArrayList<Cell>();
        ArrayList<Cell> row7 = new ArrayList<Cell>();
        ArrayList<Cell> row8 = new ArrayList<Cell>();

        board.clear();
        switch (getBoardType()){
            case 1:
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.PEG);
                row0.add(Cell.PEG);
                row0.add(Cell.PEG);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);

                board.add(row0);

                row1.add(Cell.OUT);
                row1.add(Cell.OUT);
                row1.add(Cell.PEG);
                row1.add(Cell.PEG);
                row1.add(Cell.PEG);
                row1.add(Cell.OUT);
                row1.add(Cell.OUT);

                board.add(row1);

                row2.add(Cell.OUT);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.OUT);

                board.add(row2);

                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.EMPTY);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);

                board.add(row3);

                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);

                board.add(row4);

                row5.add(Cell.OUT);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.OUT);

                board.add(row5);

                row6.add(Cell.OUT);
                row6.add(Cell.OUT);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.OUT);
                row6.add(Cell.OUT);

                board.add(row6);

                break;
            case 2:
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.PEG);
                row0.add(Cell.PEG);
                row0.add(Cell.PEG);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);

                board.add(row0);
                

                row1.add(Cell.OUT);
                row1.add(Cell.OUT);
                row1.add(Cell.OUT);
                row1.add(Cell.PEG);
                row1.add(Cell.PEG);
                row1.add(Cell.PEG);
                row1.add(Cell.OUT);
                row1.add(Cell.OUT);
                row1.add(Cell.OUT);

                board.add(row1);

                row2.add(Cell.OUT);
                row2.add(Cell.OUT);
                row2.add(Cell.OUT);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.OUT);
                row2.add(Cell.OUT);
                row2.add(Cell.OUT);

                board.add(row2);

                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);

                board.add(row3);

                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.EMPTY);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);

                board.add(row4);
                

                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);

                board.add(row5);
                

                row6.add(Cell.OUT);
                row6.add(Cell.OUT);
                row6.add(Cell.OUT);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.OUT);
                row6.add(Cell.OUT);
                row6.add(Cell.OUT);

                board.add(row6);
                

                row7.add(Cell.OUT);
                row7.add(Cell.OUT);
                row7.add(Cell.OUT);
                row7.add(Cell.PEG);
                row7.add(Cell.PEG);
                row7.add(Cell.PEG);
                row7.add(Cell.OUT);
                row7.add(Cell.OUT);
                row7.add(Cell.OUT);

                board.add(row7);
                

                row8.add(Cell.OUT);
                row8.add(Cell.OUT);
                row8.add(Cell.OUT);
                row8.add(Cell.PEG);
                row8.add(Cell.PEG);
                row8.add(Cell.PEG);
                row8.add(Cell.OUT);
                row8.add(Cell.OUT);
                row8.add(Cell.OUT);

                board.add(row8);
                
                break;
            case 3:
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.PEG);
                row0.add(Cell.PEG);
                row0.add(Cell.PEG);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);

                board.add(row0);
                

                row1.add(Cell.OUT);
                row1.add(Cell.OUT);
                row1.add(Cell.PEG);
                row1.add(Cell.PEG);
                row1.add(Cell.PEG);
                row1.add(Cell.OUT);
                row1.add(Cell.OUT);
                row1.add(Cell.OUT);

                board.add(row1);
                

                row2.add(Cell.OUT);
                row2.add(Cell.OUT);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.OUT);
                row2.add(Cell.OUT);
                row2.add(Cell.OUT);

                board.add(row2);
                

                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);

                board.add(row3);
                

                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.EMPTY);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);

                board.add(row4);
                

                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);

                board.add(row5);
                

                row6.add(Cell.OUT);
                row6.add(Cell.OUT);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.OUT);
                row6.add(Cell.OUT);
                row6.add(Cell.OUT);

                board.add(row6);
                

                row7.add(Cell.OUT);
                row7.add(Cell.OUT);
                row7.add(Cell.PEG);
                row7.add(Cell.PEG);
                row7.add(Cell.PEG);
                row7.add(Cell.OUT);
                row7.add(Cell.OUT);
                row7.add(Cell.OUT);

                board.add(row7);
                
                break;
            case 4:
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.PEG);
                row0.add(Cell.PEG);
                row0.add(Cell.PEG);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);

                board.add(row0);
                

                row1.add(Cell.OUT);
                row1.add(Cell.OUT);
                row1.add(Cell.PEG);
                row1.add(Cell.PEG);
                row1.add(Cell.PEG);
                row1.add(Cell.OUT);
                row1.add(Cell.OUT);

                board.add(row1);
                

                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);

                board.add(row2);
                

                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.EMPTY);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);

                board.add(row3);
                

                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);

                board.add(row4);
                

                row5.add(Cell.OUT);
                row5.add(Cell.OUT);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.OUT);
                row5.add(Cell.OUT);

                board.add(row5);
                

                row6.add(Cell.OUT);
                row6.add(Cell.OUT);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.OUT);
                row6.add(Cell.OUT);

                board.add(row6);
                
                break;
            case 5:
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.PEG);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);
                row0.add(Cell.OUT);

                board.add(row0);
                

                row1.add(Cell.OUT);
                row1.add(Cell.OUT);
                row1.add(Cell.OUT);
                row1.add(Cell.PEG);
                row1.add(Cell.PEG);
                row1.add(Cell.PEG);
                row1.add(Cell.OUT);
                row1.add(Cell.OUT);
                row1.add(Cell.OUT);

                board.add(row1);
                

                row2.add(Cell.OUT);
                row2.add(Cell.OUT);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.PEG);
                row2.add(Cell.OUT);
                row2.add(Cell.OUT);

                board.add(row2);
                

                row3.add(Cell.OUT);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.PEG);
                row3.add(Cell.OUT);

                board.add(row3);
                

                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.EMPTY);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);
                row4.add(Cell.PEG);

                board.add(row4);
                

                row5.add(Cell.OUT);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.PEG);
                row5.add(Cell.OUT);

                board.add(row5);
                

                row6.add(Cell.OUT);
                row6.add(Cell.OUT);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.PEG);
                row6.add(Cell.OUT);
                row6.add(Cell.OUT);

                board.add(row6);
                

                row7.add(Cell.OUT);
                row7.add(Cell.OUT);
                row7.add(Cell.OUT);
                row7.add(Cell.PEG);
                row7.add(Cell.PEG);
                row7.add(Cell.PEG);
                row7.add(Cell.OUT);
                row7.add(Cell.OUT);
                row7.add(Cell.OUT);

                board.add(row7);
                

                row8.add(Cell.OUT);
                row8.add(Cell.OUT);
                row8.add(Cell.OUT);
                row8.add(Cell.OUT);
                row8.add(Cell.PEG);
                row8.add(Cell.OUT);
                row8.add(Cell.OUT);
                row8.add(Cell.OUT);
                row8.add(Cell.OUT);

                board.add(row8);
                
                break;
        }
    }

    public void doMovement(){
        boolean isChanged = false;

        if(firstClickedCellX == secondClickedCellX){
            if(Math.abs((firstClickedCellY-secondClickedCellY)) == 2){
                if(firstClickedCellY > secondClickedCellY){
                    if(board.get(firstClickedCellY - 1).get(firstClickedCellX) == Cell.PEG){

                        //Change board
                        board.get(firstClickedCellY).set(firstClickedCellX,Cell.EMPTY);
                        board.get(firstClickedCellY-1).set(firstClickedCellX , Cell.EMPTY);
                        board.get(secondClickedCellY).set(secondClickedCellX,Cell.PEG);

                        isChanged = true;

                    }
                }
                else if(secondClickedCellY > firstClickedCellY){
                    if(board.get(firstClickedCellY + 1).get(firstClickedCellX) == Cell.PEG){

                        //Change board
                        board.get(firstClickedCellY).set(firstClickedCellX,Cell.EMPTY);
                        board.get(firstClickedCellY + 1).set(firstClickedCellX , Cell.EMPTY);
                        board.get(secondClickedCellY).set(secondClickedCellX,Cell.PEG);

                        isChanged = true;

                    }
                }

            }
        }
        else if(firstClickedCellY == secondClickedCellY){
            if(Math.abs((firstClickedCellX-secondClickedCellX)) == 2){
                if(firstClickedCellX > secondClickedCellX){
                    if(board.get(firstClickedCellY).get(firstClickedCellX-1) == Cell.PEG){

                        //Change board
                        board.get(firstClickedCellY).set(firstClickedCellX,Cell.EMPTY);
                        board.get(firstClickedCellY).set(firstClickedCellX-1 , Cell.EMPTY);
                        board.get(secondClickedCellY).set(secondClickedCellX,Cell.PEG);

                        isChanged = true;

                    }
                }
                else if(secondClickedCellX > firstClickedCellX){
                    if(board.get(firstClickedCellY).get(firstClickedCellX+1) == Cell.PEG){

                        //Change board
                        board.get(firstClickedCellY).set(firstClickedCellX,Cell.EMPTY);
                        board.get(firstClickedCellY).set(firstClickedCellX+1 , Cell.EMPTY);
                        board.get(secondClickedCellY).set(secondClickedCellX,Cell.PEG);

                        isChanged = true;
                    }
                }

            }
        }

        if(isChanged){
            //Add move to moves history arrayList
            ArrayList<Integer> move = new ArrayList<Integer>();
            move.add(firstClickedCellX);
            move.add(firstClickedCellY);
            move.add(secondClickedCellX);
            move.add(secondClickedCellY);

            moves.add(move);

        }

        //Reinitialize clicked cell
        setFirstClickedCellX(-1);
        setFirstClickedCellY(-1);
        setSecondClickedCellX(-1);
        setSecondClickedCellY(-1);

        isFinished();

        if(playerType == 0){
            frame.showGameHumanScreen();
        }
        else if(playerType == 1){
            frame.showGameComputerScreen();
        }

    }

    public ArrayList<Integer> getRandomMovement(){
        ArrayList<Integer> movementProperties = new ArrayList<Integer>();
        int boardVertical = board.size();
        int boardHorizontal = board.get(0).size();

        int movementVertical = ThreadLocalRandom.current().nextInt(0, boardVertical);
        int movementHorizontal = ThreadLocalRandom.current().nextInt(0, boardHorizontal);
        int directionIndex = ThreadLocalRandom.current().nextInt(0,4);

        movementProperties.add(movementVertical);
        movementProperties.add(movementHorizontal);
        movementProperties.add(directionIndex);

        return movementProperties;
    }

    public void doRandomMovement(){
        ArrayList<Integer> randomMovementProperties = getRandomMovement();

        int movementVertical = randomMovementProperties.get(0);
        int movementHorizontal = randomMovementProperties.get(1);
        int directionIndex = randomMovementProperties.get(2);

        boolean isValid = false;

        firstClickedCellY = movementVertical;
        firstClickedCellX = movementHorizontal;

        if(board.get(movementVertical).get(movementHorizontal) == Cell.PEG) {
            switch (directionIndex) {
                //Up
                case 0:
                    if(movementVertical > 2){
                        if(board.get(movementVertical-2).get(movementHorizontal) == Cell.EMPTY &&
                                board.get(movementVertical-1).get(movementHorizontal) == Cell.PEG)
                        {
                            secondClickedCellY = movementVertical - 2;
                            secondClickedCellX = movementHorizontal;
                            isValid = true;
                        }
                    }
                    break;
                //Down
                case 1:
                    if(movementVertical < board.size()-2){
                        if(board.get(movementVertical+2).get(movementHorizontal) == Cell.EMPTY &&
                                board.get(movementVertical+1).get(movementHorizontal) == Cell.PEG)
                        {
                            secondClickedCellY = movementVertical + 2;
                            secondClickedCellX = movementHorizontal;
                            isValid = true;
                        }
                    }
                    break;
                //Right
                case 2:
                    if(movementHorizontal < board.get(0).size()-2){
                        if(board.get(movementVertical).get(movementHorizontal+2) == Cell.EMPTY &&
                                board.get(movementVertical).get(movementHorizontal+1) == Cell.PEG)
                        {
                            secondClickedCellY = movementVertical;
                            secondClickedCellX = movementHorizontal + 2;
                            isValid = true;
                        }
                    }
                    break;
                //Left
                case 3:
                    if(movementHorizontal > 2){
                        if(board.get(movementVertical).get(movementHorizontal-2) == Cell.EMPTY &&
                                board.get(movementVertical).get(movementHorizontal-1) == Cell.PEG)
                        {
                            secondClickedCellY = movementVertical;
                            secondClickedCellX = movementHorizontal -2;
                            isValid = true;
                        }
                    }
                    break;
            }
        }

        if(isValid)
            doMovement();

        else
            doRandomMovement();

    }

    public void undo(){
        if(moves.size() != 0){
            int firstClickedX = moves.get(moves.size()-1).get(0);
            int firstClickedY = moves.get(moves.size()-1).get(1);
            int secondClickedX = moves.get(moves.size()-1).get(2);
            int secondClickedY = moves.get(moves.size()-1).get(3);

            //Set older status of first and second clicked cell
            board.get(firstClickedY).set(firstClickedX,Cell.PEG);
            board.get(secondClickedY).set(secondClickedX,Cell.EMPTY);

            //Set deprecated cell while doing movement
            if(firstClickedX == secondClickedX){
                if(firstClickedY > secondClickedY){
                    board.get(firstClickedY-1).set(firstClickedX,Cell.PEG);
                }

                else if(secondClickedY > firstClickedY){
                    board.get(firstClickedY+1).set(firstClickedX,Cell.PEG);
                }
            }
            else if(firstClickedY == secondClickedY){
                if(firstClickedX > secondClickedX){
                    board.get(firstClickedY).set(firstClickedX-1,Cell.PEG);
                }
                else if(secondClickedX > firstClickedX){
                    board.get(firstClickedY).set(firstClickedX+1,Cell.PEG);
                }
            }

            moves.remove(moves.size()-1);
        }
    }

    public void isFinished(){
        int vertical = board.size();
        int horizontal = board.get(0).size();
        boolean isFinish = true;

        for(int i=0; i<vertical;i++){
            for(int j=0; j<horizontal && isFinish == true; j++){

                if(board.get(i).get(j) == Cell.PEG){

                    if(j<=horizontal-3){

                        if(board.get(i).get(j+1) == Cell.PEG && board.get(i).get(j+2) == Cell.EMPTY)
                            isFinish = false;

                    }

                    if(j>=2){

                        if(board.get(i).get(j-1)== Cell.PEG && board.get(i).get(j-2) == Cell.EMPTY)
                            isFinish = false;
                    }

                    if(i >= 2){

                        if(board.get(i-1).get(j) == Cell.PEG && board.get(i-2).get(j) == Cell.EMPTY)
                            isFinish = false;
                    }

                    if(i <= vertical-3){

                        if(board.get(i+1).get(j) == Cell.PEG && board.get(i+2).get(j) == Cell.EMPTY)
                            isFinish = false;
                    }
                }
            }
        }

        gameStatus = !isFinish;
    }

    public int calculateFinalScore(){
        int horizontal = getBoard().get(0).size();
        int vertical = getBoard().size();
        int pegCount = 0;

        for(int i=0; i<vertical; i++){
            for(int j=0; j<horizontal; j++){
                if(board.get(i).get(j) == Cell.PEG)
                    pegCount += 1;
            }
        }

        return 225-pegCount*25;
    }
}
