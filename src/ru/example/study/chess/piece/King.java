package ru.example.study.chess.piece;

import ru.example.study.chess.ChessBoard;

/**
 * Шахматная фигура король
 */
public class King extends ChessPiece implements FirstMovePiece {
    /**
     * Признак, что шахматная фигура ходила
     */
    private boolean firstMove;

    public King(String color) {
        super(color, ChessSymbol.KING);
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

    /**
     * Проверяет, находится ли король под шахом
     *
     * @param chessBoard шахматная доска
     * @param line       позиция шахматной фигуры на линии
     * @param column     позиция шахматной фигуры в колонке
     * @return true, если под шахом
     */
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
