package com.example;

/**
 * Hello world!
 *
 */
public class Tennis {
	private int p1_point = 0;
	private int p2_point = 0;
	private String player1;
	private String player2;

	public Tennis(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getScore() {
		if (this.p1_point == p2_point) {
			switch (p1_point) {
			case 0:
				return "Love-All";
			case 1:
				return "Fifteen-All";
			case 2:
				return "Thirty-All";
			case 3:
			case 4:
				return "Deuce";
			}
		}

		if (this.p1_point >= 4 || this.p2_point >= 4) {
			int minusResult = this.p1_point - this.p2_point;
			if (minusResult == 1)
				return "Advantage player1";
			else if (minusResult == -1)
				return "Advantage player2";
			else if (minusResult >= 2)
				return "Win for player1";
			else
				return "Win for player2";
		}

		String score1 = switch (this.p1_point) {
		case 0 -> "Love";
		case 1 -> "Fifteen";
		case 2 -> "Thirty";
		default -> "Forty";
		};

		var score2 = switch (this.p2_point) {
		case 0 -> "Love";
		case 1 -> "Fifteen";
		case 2 -> "Thirty";
		default -> "Forty";
		};

		return score1 + "-" + score2;
	}

	public void wonPoint(String player) {
		if (player == this.player1) {
			this.p1_point += 1;
			return;
		}

		if (player == this.player2) {
			this.p2_point += 1;
			return;
		}
		return;
	}
}
