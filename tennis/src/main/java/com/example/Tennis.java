package com.example;

/**
 * Hello Tennis!
 *
 */
public class Tennis {
	private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};
    
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
			return handleAdvantageOrWin();
		}

		return handleNormalScore();
	}

	private String handleDraw() {
        if (p1Point < 3) {
            return SCORE_NAMES[p1Point] + "-All";
        } else {
            return "Deuce";
        }
    }

	private String handleNormalScore() {
        return SCORE_NAMES[p1Point] + "-" + SCORE_NAMES[p2Point];
    }

	private String handleAdvantageOrWin() {
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
