package com.whitehat.chess.exception;

public class InvalidPawnMoveException extends InvalidMoveException {

	private static final long serialVersionUID = 9082491829288653962L;

	public InvalidPawnMoveException(int[] move) {
		super(move);
	}
}
