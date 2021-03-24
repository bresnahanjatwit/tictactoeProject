package tictactoe;
import java.util.Scanner;
public class tictactoe {
	     public static void main(String[] args) {
	         System.out.println("Welcome to Tic Tac Toe!");
	         System.out.println();

	         String marker1 = "x";
	         String marker2 = "o";
	         boolean playAgain = true;

	         Scanner s = new Scanner(System.in);



	         player1 player1 = new player1();
	         computer computer = new computer();

	         while(playAgain){
	             board Setup = new board();

	             Setup.createBoard();
	             Setup.printBoard();

	             System.out.println("please choose your marker");
	             System.out.println("type 1 for 'x' or 2 for 'o'");

	             //set markers
	             if(s.nextInt() == 1){
	                 // create player objects
	                 player1.setMarker("x");
	                 computer.setMarker("o");
	             } 
	             else
	             {
	                 player1.setMarker("o");
	                 computer.setMarker("x");

	             }

				
	         }
	     }
}