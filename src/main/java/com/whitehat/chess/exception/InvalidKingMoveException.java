package com.whitehat.chess.exception;

public class InvalidKingMoveException extends InvalidMoveException {

	private static final long serialVersionUID = 9082491829288653962L;

	public InvalidKingMoveException(int[] move) {
		super(move);
	}
}
