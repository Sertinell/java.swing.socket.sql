package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.utils.ClosedInterval;
import usantatecla.utils.ConcreteCoordinate;
import usantatecla.utils.Direction;

import java.util.Random;

public class Coordinate extends ConcreteCoordinate {

    public static final Coordinate NULL_COORDINATE = new Coordinate();
    public static final int DIMENSION = 3;
    static final ClosedInterval LIMITS =
            new ClosedInterval(0, Coordinate.DIMENSION - 1);

    public Coordinate() {
        super();
    }

    public Coordinate(int row, int column) {
        super(row, column);
    }

    @Override
    public boolean isNull() {
        return this == Coordinate.NULL_COORDINATE;
    }

    public Error isValid() {
        if (!LIMITS.isIncluded(this.row) || !LIMITS.isIncluded(this.column)) {
            return Error.NOT_VALID;
        }
        return Error.NULL;
    }

    @Override
    public Direction getDirection(usantatecla.utils.Coordinate coordinate) {
        assert coordinate != null;

        if (coordinate.isNull()) {
            return Direction.NULL;
        }
        if (this.inInverseDiagonal() && ((Coordinate) coordinate).inInverseDiagonal()) {
            return Direction.INVERSE_DIAGONAL;
        }
        return super.getDirection(coordinate);
    }

    boolean inInverseDiagonal() {
        if (this.isNull()) {
            return false;
        }
        return this.row + this.column == Coordinate.DIMENSION - 1;
    }

    public void random() {
        Random random = new Random(System.currentTimeMillis());
        this.row = random.nextInt(Coordinate.DIMENSION);
        this.column = random.nextInt(Coordinate.DIMENSION);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (this.isNull() || other.isNull()) {
            return false;
        }
        return super.equals(other);
    }

}
