package ru.example.study.chess.piece;

/**
 * Символ шахматной фигуры на доске
 */
public enum ChessSymbol {
    /**
     * Слон
     */
    BISHOP("B"),
    /**
     * Конь
     */
    HORSE("H"),
    /**
     * Король
     */
    KING("K"),
    /**
     * Пешка
     */
    PAWN("P"),
    /**
     * Ферзь
     */
    QUEEN("Q"),
    /**
     * Ладья
     */
    ROOK("R"),
    ;

    /**
     * Символ фигуры
     */
    private final String symbol;

    ChessSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Получить символ фигуры
     */
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
