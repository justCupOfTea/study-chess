package ru.example.study.chess.command;

import java.util.Locale;

/**
 * Тип команды
 */
public enum CommandType {
    /**
     * Двигать
     */
    MOVE("move"),
    /**
     * Рокировка слона (колонки 0) и короля
     */
    CASTLING_0("castling0"),
    /**
     * Рокировка слона (колонки 7) и короля
     */
    CASTLING_7("castling7"),
    /**
     * Выход
     */
    EXIT("exit"),
    /**
     * Начать заново
     */
    REPLAY("replay"),
    ;

    /**
     * Значение команды
     */
    private final String commandValue;

    CommandType(String commandValue) {
        this.commandValue = commandValue;
    }

    /**
     * Значение команды
     */
    public String getCommandValue() {
        return commandValue;
    }

    /**
     * Создать тип команды
     *
     * @param command команда
     * @return тип команды
     */
    public static CommandType of(String command) {
        return CommandType.valueOf(command.toLowerCase(Locale.ROOT));
    }
}
