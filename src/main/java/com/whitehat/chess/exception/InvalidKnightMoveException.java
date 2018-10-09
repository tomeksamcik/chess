package com.whitehat.chess.exception;

public class InvalidKnightMoveException extends InvalidMoveException {

	private static final long serialVersionUID = 9082491829288653962L;

	public InvalidKnightMoveException(int[] move) {
		super(move);
	}
}
