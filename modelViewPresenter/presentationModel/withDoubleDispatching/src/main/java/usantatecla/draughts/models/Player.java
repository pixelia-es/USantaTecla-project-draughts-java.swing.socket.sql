package usantatecla.draughts.models;

import usantatecla.draughts.types.Color;
import usantatecla.draughts.types.Coordinate;
import usantatecla.draughts.types.Error;
import usantatecla.utils.models.Direction;

public class Player {

    private Color color;
    private Board board;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    //TODO Hacer control de errores
    void movePiece(Coordinate origin, Coordinate target) {
        this.board.movePiece(origin, target);
    }

    Error getOriginError(Coordinate coordinate) {
        if (this.board.getColor(coordinate) != this.color) {
            return Error.NOT_OWNER;
        }
        return Error.NULL;
    }

    Error getTargetError(Coordinate origin, Coordinate target) {
        if (origin.equals(target)) {
            return Error.SAME_COORDINATES;
        }
        if (!this.board.isEmpty(target)) {
            return Error.NOT_EMPTY;
        }
        Direction direction = origin.getDirection(target);
        if (direction != Direction.MAIN_DIAGONAL &&
                direction != Direction.INVERSE_DIAGONAL) {
            return Error.NOT_DIAGONAL;
        }
        return this.board.getTargetError(origin, target);
    }
}
