package com.example;

class MarsRover {
	private Position position;
	private Direction facingDirection;

	public MarsRover(Position position, Direction facingDirection) {
		super();
		this.position = position;
		this.facingDirection = facingDirection;
	}

	public void move(String direction) {
		if (!direction.equals("f") && !direction.equals("b")) {
			throw new IllegalArgumentException("Invalid move: " + direction);
		}

		int step = direction.equals("f") ? 1 : -1;

		switch (this.facingDirection) {
		case N:
			this.position.setY(this.position.getY() + step);
			break;
		case S:
			this.position.setY(this.position.getY() - step);
			break;
		case E:
			this.position.setX(this.position.getX() + step);
			break;
		case W:
			this.position.setX(this.position.getX() - step);
			break;			
		}
	}

	public void turn(String direction) {
        switch (direction) {
            case "l":
                this.facingDirection = this.facingDirection.turnLeft();
                break;
            case "r":
                this.facingDirection = this.facingDirection.turnRight();
                break;
            default: 
            	throw new IllegalArgumentException("Invalid turn direction: " + direction);
        }
    }

	public Direction getFacingDirection() {
		return facingDirection;
	}

	public Position getPosition() {
		return this.position;
	}

	public enum Direction {
        N, S, E, W;

        public Direction turnLeft() {
            switch (this) {
                case N: return W;
                case S: return E;
                case E: return N;
                case W: return S;
                default: throw new IllegalArgumentException("Invalid direction: " + this);
            }
        }

        public Direction turnRight() {
            switch (this) {
                case N: return E;
                case S: return W;
                case E: return S;
                case W: return N;
                default: throw new IllegalArgumentException("Invalid direction: " + this);
            }
        }
    }
}
