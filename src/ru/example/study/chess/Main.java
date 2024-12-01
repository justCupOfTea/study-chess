package ru.example.study.chess;

import ru.example.study.chess.command.Command;
import ru.example.study.chess.command.CommandType;
import ru.example.study.chess.command.ParserCommand;

import java.util.Scanner;

/**
 * Игра шахматы
 */
public class Main {

    public static void main(String[] args) {
        ChessBoard board = ChessBoard.createBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Чтобы проверить игру надо вводить команды:
                'exit' - для выхода
                'replay' - для перезапуска игры
                'castling0' или 'castling7' - для рокировки по соответствующей линии
                'move 1 1 2 3' - для передвижения фигуры с позиции 1 1 на 2 3(поле это двумерный массив от 0 до 7)
                Проверьте могут ли фигуры ходить друг сквозь друга, корректно ли съедают друг друга, можно ли поставить шах и сделать рокировку?""");
        System.out.println();
        board.printBoard();
        while (true) {
            Command command = ParserCommand.parse(scanner.nextLine());
            if (command == null) {
                System.out.println("Вы что-то ввели не так, попробуйте ещё раз");
            } else if (command.getCommandType() == CommandType.EXIT) {
                break;
            } else if (command.getCommandType() == CommandType.REPLAY) {
                System.out.println("Заново");
                board = ChessBoard.createBoard();
                board.printBoard();
            } else {
                if (command.getCommandType() == CommandType.CASTLING_0) {
                    if (board.castling0()) {
                        System.out.println("Рокировка удалась");
                        board.printBoard();
                    } else {
                        System.out.println("Рокировка не удалась");
                    }
                } else if (command.getCommandType() == CommandType.CASTLING_7) {
                    if (board.castling7()) {
                        System.out.println("Рокировка удалась");
                        board.printBoard();
                    } else {
                        System.out.println("Рокировка не удалась");
                    }
                } else if (command.getCommandType() == CommandType.MOVE) {
                    if (board.moveToPosition(command.getLine(), command.getColumn(), command.getToLine(), command.getToColumn())) {
                        System.out.println("Успешно передвинулись");
                        board.prepareFirstMovePiece(command.getToLine(), command.getToColumn());
                        board.printBoard();
                    } else {
                        System.out.println("Передвижение не удалось");
                    }
                }
            }
        }
    }
}