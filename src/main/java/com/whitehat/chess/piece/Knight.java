package com.whitehat.chess.piece;

import com.whitehat.chess.exception.InvalidKnightMoveException;
import com.whitehat.chess.exception.InvalidMoveException;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color, "N");
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
		if ((Math.abs(verticalOffset) == 2 && Math.abs(horizontalOffset) == 1)
				|| (Math.abs(verticalOffset) == 1 && Math.abs(horizontalOffset) == 2)) {
			valid = true;
		}
		if (!valid) {
			throw new InvalidKnightMoveException(move);
		}
	}
}
