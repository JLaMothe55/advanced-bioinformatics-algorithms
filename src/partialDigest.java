import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class partialDigest {

    public static ArrayList<Integer> delta(int y, ArrayList<Integer> X){
        ArrayList<Integer> markedLocations = new ArrayList<>();


        for (int i = 0; i < X.size(); i++){
            markedLocations.add(Math.abs(y - X.get(i)));
        }

        return markedLocations;
    }

    public static void partialDigest(ArrayList<Integer> L){
        int width = L.get(L.size() - 1);
        L.remove(L.get(L.size() - 1));
        ArrayList<Integer> X = new ArrayList<>();

        X.add(0);
        X.add(width);

        place(L, X, width);
    }


    public static void place (ArrayList<Integer> L, ArrayList<Integer> X, int width){
        Collections.sort(X);
        Collections.sort(L);

        if (L.isEmpty()){
            System.out.println(X);
            return;
        }

        int y = L.get(L.size() - 1);

        ArrayList <Integer> deltayx = new ArrayList<>();

        deltayx = delta(y, X);


        ArrayList <Boolean> contains = new ArrayList<Boolean>();

        for (int i = 0; i < deltayx.size(); i++){
            if (L.contains(deltayx.get(i))){
                contains.add(true);
            }
        }

        if (contains.size() == deltayx.size()){
            X.add(y);

            for (int i = 0; i < deltayx.size(); i++){
                L.remove(deltayx.get(i));
            }

            place(L, X, width);

            boolean beenRemoved = false;

            for (int i = 0; i < X.size(); i++){
                if(X.get(i) == y && beenRemoved == false){
                    X.remove(X.get(i));
                    beenRemoved = true;
                }
            }

            for (int i = 0; i < deltayx.size(); i++){
                L.add(deltayx.get(i));
            }
        }

        deltayx = (delta(width - y, X));


        ArrayList <Boolean> containsAgain = new ArrayList<Boolean>();

        for (int i = 0; i < deltayx.size(); i++){
            if (L.contains(deltayx.get(i))){
                containsAgain.add(true);
            }
        }

        if (containsAgain.size() == deltayx.size()){
            X.add(width - y);

            for (int i = 0; i < deltayx.size(); i++){
                L.remove(deltayx.get(i));
            }

            place(L, X, width);

            boolean beenRemoved = false;

            for (int i = 0; i < X.size(); i++){
                if(X.get(i) == width - y && beenRemoved == false){
                    X.remove(X.get(i));
                    beenRemoved = true;
                }
            }

            for (int i = 0; i < deltayx.size(); i++){
                L.add(deltayx.get(i));
            }

        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> L = new ArrayList<>();

        L.add(1);
        L.add(1);
        L.add(1);
        L.add(2);
        L.add(2);
        L.add(3);
        L.add(3);
        L.add(3);
        L.add(4);
        L.add(4);
        L.add(5);
        L.add(5);
        L.add(6);
        L.add(6);
        L.add(6);
        L.add(9);
        L.add(9);
        L.add(10);
        L.add(11);
        L.add(12);
        L.add(15);

        partialDigest(L);

        System.out.println("Time in milliseconds: " + System.currentTimeMillis());

    }
}
