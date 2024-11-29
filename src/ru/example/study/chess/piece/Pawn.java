package ru.example.study.chess.piece;

import ru.example.study.chess.ChessBoard;

/**
 * Шахматная фигура пешка
 */
public class Pawn extends ChessPiece implements FirstMovePiece {

    /**
     * Признак, что шахматная фигура ходила
     */
    private boolean firstMove;

    public Pawn(String color) {
        super(color, ChessSymbol.PAWN);
        this.firstMove = true;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void negateFirstMove() {
        this.firstMove = false;
    }

    @Override
    public boolean isFirstMove() {
        return firstMove;
    }
}
