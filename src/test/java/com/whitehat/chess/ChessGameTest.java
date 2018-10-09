package com.whitehat.chess;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.whitehat.chess.Board.State;
import com.whitehat.chess.ChessGame;
import com.whitehat.chess.exception.InvalidMoveException;
import com.whitehat.chess.piece.Piece.Color;

public class ChessGameTest {

	private ChessGame game;

	@Test
	public void testSampleMoves() throws IOException, InvalidMoveException {
		game = new ChessGame("./data/sample-moves.txt", Color.BLACK);
		game.play();
	}

	@Test(expected = InvalidMoveException.class)
	public void testSampleMovesInvalid() throws IOException,
			InvalidMoveException {
		game = new ChessGame("./data/sample-moves-invalid.txt", Color.BLACK);
		game.play();
	}

	@Test
	public void testCheckmate() throws IOException, InvalidMoveException {
		game = new ChessGame("./data/checkmate.txt", Color.BLACK);
		game.play();

		assertEquals(game.getState(), State.CHECKMATE);
	}

}
