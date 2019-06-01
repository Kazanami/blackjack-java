import java.io.*;
import java.util.Random;

public class BlackJack {

    public static void main(String[] args) {
	// write your code here

        //各種宣言
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int player_point = 0, enemy_point = 0;
        Random rm = new Random();

        int num = rm.nextInt(52);

        int[] player_card = new int[30];
        int[] enemy_card = new int[30];

        for ( int i = 0; i < 2; i++){
            player_card[i] = rm.nextInt(13)+1;
            if (player_card[i] >= 10 ){
                player_card[i] = 10;
            }

            if (player_card[i] == 1){
                player_card[i] = 11;
            }

            player_point += player_card[i];

            if(player_point >= 22){
                for(int i = 0; i <= player_card.length; i++){
                    if(player_card[i] == 11){
                        player_card[i] = 1;
                        player_point -= 10;
                    }
                }
            }
        }

    }
}
