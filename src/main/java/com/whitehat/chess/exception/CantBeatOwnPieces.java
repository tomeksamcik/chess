package com.whitehat.chess.exception;

public class CantBeatOwnPieces extends InvalidMoveException {

	private static final long serialVersionUID = -8808325995690533137L;

	public CantBeatOwnPieces(int[] move) {
		super(move);
	}

}
