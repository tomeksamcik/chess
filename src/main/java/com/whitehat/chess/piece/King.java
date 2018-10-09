package com.whitehat.chess.piece;

import com.whitehat.chess.exception.InvalidKingMoveException;
import com.whitehat.chess.exception.InvalidMoveException;

public class King extends Piece {

	public King(Color color) {
		super(color, "K");
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

		if (Math.abs(verticalOffset) == 1 || Math.abs(horizontalOffset) == 1) {
			valid = true;
		}

		if (!valid) {
			throw new InvalidKingMoveException(move);
		}

	}

}
