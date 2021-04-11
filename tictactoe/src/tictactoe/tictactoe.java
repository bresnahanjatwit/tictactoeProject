package tictactoe;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
public class tictactoe extends Application{
	
	Label menuTop = new Label ("Welcome to Tic Tac Toe! Choose your marker!");
	Label turn = new Label("Player One's Turn");
	
	Label sbTop = new Label ("Current Score");
	
	player1 playerOne = new player1();
	player2 playerTwo = new player2();
	
	boolean player1Turn = true;
	boolean player2Turn = false;
	
	int p1Wins = 0;
	int p2Wins = 0;
	
	String[][] gameBoard = new String[3][3];
	
	Button topLeft = new Button(" ");
	Button topMiddle = new Button(" ");
	Button topRight = new Button(" ");
	Button middleLeft = new Button(" ");
	Button middleMiddle = new Button(" ");
	Button middleRight = new Button(" ");
	Button bottomLeft = new Button(" ");
	Button bottomMiddle = new Button(" ");
	Button bottomRight = new Button(" ");
	Button reset = new Button("Reset Game");
	Button markerX = new Button("X's");
	Button markerO = new Button("O's");
	
	
	
	public Stage tttGame() {
		
		GridPane gameGrid = new GridPane();
		BorderPane root = new BorderPane();
		HBox bottomBanner = new HBox();
		
		topLeft.setMinSize(150, 150);
		topMiddle.setMinSize(150, 150);
		topRight.setMinSize(150, 150);
		middleLeft.setMinSize(150, 150);
		middleMiddle.setMinSize(150, 150);
		middleRight.setMinSize(150, 150);
		bottomLeft.setMinSize(150, 150);
		bottomMiddle.setMinSize(150, 150);
		bottomRight.setMinSize(150, 150);
		
		gameGrid.add(topLeft, 0,0);
		gameGrid.add(topMiddle, 1,0);
		gameGrid.add(topRight, 2,0);
		gameGrid.add(middleLeft, 0,1);
		gameGrid.add(middleMiddle, 1,1);
		gameGrid.add(middleRight, 2,1);
		gameGrid.add(bottomLeft, 0,2);
		gameGrid.add(bottomMiddle, 1,2);
		gameGrid.add(bottomRight, 2,2);
		
		bottomBanner.getChildren().add(reset);
		bottomBanner.getChildren().add(turn);
		bottomBanner.setAlignment(Pos.CENTER);
		bottomBanner.setSpacing(40);
		
		root.setCenter(gameGrid);
		root.setBottom(bottomBanner);
		
		Stage tttGame = new Stage();
		Scene display = new Scene(root, 500, 500);
		tttGame.setScene(display);
		tttGame.setTitle("Tic Tac Toe");
		tttGame.show();
		
		
		reset.setOnAction(event ->{
			topLeft.setText(" ");
			topLeft.setDisable(false);
			topMiddle.setText(" ");
			topMiddle.setDisable(false);
			topRight.setText(" ");
			topRight.setDisable(false);
			middleLeft.setText(" ");
			middleLeft.setDisable(false);
			middleMiddle.setText(" ");
			middleMiddle.setDisable(false);
			middleRight.setText(" ");
			middleRight.setDisable(false);
			bottomLeft.setText(" ");
			bottomLeft.setDisable(false);
			bottomMiddle.setText(" ");
			bottomMiddle.setDisable(false);
			bottomRight.setText(" ");
			bottomRight.setDisable(false);
			
			player1Turn = true;
			player2Turn = false;
			turn.setText("Player One's Turn");
			
			for(int i = 0; i < gameBoard.length; i++) {
				for(int j = 0; j < gameBoard[i].length; j++) {
					gameBoard[i][j] = " ";
				}
			}
			
			tttGame.close();
			gameMenu();
		});
		
		
		topLeft.setOnAction(event ->{
			if(player1Turn) {
				topLeft.setText(playerOne.getMarker());
				
				gameBoard[0][0] = playerOne.getMarker();
				
				player1Turn = false;
				player2Turn = true;
				turn.setText("Player Two's Turn");
			}
			else {
				topLeft.setText(playerTwo.getMarker());
				
				gameBoard[0][0] = playerTwo.getMarker();
				
				player1Turn = true;
				player2Turn = false;
				turn.setText("Player One's Turn");
			}
			topLeft.setDisable(true);
			
			if(checkWin(gameBoard, playerOne.getMarker()) == true) {
				turn.setText("Player One Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p1Wins++;
				scoreBoard();
			}
			if(checkWin(gameBoard, playerTwo.getMarker()) == true) {
				turn.setText("Player Two Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p2Wins++;
				scoreBoard();
			}
		});
		
		topMiddle.setOnAction(event ->{
			if(player1Turn) {
				topMiddle.setText(playerOne.getMarker());
				
				gameBoard[0][1] = playerOne.getMarker();
				
				player1Turn = false;
				player2Turn = true;
				turn.setText("Player Two's Turn");
			}
			else {
				topMiddle.setText(playerTwo.getMarker());
				
				gameBoard[0][1] = playerTwo.getMarker();
				
				player1Turn = true;
				player2Turn = false;
				turn.setText("Player One's Turn");
			}
			topMiddle.setDisable(true);
			
			if(checkWin(gameBoard, playerOne.getMarker()) == true) {
				turn.setText("Player One Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p1Wins++;
				scoreBoard();
			}
			if(checkWin(gameBoard, playerTwo.getMarker()) == true) {
				turn.setText("Player Two Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p2Wins++;
				scoreBoard();
			}
		});
		
		topRight.setOnAction(event ->{
			if(player1Turn) {
				topRight.setText(playerOne.getMarker());
				
				gameBoard[0][2] = playerOne.getMarker();
				
				player1Turn = false;
				player2Turn = true;
				turn.setText("Player Two's Turn");
			}
			else {
				topRight.setText(playerTwo.getMarker());
				
				gameBoard[0][2] = playerTwo.getMarker();
				
				player1Turn = true;
				player2Turn = false;
				turn.setText("Player One's Turn");
			}
			topRight.setDisable(true);
			
			if(checkWin(gameBoard, playerOne.getMarker()) == true) {
				turn.setText("Player One Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p1Wins++;
				scoreBoard();
			}
			if(checkWin(gameBoard, playerTwo.getMarker()) == true) {
				turn.setText("Player Two Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p2Wins++;
				scoreBoard();
			}
		});
		
		middleLeft.setOnAction(event ->{
			if(player1Turn) {
				middleLeft.setText(playerOne.getMarker());
				
				gameBoard[1][0] = playerOne.getMarker();
				
				player1Turn = false;
				player2Turn = true;
				turn.setText("Player Two's Turn");
			}
			else {
				middleLeft.setText(playerTwo.getMarker());
				
				gameBoard[1][0] = playerTwo.getMarker();
				
				player1Turn = true;
				player2Turn = false;
				turn.setText("Player One's Turn");
			}
			middleLeft.setDisable(true);
			
			if(checkWin(gameBoard, playerOne.getMarker()) == true) {
				turn.setText("Player One Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p1Wins++;
				scoreBoard();
			}
			if(checkWin(gameBoard, playerTwo.getMarker()) == true) {
				turn.setText("Player Two Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p2Wins++;
				scoreBoard();
			}
		});
		
		middleMiddle.setOnAction(event ->{
			if(player1Turn) {
				middleMiddle.setText(playerOne.getMarker());
				
				gameBoard[1][1] = playerOne.getMarker();
				
				player1Turn = false;
				player2Turn = true;
				turn.setText("Player Two's Turn");
			}
			else {
				middleMiddle.setText(playerTwo.getMarker());
				
				gameBoard[1][1] = playerTwo.getMarker();
				
				player1Turn = true;
				player2Turn = false;
				turn.setText("Player One's Turn");
			}
			middleMiddle.setDisable(true);
			
			if(checkWin(gameBoard, playerOne.getMarker()) == true) {
				turn.setText("Player One Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p1Wins++;
				scoreBoard();
			}
			if(checkWin(gameBoard, playerTwo.getMarker()) == true) {
				turn.setText("Player Two Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p2Wins++;
				scoreBoard();
			}
		});
		
		middleRight.setOnAction(event ->{
			if(player1Turn) {
				middleRight.setText(playerOne.getMarker());
				
				gameBoard[1][2] = playerOne.getMarker();
				
				player1Turn = false;
				player2Turn = true;
				turn.setText("Player Two's Turn");
			}
			else {
				middleRight.setText(playerTwo.getMarker());
				
				gameBoard[1][2] = playerTwo.getMarker();
				
				player1Turn = true;
				player2Turn = false;
				turn.setText("Player One's Turn");
			}
			middleRight.setDisable(true);
			
			if(checkWin(gameBoard, playerOne.getMarker()) == true) {
				turn.setText("Player One Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p1Wins++;
				scoreBoard();
			}
			if(checkWin(gameBoard, playerTwo.getMarker()) == true) {
				turn.setText("Player Two Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p2Wins++;
				scoreBoard();
			}
		});
		
		bottomLeft.setOnAction(event ->{
			if(player1Turn) {
				bottomLeft.setText(playerOne.getMarker());
				
				gameBoard[2][0] = playerOne.getMarker();
				
				player1Turn = false;
				player2Turn = true;
				turn.setText("Player Two's Turn");
			}
			else {
				bottomLeft.setText(playerTwo.getMarker());
				
				gameBoard[2][0] = playerTwo.getMarker();
				
				player1Turn = true;
				player2Turn = false;
				turn.setText("Player One's Turn");
			}
			bottomLeft.setDisable(true);
			
			if(checkWin(gameBoard, playerOne.getMarker()) == true) {
				turn.setText("Player One Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p1Wins++;
				scoreBoard();
			}
			if(checkWin(gameBoard, playerTwo.getMarker()) == true) {
				turn.setText("Player Two Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p2Wins++;
				scoreBoard();
			}
		});
		
		bottomMiddle.setOnAction(event ->{
			if(player1Turn) {
				bottomMiddle.setText(playerOne.getMarker());
				
				gameBoard[2][1] = playerOne.getMarker();
				
				player1Turn = false;
				player2Turn = true;
				turn.setText("Player Two's Turn");
			}
			else {
				bottomMiddle.setText(playerTwo.getMarker());
				
				gameBoard[2][1] = playerTwo.getMarker();
				
				player1Turn = true;
				player2Turn = false;
				turn.setText("Player One's Turn");
			}
			bottomMiddle.setDisable(true);
			
			if(checkWin(gameBoard, playerOne.getMarker()) == true) {
				turn.setText("Player One Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p1Wins++;
				scoreBoard();
			}
			if(checkWin(gameBoard, playerTwo.getMarker()) == true) {
				turn.setText("Player Two Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p2Wins++;
				scoreBoard();
			}
		});
		
		bottomRight.setOnAction(event ->{
			if(player1Turn) {
				bottomRight.setText(playerOne.getMarker());
				
				gameBoard[2][2] = playerOne.getMarker();
				
				player1Turn = false;
				player2Turn = true;
				turn.setText("Player Two's Turn");
			}
			else {
				bottomRight.setText(playerTwo.getMarker());
				
				gameBoard[2][2] = playerTwo.getMarker();
				
				player1Turn = true;
				player2Turn = false;
				turn.setText("Player One's Turn");
			}
			bottomRight.setDisable(true);
			
			if(checkWin(gameBoard, playerOne.getMarker()) == true) {
				turn.setText("Player One Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p1Wins++;
				scoreBoard();
			}
			if(checkWin(gameBoard, playerTwo.getMarker()) == true) {
				turn.setText("Player Two Wins!");
				topLeft.setDisable(true);
				topMiddle.setDisable(true);
				topRight.setDisable(true);
				middleLeft.setDisable(true);
				middleMiddle.setDisable(true);
				middleRight.setDisable(true);
				bottomLeft.setDisable(true);
				bottomMiddle.setDisable(true);
				bottomRight.setDisable(true);
				p2Wins++;
				scoreBoard();
			}
		});
		
		
		return tttGame;
	}
	
	public Stage gameMenu() {
		BorderPane root = new BorderPane();
		HBox topBanner = new HBox();
		HBox middleBanner = new HBox();
		
		topBanner.getChildren().add(menuTop);
		topBanner.setAlignment(Pos.CENTER);
		middleBanner.getChildren().add(markerX);
		middleBanner.getChildren().add(markerO);
		middleBanner.setAlignment(Pos.CENTER);
		middleBanner.setSpacing(20);
		
		root.setTop(topBanner);
		root.setCenter(middleBanner);
		
		Stage gameMenu = new Stage();
		Scene display = new Scene(root, 300, 300);
		gameMenu.setScene(display);
		gameMenu.setTitle("Tic Tac Toe Menu");
		gameMenu.show();
		
		markerX.setOnAction(event ->{
			
			playerOne.setMarker("X");
			playerTwo.setMarker("O");
			gameMenu.close();
			tttGame();
			
		});	
		
		markerO.setOnAction(event ->{
			
			playerOne.setMarker("O");
			playerTwo.setMarker("X");
			gameMenu.close();
			tttGame();
			
		});	
		
		return gameMenu;
		
		
	}
	
	public Stage scoreBoard() {
		BorderPane root = new BorderPane();
		HBox topBanner = new HBox();
		HBox middleBanner = new HBox();
		
		Button p1Score = new Button("P1: " + p1Wins);
		Button p2Score = new Button("P2: " + p2Wins);
		
		topBanner.getChildren().add(sbTop);
		topBanner.setAlignment(Pos.CENTER);
		middleBanner.getChildren().add(p1Score);
		middleBanner.getChildren().add(p2Score);
		middleBanner.setAlignment(Pos.CENTER);
		middleBanner.setSpacing(20);
		
		root.setTop(topBanner);
		root.setCenter(middleBanner);
		
		Stage scoreBoard = new Stage();
		Scene display = new Scene(root, 300, 300);
		scoreBoard.setScene(display);
		scoreBoard.setTitle("Score Board");
		scoreBoard.show();
		
		
		p1Score.setDisable(true);
		p2Score.setDisable(true);
		
		p1Score.setMinSize(100, 100);
		p2Score.setMinSize(100, 100);
		
		reset.addEventHandler(ActionEvent.ACTION, event ->{
			scoreBoard.close();
		});
		
		return scoreBoard;
		
	}
	
	public boolean checkWin(String[][] board, String marker) {
		if(board[0][0] == marker && board[0][1] == marker && board[0][2] == marker) {
			return true;
		}
		if(board[1][0] == marker && board[1][1] == marker && board[1][2] == marker) {
			return true;
		}
		if(board[2][0] == marker && board[2][1] == marker && board[2][2] == marker) {
			return true;
		}
		if(board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) {
			return true;
		}
		if(board[0][2] == marker && board[1][1] == marker && board[2][20] == marker) {
			return true;
		}
		if(board[0][0] == marker && board[1][0] == marker && board[2][0] == marker) {
			return true;
		}
		if(board[0][1] == marker && board[1][1] == marker && board[2][1] == marker) {
			return true;
		}
		if(board[0][2] == marker && board[1][2] == marker && board[2][2] == marker) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		
		gameMenu();
		
	}
	
	     public static void main(String[] args) {
	    	 launch(args);
	    	 
	    	 
	    	
	     }
	     
}