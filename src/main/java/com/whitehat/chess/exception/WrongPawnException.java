package com.whitehat.chess.exception;

public class WrongPawnException extends InvalidMoveException {

	private static final long serialVersionUID = -8808325995690533137L;

	public WrongPawnException(int[] move) {
		super(move);
		// TODO Auto-generated constructor stub
	}

}
