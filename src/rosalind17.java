import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class rosalind17 {

    public static void manhattanTourist(int n, int m, int[][] down, int[][] right){
        int[][] s = new int[n+1][m+1];

        s[0][0] = 0;

        for (int i = 1; i <= n; i++){
            s[i][0] = s[i - 1][0] + down[i - 1][0];
        }

        for (int j = 1; j <= m; j++){
            s[0][j] = s[0][j - 1] + right[0][j - 1];
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){

                s[i][j] = Math.max(s[i-1][j] + down[i-1][j], s[i][j-1] + right[i][j-1]);

            }
        }

        System.out.println(s[n][m]);

    }

    public static void main(String[] args) throws FileNotFoundException{
        String routine = "C:/Users/Joesph/Desktop/";
        String doc_name = "rosalind17.txt";

        String file2 = "rosalindMatrix2.txt";

        Scanner readIn = new Scanner(new File(routine + doc_name));
        Scanner secondScan = new Scanner(new File (routine + file2));

        int n = 19;
        int m = 13;

        int [][] down = new int [n][m + 1];
        int [][] right = new int [n + 1][m];

        int i = 0;

        while(readIn.hasNextLine()){

            for (int j = 0; j <= m; j++){
                down[i][j] = readIn.nextInt();

            }
            i++;
        }

        i = 0;

        while(secondScan.hasNextLine()){

            for (int j = 0; j < m; j++){
                right[i][j] = secondScan.nextInt();

            }
            i++;
        }

        manhattanTourist(n, m, down, right);

    }

}

