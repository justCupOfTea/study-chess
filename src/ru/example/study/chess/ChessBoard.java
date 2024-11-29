package ru.example.study.chess;

import ru.example.study.chess.piece.Bishop;
import ru.example.study.chess.piece.ChessPiece;
import ru.example.study.chess.piece.FirstMovePiece;
import ru.example.study.chess.piece.Horse;
import ru.example.study.chess.piece.King;
import ru.example.study.chess.piece.Pawn;
import ru.example.study.chess.piece.Queen;
import ru.example.study.chess.piece.Rook;

/**
 * Шахматная доска
 */
public class ChessBoard {

    /**
     * Размер игрового поля
     */
    private static final int BOARD_SIZE = 8;

    /**
     * Игровое поле
     */
    private final ChessPiece[][] board = new ChessPiece[BOARD_SIZE][BOARD_SIZE]; // creating a field for game

    /**
     * Текущий игрок
     */
    private final NowPlayer nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = new NowPlayer(Color.of(nowPlayer));
    }

    /**
     * Передвинуть шахматную фигуру на доске
     *
     * @param startLine   начальная линия
     * @param startColumn начальная колонка
     * @param endLine     конечная линия
     * @param endColumn   конечная колонка
     * @return true, если можно передвинуть
     */
    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {
            if (!nowPlayer.getColor().equals(board[startLine][startColumn].getColor())) {
                return false;
            }
            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                nowPlayer.flip();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Вывести шахматную доску в консоль
     */
    public void printBoard() { //print board in console
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i == BOARD_SIZE - 1) {
                System.out.printf("\t%s\n", i);
            } else {
                System.out.printf("\t%s", i);
            }
        }

        for (int i = BOARD_SIZE - 1; i >= 0; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol().toString() + board[i][j].getColor() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println(nowPlayer);
    }

    /**
     * Проверить позицию
     *
     * @param pos номер колонки/линии
     * @return true, если существует колонка/линия на поле
     */
    public boolean checkPos(int pos) {
        return pos >= 0 && pos < BOARD_SIZE;
    }

    /**
     * Выполнить рокировку слона (колонки 0) и короля
     *
     * @return true, если возможно
     */
    public boolean castling0() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Выполнить рокировку слона (колонки 7) и короля
     *
     * @return true, если возможно
     */
    public boolean castling7() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Подготовить шахматные фигуры после первого хода
     *
     * @param line   позиция шахматной фигуры на линии
     * @param column позиция шахматной фигуры в колонке
     */
    public void prepareFirstMovePiece(int line, int column) {
        if (checkPos(line) && checkPos(column)) {
            ChessPiece chessPiece = board[line][column];
            if (chessPiece instanceof FirstMovePiece firstMovePiece) {
                if (firstMovePiece.isFirstMove()) {
                    firstMovePiece.negateFirstMove();
                }
            }
        }
    }

    /**
     * Установить шахматную фигуру на доску
     *
     * @param chessPiece шахматная фигура
     * @param line       позиция на линии шахматной фигуры
     * @param column     позиция в колонке шахматной фигуры
     */
    private void setPiece(ChessPiece chessPiece, int line, int column) {
        if (chessPiece != null && checkPos(line) && checkPos(column)) {
            board[line][column] = chessPiece;
        }
    }

    /**
     * Создать шахматную доску для игры
     *
     * @return шахматная доска
     */
    public static ChessBoard createBoard() {
        ChessBoard chessBoard = new ChessBoard("White");
        chessBoard.setPiece(new Rook("White"), 0, 0);
        chessBoard.setPiece(new Horse("White"), 0, 1);
        chessBoard.setPiece(new Bishop("White"), 0, 2);
        chessBoard.setPiece(new Queen("White"), 0, 3);
        chessBoard.setPiece(new King("White"), 0, 4);
        chessBoard.setPiece(new Bishop("White"), 0, 5);
        chessBoard.setPiece(new Horse("White"), 0, 6);
        chessBoard.setPiece(new Rook("White"), 0, 7);
        chessBoard.setPiece(new Pawn("White"), 1, 0);
        chessBoard.setPiece(new Pawn("White"), 1, 1);
        chessBoard.setPiece(new Pawn("White"), 1, 2);
        chessBoard.setPiece(new Pawn("White"), 1, 3);
        chessBoard.setPiece(new Pawn("White"), 1, 4);
        chessBoard.setPiece(new Pawn("White"), 1, 5);
        chessBoard.setPiece(new Pawn("White"), 1, 6);
        chessBoard.setPiece(new Pawn("White"), 1, 7);
        //black
        chessBoard.setPiece(new Rook("Black"), 7, 0);
        chessBoard.setPiece(new Horse("Black"), 7, 1);
        chessBoard.setPiece(new Bishop("Black"), 7, 2);
        chessBoard.setPiece(new Queen("Black"), 7, 3);
        chessBoard.setPiece(new King("Black"), 7, 4);
        chessBoard.setPiece(new Bishop("Black"), 7, 5);
        chessBoard.setPiece(new Horse("Black"), 7, 6);
        chessBoard.setPiece(new Rook("Black"), 7, 7);
        chessBoard.setPiece(new Pawn("Black"), 6, 0);
        chessBoard.setPiece(new Pawn("Black"), 6, 1);
        chessBoard.setPiece(new Pawn("Black"), 6, 2);
        chessBoard.setPiece(new Pawn("Black"), 6, 3);
        chessBoard.setPiece(new Pawn("Black"), 6, 4);
        chessBoard.setPiece(new Pawn("Black"), 6, 5);
        chessBoard.setPiece(new Pawn("Black"), 6, 6);
        chessBoard.setPiece(new Pawn("Black"), 6, 7);
        return chessBoard;
    }
}
