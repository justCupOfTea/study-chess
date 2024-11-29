package ru.example.study.chess.piece;

import ru.example.study.chess.ChessBoard;

/**
 * Шахматная фигура слон
 */
public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color, ChessSymbol.BISHOP);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
