import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class homeworkProblem13 {

    public static String replicatingDna(List<String> kmerList){
        String dna = kmerList.get(0);

        for (int i = 1; i < kmerList.size(); i++){
            String kmer = kmerList.get(i);
            dna += kmer.charAt(kmer.length()-1);
        }

        return dna;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String routine = "C:/Users/Joesph/Downloads/";
        String doc_name = "rosalind_ba3b.txt";

        Scanner readIn = new Scanner(new File(routine + doc_name));

        ArrayList<String> kmerList = new ArrayList<String>();

        while(readIn.hasNextLine()){

            String currSeq = readIn.nextLine();
            if(currSeq.length() > 1)
                kmerList.add(currSeq);

        }

        System.out.println(replicatingDna(kmerList));

    }
}
