package com.whitehat.chess.exception;

public class InvalidBishopMoveException extends InvalidMoveException {

	private static final long serialVersionUID = 9082491829288653962L;

	public InvalidBishopMoveException(int[] move) {
		super(move);
	}
}
