import java.util.LinkedList;
import java.util.List;


public class homework1_3 {

    public static int patternFinder(String dna, String pattern){
        int counter = 0;

        for (int i = 0; i < dna.length() - pattern.length() + 1; i++){
            if (dna.startsWith(pattern, i)){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args)
    {
        int max = 0;
        List<String> stringList = new LinkedList<>();
        String dna = "AATTAATTGGTAGGTAGGTA";
        int patternLength = 4;

        for(int i = 0; i < dna.length() - patternLength; i++){
            String pattern = dna.substring(i, i+patternLength);
            int count = patternFinder(dna, pattern);
            if (count > max){
                stringList.clear();
                max = count;
            }

            if(count == max && !stringList.contains(pattern)){
                stringList.add(pattern);
            }
        }

        System.out.println(stringList);

    }
}
