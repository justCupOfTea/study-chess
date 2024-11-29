package ru.example.study.chess.piece;

import ru.example.study.chess.ChessBoard;

/**
 * Шахматная фигура конь
 */
public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color, ChessSymbol.HORSE);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
