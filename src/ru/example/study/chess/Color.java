package ru.example.study.chess;

import java.util.Locale;

/**
 * Цвет шахматной фигуры
 */
public enum Color {
    /**
     * Белый
     */
    WHITE("White"),
    /**
     * Черный
     */
    BLACK("Black"),
    ;

    /**
     * Значение цвета
     */
    private final String colorValue;

    Color(String colorValue) {
        this.colorValue = colorValue;
    }

    @Override
    public String toString() {
        return this.getFirstSymbol();
    }

    /**
     * Получить первый символ цвета
     */
    private String getFirstSymbol() {
        return colorValue.substring(0, 1).toLowerCase(Locale.ROOT);
    }

    /**
     * Получить значение цвета
     */
    public String getColorValue() {
        return colorValue;
    }

    public static Color of(String color) {
        return Color.valueOf(color.toUpperCase(Locale.ROOT));
    }
}
