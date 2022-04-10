import java.io.FileNotFoundException;

public class rockGame {

    public static int currentMove (int player1Rocks, int player2Rocks, int [][] rockPiles){
        if (player1Rocks < 1 || player2Rocks < 1 || player1Rocks + player2Rocks < 3){
            return -99;
        }

        if (rockPiles[player1Rocks][player2Rocks] != -1){
            return rockPiles[player1Rocks][player2Rocks];
        }

        int moveOption1 = currentMove(player1Rocks - 2, player2Rocks - 1, rockPiles);
        int moveOption2 = currentMove(player1Rocks - 1, player2Rocks - 2, rockPiles);

        if (moveOption1 == -99 && moveOption2 == -99){
            rockPiles[player1Rocks][player2Rocks] = 1;
            rockPiles[player1Rocks][player1Rocks] = 1;
        }

        else{
            rockPiles[player1Rocks][player2Rocks] = 0;
            rockPiles[player1Rocks][player1Rocks] = 0;
        }

        return rockPiles[player1Rocks][player2Rocks];

    }




    public static void main(String[] args) throws FileNotFoundException{
        int [][] dp = new int [1000][1000];

        for(int i=0;i<1000;i++)
        {
            for(int j=0;j<1000;j++)
            {
                dp[i][j]=-1;
            }
        }

        int n = 6;
        int m = 6;

        if (currentMove(n, m, dp) == -99){
            System.out.println("P1 won");

        }

        else {
            System.out.println("P2 won");
            System.out.println(currentMove(n, m, dp));
        }

    }
}
