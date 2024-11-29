package ru.example.study.chess.piece;

/**
 * Шахматные фигуры с первым ходом
 */
public interface FirstMovePiece {

    /**
     * Отрицать первое движение
     */
    void negateFirstMove();

    /**
     * Проверять первое это движение у шахматной фигуры
     */
    boolean isFirstMove();
}
