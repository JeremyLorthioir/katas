package com.example;

/**
 * Hello world!
 *
 */
public class Tennis 
{
    private int p1_point = 0;
    private int p2_point = 0;
    private String player1;
    private String player2;

    public Tennis(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public String getScore(){
        return "Love-All";
    }

    public void wonPoint(String player){
        if(player == this.player1){
            this.p1_point += 1;
            return;
        }

        if(player == this.player2){
            this.p2_point += 1;
            return;
        }
        return;
    }
}
