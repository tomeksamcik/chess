package com.whitehat.chess;

import static com.whitehat.chess.piece.Piece.Color.BLACK;
import static com.whitehat.chess.piece.Piece.Color.WHITE;

import com.whitehat.chess.exception.CantBeatOwnPieces;
import com.whitehat.chess.exception.InvalidMoveException;
import com.whitehat.chess.exception.NoPawnException;
import com.whitehat.chess.exception.WrongPawnException;
import com.whitehat.chess.piece.Bishop;
import com.whitehat.chess.piece.King;
import com.whitehat.chess.piece.Knight;
import com.whitehat.chess.piece.Pawn;
import com.whitehat.chess.piece.Piece;
import com.whitehat.chess.piece.Piece.Color;
import com.whitehat.chess.piece.Queen;
import com.whitehat.chess.piece.Rook;

public class Board {

	public static enum State {
		IN_PROGRESS, CHECK, CHECKMATE
	};

	private final int ROWS = 8;
	private final int COLS = 8;

	private Piece[][] board = new Piece[COLS][ROWS];

	private State state = State.IN_PROGRESS;

	public Board() {
		initializeBoard();
		initializePieces();
	}

	private void initializeBoard() {
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				board[x][y] = null;
			}
		}
	}

	private void initializePieces() {

		for (int x = 0; x < COLS; x++) {
			board[x][1] = new Pawn(WHITE);
		}

		for (int x = 0; x < COLS; x++) {
			board[x][6] = new Pawn(BLACK);
		}

		board[0][0] = new Rook(WHITE);
		board[7][0] = new Rook(WHITE);
		board[7][7] = new Rook(BLACK);
		board[0][7] = new Rook(BLACK);

		board[1][0] = new Knight(WHITE);
		board[6][0] = new Knight(WHITE);
		board[6][7] = new Knight(BLACK);
		board[1][7] = new Knight(BLACK);

		board[2][0] = new Bishop(WHITE);
		board[5][0] = new Bishop(WHITE);
		board[2][7] = new Bishop(BLACK);
		board[5][7] = new Bishop(BLACK);

		board[3][0] = new Queen(WHITE);
		board[3][7] = new Queen(BLACK);

		board[4][0] = new King(WHITE);
		board[4][7] = new King(BLACK);

	}

	public void move(int[] move, Color color) throws InvalidMoveException {
		validateField(move, color);

		Piece piece = board[move[0]][move[1]];
		piece.validate(board, move);
		board[move[0]][move[1]] = null;
		board[move[2]][move[3]] = piece;
	}

	private void validateField(int[] move, Color color)
			throws InvalidMoveException {

		if (board[move[0]][move[1]] == null) {
			throw new NoPawnException(move);
		}

		if (color != null) {
			if (!board[move[0]][move[1]].getColor().equals(color)) {
				throw new WrongPawnException(move);
			}

			if (board[move[2]][move[3]] != null) {
				if (board[move[2]][move[3]].getColor().equals(color)) {
					throw new CantBeatOwnPieces(move);
				}
			}
		}

	}

	public void print() {
		for (int y = 0; y < board[0].length; y++) {
			StringBuilder row = new StringBuilder();
			for (int x = 0; x < board.length; x++) {
				String piece = board[x][y] != null ? board[x][y].toString()
						: ".";
				row.append(piece + " ");
			}
			System.out.println(row.toString());
		}
	}

	public State getState() {
		return state;
	}

	public Piece[][] getBoard() {
		return board;
	}
}