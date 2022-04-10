import java.io.FileNotFoundException;
import java.util.ArrayList;

public class rosalind16 {

    public static void minimumNumberNeeded(int money, ArrayList<Integer> coins){
        ArrayList<Integer>minNumCoins = new ArrayList<>();

        for (int i = 0; i < money + 1; i++){
            minNumCoins.add(0);
        }

        for (int m = 1; m <= money; m++){
            minNumCoins.add(m, 999999999);

            for (int i = 0; i < coins.size(); i++){
                if (m >= coins.get(i)){
                    if (minNumCoins.get(m - coins.get(i)) + 1 < minNumCoins.get(m)){
                        minNumCoins.add(m, minNumCoins.get(m - coins.get(i)) + 1);
                    }
                }
            }
        }

        System.out.println(minNumCoins.get(money));
    }

    public static void main(String[] args) throws FileNotFoundException{
        int money = 18785;
        ArrayList<Integer>coins = new ArrayList<>();

        coins.add(1);
        coins.add(3);
        coins.add(5);
        coins.add(6);
        coins.add(11);
        coins.add(19);
        coins.add(20);
        coins.add(22);

        minimumNumberNeeded(money, coins);
    }
}
