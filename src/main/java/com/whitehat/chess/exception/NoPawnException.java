package com.whitehat.chess.exception;

public class NoPawnException extends InvalidMoveException {

	private static final long serialVersionUID = -8808325995690533137L;

	public NoPawnException(int[] move) {
		super(move);
		// TODO Auto-generated constructor stub
	}

}
