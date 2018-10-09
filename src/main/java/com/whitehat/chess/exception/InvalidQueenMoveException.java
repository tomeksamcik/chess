package com.whitehat.chess.exception;

public class InvalidQueenMoveException extends InvalidMoveException {

	private static final long serialVersionUID = 9082491829288653962L;

	public InvalidQueenMoveException(int[] move) {
		super(move);
	}
}
