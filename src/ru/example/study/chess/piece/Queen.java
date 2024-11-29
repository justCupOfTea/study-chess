package ru.example.study.chess.piece;

import ru.example.study.chess.ChessBoard;

/**
 * Шахматная фигура ферзь
 */
public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color, ChessSymbol.QUEEN);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
