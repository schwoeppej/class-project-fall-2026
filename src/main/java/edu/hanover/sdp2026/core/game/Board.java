package edu.hanover.sdp2026.core.game;

import java.util.HashMap;
import java.util.Map;

public class Board {
    Map<Location, Piece> board = new HashMap<>();

    Board() {
    }

    Board boardFrom(Move move) {
        Board newBoard = this;
        newBoard.makeMove(move);
        return newBoard;
    }

    Piece getPiece(Location location) {
        return board.getOrDefault(location, null);
    }

    void putPiece(Location location, PieceType type, Color color) {
        if (getPiece(location) != null) throw new RuntimeException("space is occupied");
        board.put(location, new Piece(type, color));
    }

    void makeMove(Move move) {
        board.remove(move.getFrom());
        board.put(move.getTo(), move.getPiece());
    }

}
