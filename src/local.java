import java.io.FileNotFoundException;

public class local {

    public static String[] gettingTheAlignment(String stringOne, String stringTwo){
        int m = stringOne.length();
        int n = stringTwo.length();

        double[][] matrix = new double[m + 1][n + 1];

        for (int i = 0; i <= m; i++){
            matrix[i][0] = i;
        }

        for (int i = 0; i <= n; i++){
            matrix[0][i] = i;
        }

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (stringOne.charAt(i - 1) == stringTwo.charAt(j - 1)){
                    matrix[i][j] = matrix[i - 1][j - 1];
                }

                else{
                    matrix[i][j] = Math.min(
                            matrix[i - 1][j] + 1,
                            matrix[i][j - 1] + 0.5);
                }
            }
        }

        String alignmentOne = "";
        String alignmentTwo = "";

        for (int i = m, j = n; i > 0 || j > 0;){
            if (i > 0 && matrix[i][j] == matrix[i - 1][j] + 1){
                alignmentOne += stringOne.charAt(--i);
                alignmentTwo += "-";
            }
            else if (j > 0 && matrix[i][j] == matrix[i][j - 1] + 1){
                alignmentTwo += stringTwo.charAt(--j);
                alignmentOne += "-";
            }
            else {
                alignmentOne += stringOne.charAt(--i);
                alignmentTwo += stringTwo.charAt(--j);
            }
        }

        String finalTouchOne = "";
        String finalTouchTwo = "";

        for (int i = alignmentOne.length() - 1; i >= 0; i--){
            finalTouchOne += alignmentOne.charAt(i);
        }

        for (int i = alignmentTwo.length() - 1; i >= 0; i--){
            finalTouchTwo += alignmentTwo.charAt(i);
        }


        return new String[]{finalTouchOne, finalTouchTwo};

    }



    public static void main(String[] args) throws FileNotFoundException{
        String[] alignmentList;
        String stringOne = "1343422421";
        String stringTwo = "1213434222";

        alignmentList = gettingTheAlignment(stringOne, stringTwo);

        for (int i = 0; i < alignmentList.length; i++){
            System.out.println(alignmentList[i]);
        }
    }
}
