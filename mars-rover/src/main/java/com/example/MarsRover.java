package com.example;

class MarsRover {
	private int[] position;
	private Direction facingDirection;

	public MarsRover(int[] startingPosition, Direction facingDirection) {
		super();
		this.position = startingPosition;
		this.facingDirection = facingDirection;
	}

	public void move(String direction) {
		if (!direction.equals("f") && !direction.equals("b")) {
			throw new IllegalArgumentException("Invalid move: " + direction);
		}

		int step = direction.equals("f") ? 1 : -1;

		switch (this.facingDirection) {
		case N:
			this.setPositionY(this.getPositionY() + step);
			break;
		case S:
			this.setPositionY(this.getPositionY() - step);
			break;
		case E:
			this.setPositionX(this.getPositionX() + step);
			break;
		case W:
			this.setPositionX(this.getPositionX() - step);
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

	public int getPositionX() {
		return this.position[0];
	}

	public int getPositionY() {
		return this.position[1];
	}

	public void setPositionX(int x) {
		this.position[0] = x;
	}

	public void setPositionY(int y) {
		this.position[1] = y;
	}

	public Direction getFacingDirection() {
		return facingDirection;
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
