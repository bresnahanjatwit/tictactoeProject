package tictactoe;

public class board {
	
	public String[][] board = new String[3][3];
	
	int boardPos = 1;
	
	public void createBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = "" + boardPos;
				boardPos++;
			}
		}
	}
	
	public void printBoard() {
		for(int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print("|" + board[i][j] + "|" + " ");
			}
			System.out.printf("%n");
		}
	}
	
	public String[][] getBoard(){
		return board;
	}

}
