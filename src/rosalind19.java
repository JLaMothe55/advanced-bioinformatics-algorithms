import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class rosalind19 {

    public static int findTheBreakpoints(ArrayList<Integer> listOfNums){
        int count = 0;

        for (int i = 0; i < listOfNums.size() - 1; i++){
            if (listOfNums.get(i + 1) == listOfNums.get(i) + 1){
                count += 1;
            }
        }

        return listOfNums.size() - 1 - count;
    }

    public static void main(String[] args) throws FileNotFoundException{
        String routine = "C:/Users/Joesph/Desktop/";
        String doc_name = "rosalind19list.txt";

        Scanner readIn = new Scanner(new File(routine + doc_name));

        ArrayList<Integer> listOfNums = new ArrayList<>();

        listOfNums.add(0);

        while(readIn.hasNextLine()){

            listOfNums.add(readIn.nextInt());
        }

        listOfNums.add(listOfNums.size());

        System.out.println(findTheBreakpoints(listOfNums));
    }
}
