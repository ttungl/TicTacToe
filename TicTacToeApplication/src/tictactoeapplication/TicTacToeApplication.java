/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeapplication;

import java.util.Scanner;

/**
 *
 * @author tungthanhle
 */
public class TicTacToeApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // getting input
        Scanner sc = new Scanner(System.in);
        // allows cont. games
        boolean doYouWantToPlay = true;
        while(doYouWantToPlay){
            // setting tokens and AI
            System.out.println("Welcome to TicTacToe!" 
                    + "Pick the characters for playing!");
            System.out.println();
            System.out.println("Enter a single character that will represent you on the board");
            char playerToken = sc.next().charAt(0);
            System.out.println("Enter a single character that will represent your opponent on the board");
            char opponentToken = sc.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();
            
            // setup the game
            System.out.println();
            System.out.println("To play, enter a number and your token shall be put "
                                + " in its place. The numbers go from 1-9, left to right, let's see who is going to win this round.");
            TicTacToe.printIndexBoard();
            System.out.println();
            
            // let's play
            while(game.gameOver().equals("Not over yet! Go ahead!")){
                if (game.currentMarker==game.userMarker){
                    // user turns
                    System.out.println("It's your turn! Enter a spot for your token");
                    int spot = sc.nextInt();
                    while(!game.playTurn(spot)){
                        System.out.println("Try again" +  spot + " is invalid. This spot is already taken" 
                                + " or it is out of range.");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked "+ spot + "!");
                } else {
                    // AI turns
                    System.out.println("It's my turn!");
                    // pick spot
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked "+ aiSpot +"!");
                    
                }
                // print out new board
                System.out.println();
                game.printBoard();            
            }
            System.out.println(game.gameOver());
            System.out.println();
            // setup new game
            System.out.println("Do you want to play again? Enter Y, otherwise.");
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response == 'Y');
            System.out.println();
            System.out.println();
        }
    }
}
