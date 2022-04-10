public class homework1_4 {

    //function to find reverse compliment of dna strand
    public static void reverseCompliment(String dna){
        String compliment = "";
        for(int i = dna.length() - 1; i >= 0; i--){
            if(dna.charAt(i) == 'A'){
                compliment += 'T';
            }
            else if (dna.charAt(i) == 'T'){
                compliment += 'A';
            }
            else if (dna.charAt(i) == 'G'){
                compliment += 'C';
            }
            else {
                compliment += 'G';
            }
        }
        //prints out reverse compliment of dna strand
        System.out.println(compliment);
    }

    //main function
    public static void main(String[] args)
    {
        String dna = "AAAACCCGGT";
        reverseCompliment(dna);
    }
}
