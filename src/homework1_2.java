public class homework1_2 {

    //function to determine how often a pattern appears in a string
    public static void patternFinder(String dna, String pattern){
        int counter = 0;

        for (int i = 0; i < dna.length() - pattern.length() + 1; i++){
            if (dna.substring(i, i+pattern.length()).equals(pattern)){
                counter++;
            }
        }
        //prints out counter
        System.out.println(counter);
    }

    //main function
    public static void main(String[] args)
    {
        String dna = "";
        String pattern = "AAGGACAAA";

        patternFinder(dna, pattern);
    }
}
