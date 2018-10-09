package com.whitehat.chess.piece;

import com.whitehat.chess.exception.InvalidMoveException;
import com.whitehat.chess.exception.InvalidRookMoveException;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color, "R");
	}

	@Override
	public void validate(Piece[][] board, int[] move)
			throws InvalidMoveException {
		int oldRow = move[1];
		int newRow = move[3];
		int oldCol = move[0];
		int newCol = move[2];

		boolean valid = false;

		if (newRow == oldRow || newCol == oldCol) {
			if (newRow == oldRow) {
				valid = true;
				for (int i = oldCol + 1; i <= newCol; i++) {
					if (board[i][newRow] != null) {
						valid = false;
					}
				}
			} else if (newCol == oldCol) {
				valid = true;
				for (int i = oldRow + 1; i <= newRow; i++) {
					if (board[newCol][i] != null) {
						valid = false;
					}
				}
			}
		}

		if (!valid) {
			throw new InvalidRookMoveException(move);
		}
	}
}
