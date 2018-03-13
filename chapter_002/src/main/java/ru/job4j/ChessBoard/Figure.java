package ru.job4j.ChessBoard;

public abstract class Figure {
    final Cell position;
    public Figure(Cell position) {
        this.position = position;
    }
    public abstract Cell[] way(Cell sourse, Cell dest) throws ImposibleMoveException;
}
