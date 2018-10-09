package com.whitehat.chess.piece;

import com.whitehat.chess.exception.InvalidMoveException;
import com.whitehat.chess.exception.InvalidQueenMoveException;

public class Queen extends Piece {

	public Queen(Color color) {
		super(color, "Q");
	}

	@Override
	public void validate(Piece[][] board, int[] move)
			throws InvalidMoveException {
		boolean valid = false;
		try {
			new Bishop(color).validate(board, move);
			valid = true;
		} catch (InvalidMoveException e) {
			// Do nothing
		}
		try {
			new Rook(color).validate(board, move);
			valid = true;
		} catch (InvalidMoveException e) {
			// Do nothing
		}

		if (!valid) {
			throw new InvalidQueenMoveException(move);
		}
	}

}
