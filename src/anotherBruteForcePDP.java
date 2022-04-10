import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class anotherBruteForcePDP {

    public static ArrayList<Integer> findingDeltaX(ArrayList<Integer> x){
        ArrayList<Integer> deltaX = new ArrayList<>();

        for(int i = 0; i < x.size(); i++){
            for(int l = i + 1; l < x.size(); l++){
                int distance = x.get(l) - x.get(i);
                deltaX.add(distance);
            }
        }

        Collections.sort(deltaX);

        return deltaX;
    }

    public static void anotherBFPDP(ArrayList<Integer> L, int n){
        ArrayList<ArrayList<Integer>> brutedForce = new ArrayList<>();

        int M = L.get(L.size() - 1);

        //creates all possible combos between zero and the max int
        List<Integer> list = L.subList(0, L.size()-1);

        Iterable<List<Integer>> combos_all = Itertools.combinations(list, n-2);

        int i=0;

        for (List<Integer> combos: combos_all) {

            System.out.println(++i);

            combos.add(0, 0);
            combos.add(M);

//            ArrayList<Integer> X = new ArrayList<>();
//
//
//            X.add(0);
//            //loops through combos and adds them to X so theyre preceded by zero and end with the max int
//            for (int i = 0; i < combos.size(); i++){
//
//                X.add(combos.get(i));
//
//
//            }
//
//            X.add(M);

//            System.out.println(combos);

            //System.out.println(findingDeltaX(X));
//            System.out.println(combos);


//            ArrayList<Integer>answer = new ArrayList<>();
//
//            for (int i = 0; i < L.size(); i++){
//                if (findingDeltaX(X).get(i) == L.get(i)){
//                    answer.add(L.get(i));
//                }
//            }
//
//            if (answer.size() == L.size()){
//                System.out.println(X);
//            }

        }

    }

    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<Integer> L = new ArrayList<>();


//        L.add(1);
//        L.add(2);
//        L.add(3);
//        L.add(5);
//        L.add(7);
//        L.add(8);



//        L.add(1);
//        L.add(2);
//        L.add(3);
//        L.add(3);
//        L.add(4);
//        L.add(5);
//        L.add(6);
//        L.add(7);
//        L.add(9);
//        L.add(10);

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



        System.out.println("This is L");
        System.out.println(L);
        System.out.println("--------------------------");

        //int n = L.size() / 2;

        int n = 7;

        anotherBFPDP(L, n);


    }
}
