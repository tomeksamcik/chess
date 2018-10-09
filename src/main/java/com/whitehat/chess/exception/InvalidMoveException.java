package com.whitehat.chess.exception;

public class InvalidMoveException extends Exception {

	private static final long serialVersionUID = 9082491829288653962L;

	public InvalidMoveException(int[] move) {
		super(move[0] + "" + move[1] + " - " + move[2] + "" + move[3]);
	}

}
