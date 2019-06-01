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


        // Player's Card draw
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
                for(int j = 0; j <= player_card.length; j++){
                    if(player_card[j] == 11){
                        player_card[j] = 1;
                        player_point -= 10;
                    }
                }
            }

        }

        // Player's Checker
        for( int i = 2; player_point < 22; i++) {
            System.out.println("現在、あなたの点数は、" + player_point + "です、");
            System.out.println("もう一度引くなら[hit]、引かないなら、[stand]と入力してください");
            System.out.print("[hit] or [stand] ?>");
            String str = br.readLine();

            switch (str) {
                case "hit":
                    player_card[i] = rm.nextInt(13) + 1;
                    if (player_card[i] >= 10) {
                        player_card[i] = 10;
                    }
                    if (player_card[i] == 1) {
                        player_card[i] = 11;
                    }

                    player_point += player_card[i];

                    if (player_point >= 22) {
                        System.out.println("プレイヤーはバストしました");
                        break;
                    }
                case "stand":
                    break;

            }

            for(int j = 0; enemy_point < 17; j++){
                enemy_card[j] = rm.nextInt(13) +1;
                if(enemy_card[j] >= 10){
                   enemy_card[j] = 10;
                }

                if(enemy_card[j] == 1){
                    enemy_card[j] = 10;
                }

                enemy_point += enemy_card[j];

                if ( enemy_point >= 22 ){
                    System.out.println("ディーラーはバーストしました");
                    break;
                }
            }
        }

        if(enemy_point > 21 && player_point < 22){
            System.out.println("プレイヤーの勝ち");
        }else if (enemy_point < 22 && player_point > 21) {
            System.out.println("ディーラーの勝ち");
        }else if (enemy_point > player_point){
            System.out.println("ディーラーの勝ち");
        }else if (enemy_point < player_point){
            System.out.println("プレイヤーの勝ち");
        }else if (enemy_point == player_point){
            System.out.println("引き分け");
        }else  if (enemy_point > 21 && player_point >21){
            System.out.println("ディーラーの勝ち");
        }
    }

}

