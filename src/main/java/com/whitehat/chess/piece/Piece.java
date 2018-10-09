package com.whitehat.chess.piece;

import com.whitehat.chess.exception.InvalidMoveException;

public abstract class Piece {

	public static enum Color {
		WHITE, BLACK;

		public Color toggle() {
			if (this.equals(WHITE)) {
				return BLACK;
			} else {
				return WHITE;
			}
		}
	}

	protected final String ascii;

	protected final Color color;

	public Piece(Color color, String ascii) {
		this.color = color;
		this.ascii = ascii;
	}

	public abstract void validate(Piece[][] board, int[] move)
			throws InvalidMoveException;

	@Override
	public String toString() {
		return color.equals(Color.WHITE) ? ascii : ascii.toLowerCase();
	}

	public Color getColor() {
		return color;
	}

}
