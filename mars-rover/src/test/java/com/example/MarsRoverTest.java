package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.MarsRover.Direction;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

class MarsRoverTest {
	
	 public static Stream<Object[]> getAllTurns() {
		 return Stream.of(new Object[][]{
			 {Direction.N, "l", Direction.W},
			 {Direction.W, "l", Direction.S},
			 {Direction.S, "l",Direction.E },
			 {Direction.E, "l", Direction.N},
             
			 {Direction.N, "r", Direction.E },
			 {Direction.E, "r", Direction.S},
			 {Direction.S, "r", Direction.W},
			 {Direction.W, "r", Direction.N},
		 });
	 }
	 
	 public static Stream<Object[]> getAllMoves() {
		 return Stream.of(new Object[][]{
			 {Direction.N, "f", 0, 1},
			 {Direction.W, "f", -1, 0},
			 {Direction.S, "f", 0, -1},
			 {Direction.E, "f", 1, 0},
             
			 {Direction.N, "b", 0, -1},
			 {Direction.E, "b", -1, 0},
			 {Direction.S, "b", 0, 1},
			 {Direction.W, "b", 1, 0},
		 });
	 }
	 
	
	@ParameterizedTest(name = "{index} ==> Rover facing {0} and turning {1} should face {2}")
	@MethodSource("getAllTurns")
	public void checkRoverTurns(Direction facingDirection, String direction, Direction expectedfacingDirection) {
		MarsRover rover = new MarsRover(new Position(0, 0), facingDirection);
		rover.turn(direction);
		assertEquals(expectedfacingDirection, rover.getFacingDirection());
	}

	@ParameterizedTest(name = "{index} ==> Rover facing {0} and moving {1} should be on coordinate {2}:{3}")
	@MethodSource("getAllMoves")
	public void checkRoverMoves(Direction facingDirection, String direction, int expectedX, int expectedY) {
		MarsRover rover = new MarsRover(new Position(0, 0), facingDirection);
		rover.move(direction);
		assertEquals(expectedX, rover.getPosition().getX());
		assertEquals(expectedY, rover.getPosition().getY());
	}
}
