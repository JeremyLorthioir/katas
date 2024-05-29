package com.example;

/**
 * Hello world!
 *
 */
public class Tennis {
	private int p1Point = 0;
	private int p2Point = 0;
	private String player1;
	private String player2;

	public Tennis(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getScore() {
		if (this.p1Point == p2Point) {
			return handleDraw();
		}

		if (this.p1Point >= 4 || this.p2Point >= 4) {
			return handleAdvantage();
		}

		return handleNormalScore();
	}

	private String handleDraw() {
		switch (p1Point) {
		case 0:
			return "Love-All";
		case 1:
			return "Fifteen-All";
		case 2:
			return "Thirty-All";
		case 3, 4:
			return "Deuce";
		default:
			return "";
		}
	}

	private String handleNormalScore() {
		String score1 = switch (this.p1Point) {
		case 0 -> "Love";
		case 1 -> "Fifteen";
		case 2 -> "Thirty";
		default -> "Forty";
		};

		var score2 = switch (this.p2Point) {
		case 0 -> "Love";
		case 1 -> "Fifteen";
		case 2 -> "Thirty";
		default -> "Forty";
		};

		return score1 + "-" + score2;
	}

	private String handleAdvantage() {
		int minusResult = this.p1Point - this.p2Point;
		if (minusResult == 1)
			return "Advantage player1";
		else if (minusResult == -1)
			return "Advantage player2";
		else if (minusResult >= 2)
			return "Win for player1";
		else
			return "Win for player2";
	}

	public void wonPoint(String player) {
		if (this.player1.equals(player)) {
			this.p1Point++;
		}
		
		if (this.player2.equals(player)) {
			this.p2Point++;
		}
	}
}
