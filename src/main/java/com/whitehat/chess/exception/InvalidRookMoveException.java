package com.whitehat.chess.exception;

public class InvalidRookMoveException extends InvalidMoveException {

	private static final long serialVersionUID = 9082491829288653962L;

	public InvalidRookMoveException(int[] move) {
		super(move);
	}
}
