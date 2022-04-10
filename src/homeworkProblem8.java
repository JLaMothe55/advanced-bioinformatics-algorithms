import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class homeworkProblem8 {
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


    private static boolean patternFinder(List<String> dna, int numberOfMismatches, String arrayListKmer, int kmerSize){
        List <Boolean> booleans = new LinkedList<>();
        boolean containsKmer = false;

        for (int i = 0; i < dna.size(); i++){
            booleans.add(i, false);
        }

        for (int i = 0; i < dna.size(); i++){
            String currentDna = dna.get(i);
            for (int j = 0; j < currentDna.length() - kmerSize + 1; j++){
                String kmer = currentDna.substring(j, j + kmerSize);
                int mismatches = 0;
                for (int k = 0; k < kmerSize; k++){
                    if (kmer.charAt(k) != arrayListKmer.charAt(k)){
                        mismatches++;
                    }
                }
                if (mismatches <= numberOfMismatches){
                    booleans.set(i, true);
                }
            }
        }

        if (booleans.contains(false)){
            return false;
        }
        else {
            return true;
        }
    }

    private static List<String> findingFrequentPatterns(List<String> dna, int kmerSize, int numberOfMismatches){
        ArrayList<String> allPossibleKmers = new ArrayList<>();

        List<String> stringList = new LinkedList<>();

        String comparedPattern = getBoundaryPattern(kmerSize, dnaMolecules.charAt(0));
        String lastPattern = getBoundaryPattern(kmerSize, dnaMolecules.charAt(3));

        allPossibleKmers.add(comparedPattern);

        //helps make all possible kmers list list
        while (!comparedPattern.equals(lastPattern)) {
            comparedPattern = nextPattern(comparedPattern);
            allPossibleKmers.add(comparedPattern);
        }

        for (int i = 0; i < allPossibleKmers.size(); i++){
            String kmer = allPossibleKmers.get(i);

            boolean inAll = patternFinder(dna, numberOfMismatches, kmer, kmerSize);
            //System.out.println(count);

            if (inAll == true){
                stringList.add(kmer);
            }
        }
        return stringList;
    }

    public static void main(String[] args){
        List <String> dna = new LinkedList<>();
        dna.add("AGGGAATGCATACCTACGTGTATTT");
        dna.add("TATATGCGGTAATCTAACGTAGACG");
        dna.add("AGTTTGAAGAACAATTATTTAGGCA");
        dna.add("TCTACGGCCCTTCCGTATTTACCGT");
        dna.add("TAGTCAACTACGCTCTCCCTTATGT");
        dna.add("TATTTATTGCGAATGACCTATGAAA");
        dna.add("TATGTTACCCGCAGACGGGTAGATA");
        dna.add("GAAAACTCTGATTGAAAACCTATGT");
        dna.add("TGAAATTATCAGGCTTATATCTGAA");
        dna.add("TATATGTCAAATCCTCGGATGTGAA");


        int numberOfMismatches = 1;
        int kmerSize = 5;

        List<String>  frequentPatterns = findingFrequentPatterns(dna, kmerSize, numberOfMismatches);

        System.out.println(frequentPatterns);
    }
}
