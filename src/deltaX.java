import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class deltaX {

    public static void findingDeltaX(ArrayList<Integer> x){
        ArrayList<Integer> deltaX = new ArrayList<>();

        for(int i = 0; i < x.size(); i++){
            for(int l = i + 1; l < x.size(); l++){
                int distance = x.get(l) - x.get(i);
                deltaX.add(distance);
            }
        }

        Collections.sort(deltaX);
        System.out.println(deltaX);
    }

    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> xAgain = new ArrayList<>();

        x.add(0);
        x.add(6);
        x.add(9);
        x.add(10);
        x.add(11);
        x.add(12);
        x.add(15);

        xAgain.add(0);
        xAgain.add(3);
        xAgain.add(4);
        xAgain.add(5);
        xAgain.add(6);
        xAgain.add(9);
        xAgain.add(15);

        findingDeltaX(x);
        findingDeltaX(xAgain);

        System.out.println("Time in milliseconds: " + System.currentTimeMillis());
    }
}
