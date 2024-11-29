package ru.example.study.chess.piece;

import ru.example.study.chess.ChessBoard;
import ru.example.study.chess.Color;

/**
 * Шахматная фигура
 */
public abstract class ChessPiece {

    /**
     * Цвет фигуры
     */
    private final Color color;
    /**
     * Символ фигуры
     */
    private final ChessSymbol chessSymbol;

    public ChessPiece(String color, ChessSymbol chessSymbol) {
        this.color = Color.of(color);
        this.chessSymbol = chessSymbol;
    }

    /**
     * Проверяет, может ли шахматная фигура ходить
     *
     * @param chessBoard  шахматная доска
     * @param startLine   начальная линия
     * @param startColumn начальная колонка
     * @param endLine     конечная линия
     * @param endColumn   конечная колонка
     * @return true, если может
     */
    public abstract boolean canMoveToPosition(ChessBoard chessBoard,
                                              int startLine,
                                              int startColumn,
                                              int endLine,
                                              int endColumn);

    /**
     * Возвращает символ шахматной фигуры
     *
     * @return символ шахматной фигуры
     */
    public final ChessSymbol getSymbol() {
        return chessSymbol;
    }

    /**
     * Возвращает цвет шахматной фигуры
     *
     * @return цвет шахматной фигуры
     */
    public final Color getColor() {
        return color;
    }
}
