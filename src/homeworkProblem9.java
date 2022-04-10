import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class homeworkProblem9 {

    private static void findingProfile(String dna, int k, Map<Character, double[]> map){
        List<String> listOfKmersInDna = new LinkedList<>();
        List<String> mostProbable = new LinkedList<>();

        for(int i = 0; i < dna.length() - k + 1; i++) {
            String pattern = dna.substring(i, i + k);
            listOfKmersInDna.add(pattern);
        }

        double max = 0;

        for (int i = 0; i < listOfKmersInDna.size(); i++){
            double currentProbability = 1;
            for (int j = 0; j < k; j++){
                char currentCharacter = listOfKmersInDna.get(i).charAt(j);

                if (currentCharacter == 'A'){
                    double aProb = currentProbability * map.get('A')[j];
                    currentProbability = aProb;

                }

                if (currentCharacter == 'C'){
                    double aProb = currentProbability * map.get('C')[j];
                    currentProbability = aProb;
                }

                if (currentCharacter == 'G'){
                    double aProb = currentProbability * map.get('G')[j];
                    currentProbability = aProb;
                }

                if (currentCharacter == 'T'){
                    double aProb = currentProbability * map.get('T')[j];
                    currentProbability = aProb;
                }
            }
            System.out.println(listOfKmersInDna.get(i) + " " + currentProbability);

            if (currentProbability > max){
                max = currentProbability;
                mostProbable.clear();
                mostProbable.add(listOfKmersInDna.get(i));
            }
            if (currentProbability == max){
                mostProbable.add(listOfKmersInDna.get(i));
            }
        }
        System.out.println(mostProbable);
    }


    public static void main(String[] args) {
        Map<Character, double[]> map = new LinkedHashMap<>();
        String dna = "CACGTCAATCAC";
        int k = 3;

        map.put('A', new double[]{.2, .8, .4});
        map.put('C', new double[]{.6, 0, .4});
        map.put('G', new double[]{.2, .2, .2});
        map.put('T', new double[]{0, 0, 0});

//        map.put('A', new double[]{0.25, 0.625, 0.125, 0.0, 0.0, 0.125, 0.375, 0.5, 0.25, 0.25, 0.25, 0.125, 0.5, 0.375, 0.25, 0.375, 0.25, 0.125, 0.375, 0.375, 0.0, 0.375, 0.375, 0.375, 0.0, 0.125, 0.125, 0.25, 0.125, 0.25, 0.25, 0.25, 0.25, 0.375, 0.5, 0.25, 0.375, 0.375, 0.125, 0.125});
//        map.put('C', new double[]{0.0, 0.375, 0.125, 0.125, 0.5, 0.125, 0.25, 0.125, 0.25, 0.125, 0.5, 0.25, 0.25, 0.125, 0.125, 0.125, 0.375, 0.375, 0.125, 0.125, 0.375, 0.25, 0.25, 0.25, 0.0, 0.125, 0.5, 0.125, 0.625, 0.375, 0.125, 0.25, 0.375, 0.25, 0.125, 0.25, 0.0, 0.375, 0.375, 0.25});
//        map.put('G', new double[]{0.375, 0.0, 0.5, 0.5, 0.375, 0.625, 0.25, 0.125, 0.25, 0.25, 0.125, 0.5, 0.125, 0.25, 0.125, 0.375, 0.0, 0.25, 0.5, 0.375, 0.125, 0.25, 0.0, 0.0, 0.75, 0.5, 0.25, 0.375, 0.125, 0.125, 0.375, 0.25, 0.375, 0.375, 0.125, 0.25, 0.125, 0.25, 0.0, 0.25});
//        map.put('T', new double[]{0.375, 0.0, 0.25, 0.375, 0.125, 0.125, 0.125, 0.25, 0.25, 0.375, 0.125, 0.125, 0.125, 0.25, 0.5, 0.125, 0.375, 0.25, 0.0, 0.125, 0.5, 0.125, 0.375, 0.375, 0.25, 0.25, 0.125, 0.25, 0.125, 0.25, 0.25, 0.25, 0.0, 0.0, 0.25, 0.25, 0.5, 0.0, 0.5, 0.375});


        findingProfile(dna, k, map);

    }
}
