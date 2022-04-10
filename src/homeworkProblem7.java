import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class homeworkProblem7 {
    public static final String dnaMolecules = "ATGC";

//Creates the first and last patterns for the all possible kmers list
    private static String getBoundaryPattern(int kmerSize, char dnaChar){
        StringBuilder stringBuilder = new StringBuilder(kmerSize);
        for (int i = 0; i < kmerSize; i++) {
            stringBuilder.append(dnaChar);
        }
        return stringBuilder.toString();
    }

//Creates the all possible kmers List
    private static String nextPattern(String pattern){
        StringBuilder stringBuilder = new StringBuilder(pattern.length());
        for (int i = pattern.length() - 1; i >= 0; i--){
            if (pattern.charAt(i) == dnaMolecules.charAt(dnaMolecules.length() - 1))
                continue;

            int index = dnaMolecules.indexOf(pattern.charAt(i)) + 1;
            stringBuilder.append(pattern.substring(0, i));
            stringBuilder.append(dnaMolecules.charAt(index));

            for (int j = i + 1; j < pattern.length(); j++){
                stringBuilder.append(dnaMolecules.charAt(0));
            }
            break;
        }
        return stringBuilder.toString();
    }


    private static int patternFinder(String dna, int numberOfMismatches, String arrayListKmer, int kmerSize){
        int counter = 0;

        for(int i = 0; i < dna.length() - kmerSize + 1; i++){
            String kmer = dna.substring(i, i + kmerSize);

            int mismatchesSoFar = 0;

                for (int j = 0; j < kmer.length(); j++){
                    if (kmer.charAt(j) != arrayListKmer.charAt(j)){
                        mismatchesSoFar++;
                    }

                }

            if (mismatchesSoFar <= numberOfMismatches){
                counter++;
            }
        }
        return counter;
    }

    private static List<String> findingFrequentPatterns(String dna, int kmerSize, int numberOfMismatches){
        ArrayList<String> allPossibleKmers = new ArrayList<>();

        List<String> stringList = new LinkedList<>();

        String comparedPattern = getBoundaryPattern(kmerSize, dnaMolecules.charAt(0));
        String lastPattern = getBoundaryPattern(kmerSize, dnaMolecules.charAt(3));

        allPossibleKmers.add(comparedPattern);

        int max = 0;

 //helps make all possible kmers list list
        while (!comparedPattern.equals(lastPattern)) {
            comparedPattern = nextPattern(comparedPattern);
            allPossibleKmers.add(comparedPattern);
        }

        for (int i = 0; i < allPossibleKmers.size(); i++){
            String kmer = allPossibleKmers.get(i);

            int count = patternFinder(dna, numberOfMismatches, kmer, kmerSize);
            //System.out.println(count);

            if (count > max){
                stringList.clear();
                stringList.add(kmer);
                max = count;
                System.out.println(max);
            }

            if (max == count && !stringList.contains(kmer)){
                stringList.add(kmer);
            }
        }
        return stringList;
    }

    public static void main(String[] args){
        String dna = "AGTCAGTC";
        int numberOfMismatches = 2;
        int kmerSize = 4;

        List<String>  frequentPatterns = findingFrequentPatterns(dna, kmerSize, numberOfMismatches);

        System.out.println(frequentPatterns);
    }
}
