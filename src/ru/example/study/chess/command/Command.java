package ru.example.study.chess.command;

/**
 * Команда
 */
public class Command {

    /**
     * Тип команды
     */
    private final CommandType commandType;
    /**
     * Начальная линия
     */
    private final Integer line;
    /**
     * Начальная колонка
     */
    private final Integer column;
    /**
     * Конечная линия
     */
    private final Integer toLine;
    /**
     * Конечная линия
     */
    private final Integer toColumn;

    public Command(CommandType commandType) {
        this(commandType, null, null, null, null);
    }

    public Command(CommandType commandType,
                   Integer line,
                   Integer column,
                   Integer toLine,
                   Integer toColumn) {
        this.commandType = commandType;
        this.line = line;
        this.column = column;
        this.toLine = toLine;
        this.toColumn = toColumn;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public Integer getLine() {
        return line;
    }

    public Integer getColumn() {
        return column;
    }

    public Integer getToLine() {
        return toLine;
    }

    public Integer getToColumn() {
        return toColumn;
    }
}
