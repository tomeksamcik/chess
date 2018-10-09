package com.whitehat.chess;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.whitehat.chess.Board.State;
import com.whitehat.chess.exception.InvalidMoveException;
import com.whitehat.chess.piece.Piece.Color;
import com.whitehatgaming.UserInput;
import com.whitehatgaming.UserInputFile;

public class ChessGame {

	private UserInput input;

	private Board board;

	private Color color;

	public ChessGame(String inputFile, Color color)
			throws FileNotFoundException {
		input = new UserInputFile(inputFile);
		board = new Board();
		this.color = color;
	}

	public void play() throws IOException, InvalidMoveException {
		int[] move;
		board.print();
		while ((move = input.nextMove()) != null) {
			System.out.println("\n" + move[0] + "" + move[1] + " -> " + move[2]
					+ "" + move[3] + " " + color + " ("
					+ board.getBoard()[move[0]][move[1]].toString() + ")\n");
			board.move(move, color);
			board.print();
			color = color.toggle();
		}
	}

	public void print() {
		board.print();
	}

	public State getState() {
		return board.getState();
	}

	public static void main(String[] args) throws IOException,
			InvalidMoveException {
		// ChessGame game = new ChessGame("./data/sample-moves.txt",
		// Color.BLACK);
		// ChessGame game = new ChessGame("./data/test-pawn.txt", Color.WHITE);
		ChessGame game = new ChessGame("./data/checkmate.txt", Color.BLACK);
		game.play();
		// new ChessGame("./data/sample-moves-invalid.txt").play();
	}
}
