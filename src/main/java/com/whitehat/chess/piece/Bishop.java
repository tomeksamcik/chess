package com.whitehat.chess.piece;

import com.whitehat.chess.exception.InvalidBishopMoveException;
import com.whitehat.chess.exception.InvalidMoveException;

public class Bishop extends Piece {

	public Bishop(Color color) {
		super(color, "B");
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

		if (Math.abs(verticalOffset) == Math.abs(horizontalOffset)) {
			valid = true;

			int rowOffset = oldRow < newRow ? 1 : -1;
			int colOffset = oldCol < newCol ? 1 : -1;

			int x = oldRow;
			int y = oldCol;
			while (x != newRow && y != newCol) {
				if (board[x][y] != null) {
					valid = false;
				}
				x += rowOffset;
				y += colOffset;
			}
		}

		if (!valid) {
			throw new InvalidBishopMoveException(move);
		}
	}
}
