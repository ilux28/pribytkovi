package ru.job4j.ChessBoard;

public class ImposibleMoveException extends Exception {
    public ImposibleMoveException(String msg) {
        super(msg);
    }
}
