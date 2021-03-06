package usantatecla.tictactoe;

class Player {

	protected Color color;
	protected Board board;
	private int putTokens;

	Player(Color color, Board board) {
		assert !color.isNull();
		assert board != null;

		this.color = color;
		this.board = board;
		this.putTokens = 0;
	}

	void play() {
		if (this.putTokens < Coordinate.DIMENSION) {
			this.putToken();
		} else {
			this.moveToken();
		}
	}

	private void putToken() {
		Coordinate coordinate;
		Error error;
		do {
			coordinate = this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
			error = this.getPutTokenError(coordinate);
		} while (!error.isNull());
		this.board.putToken(coordinate, this.color);
		this.putTokens++;
	}

	protected Coordinate getCoordinate(Message message){
		assert message != null;

		Coordinate coordinate = new Coordinate();
		coordinate.read(message.toString());
		return coordinate;
	}

	protected Error getPutTokenError(Coordinate coordinate) {
		assert coordinate != null;
		Error error = Error.NULL;
		if (!this.board.isEmpty(coordinate)) {
			error = Error.NOT_EMPTY;
		}
		error.writeln();
		return error;
	}

	private void moveToken() {
		Coordinate origin;
		Error error;
		do {
			origin = this.getCoordinate(Message.COORDINATE_TO_REMOVE);
			error = this.getOriginMoveTokenError(origin);
		} while (error != Error.NULL);
		Coordinate target;
		do {
			target = this.getCoordinate(Message.COORDINATE_TO_MOVE);
			error = this.getTargetMoveTokenError(origin, target);
		} while (error != Error.NULL);
		this.board.moveToken(origin, target);
	}

	protected Error getOriginMoveTokenError(Coordinate origin) {
		assert !origin.isNull();
		Error error = Error.NULL;
		if (!this.board.isOccupied(origin, this.color)) {
			error = Error.NOT_OWNER;
		}
		error.writeln();
		return error;
	}

	protected Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
		assert !origin.isNull() && !target.isNull();
		Error error = Error.NULL;
		if (origin.equals(target)) {
			error = Error.SAME_COORDINATES;
		}
		else if (!this.board.isEmpty(target)) {
			error = Error.NOT_EMPTY;
		}
		error.writeln();
		return error;
	}

	void writeWinner() {
		Message.PLAYER_WIN.writeln(this.color.name());
	}

	Color getColor() {
		return this.color;
	}

}
