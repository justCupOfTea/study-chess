package ru.example.study.chess;

/**
 * Текущий игрок
 */
public class NowPlayer {

    /**
     * Текущий цвет игрока
     */
    private Color color;

    public NowPlayer(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    /**
     * Передать ход другому игроку
     */
    public void flip() {
        color = color.equals(Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    @Override
    public String toString() {
        return "NowPlayer %s(%s)".formatted(
                color.equals(Color.WHITE) ? 1 : 2
                , color.getColorValue()
        );
    }
}
