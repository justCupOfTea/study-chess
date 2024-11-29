package ru.example.study.chess.piece;

import ru.example.study.chess.ChessBoard;

/**
 * Шахматная фигура ладья
 */
public class Rook extends ChessPiece implements FirstMovePiece {

    /**
     * Признак, что шахматная фигура ходила
     */
    private boolean firstMove;

    public Rook(String color) {
        super(color, ChessSymbol.ROOK);
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
