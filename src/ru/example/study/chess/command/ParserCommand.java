package ru.example.study.chess.command;

/**
 * Парсер команд
 */
public class ParserCommand {

    /**
     * Разбирает строковое представление команды и возвращает команду
     *
     * @param input строка с командой
     * @return команда, если удалось разобрать иначе null
     */
    public static Command parse(String input) {
        if (input.equals(CommandType.EXIT.getCommandValue())) {
            return new Command(CommandType.EXIT);
        } else if (input.equals(CommandType.REPLAY.getCommandValue())) {
            return new Command(CommandType.REPLAY);
        } else if (input.equals(CommandType.CASTLING_0.getCommandValue())) {
            return new Command(CommandType.CASTLING_0);
        } else if (input.equals(CommandType.CASTLING_7.getCommandValue())) {
            return new Command(CommandType.CASTLING_7);
        } else if (input.startsWith(CommandType.MOVE.getCommandValue() + " ")) {
            String[] partsCommand = input.split(" ");
            try {
                if (partsCommand.length == 5) {
                    int line = Integer.parseInt(partsCommand[1]);
                    int column = Integer.parseInt(partsCommand[2]);
                    int toLine = Integer.parseInt(partsCommand[3]);
                    int toColumn = Integer.parseInt(partsCommand[4]);
                    return new Command(CommandType.MOVE, line, column, toLine, toColumn);
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
