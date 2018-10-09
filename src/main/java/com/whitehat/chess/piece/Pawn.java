package com.whitehat.chess.piece;

import com.whitehat.chess.exception.InvalidMoveException;
import com.whitehat.chess.exception.InvalidPawnMoveException;

public class Pawn extends Piece {

	public Pawn(Color color) {
		super(color, "P");
	}

	@Override
	public void validate(Piece[][] board, int[] move)
			throws InvalidMoveException {
		int oldRow = move[1];
		int newRow = move[3];
		int oldCol = move[0];
		int newCol = move[2];
		int horizontalOffset = newCol - oldCol;
		int verticalOffset = newRow - oldRow;

		boolean valid = false;

		if (Math.abs(horizontalOffset) == 0 || Math.abs(horizontalOffset) == 1) {
			if (color.equals(Color.WHITE)) {
				if (verticalOffset > 0 && verticalOffset <= 2) {
					valid = true;
					if (verticalOffset == 2 && oldRow != 1) {
						valid = false;
					}
					if (verticalOffset == 2 && oldRow == 1
							&& board[oldCol][oldRow + 1] != null) {
						valid = false;
					}
				}
			} else if (color.equals(Color.BLACK)) {
				if (verticalOffset < 0 && verticalOffset >= -2) {
					valid = true;
					if (verticalOffset == -2 && oldRow != 6) {
						valid = false;
					}
					if (verticalOffset == 2 && oldRow == 6
							&& board[oldCol][oldRow - 1] != null) {
						valid = false;
					}
				}
			}
			if (Math.abs(horizontalOffset) == 0
					&& board[newCol][newRow] != null) {
				valid = false;
			}
			if (Math.abs(horizontalOffset) == 1
					&& board[newCol][newRow] == null) {
				valid = false;
			}

		}

		if (!valid) {
			throw new InvalidPawnMoveException(move);
		}
	}
}
