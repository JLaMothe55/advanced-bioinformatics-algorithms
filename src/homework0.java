class nucleotideCounter {

    //Function for counting the number of nucleotides in the dna and then logs it in the terminal
    public static void counter (String dna){
        int aCounter = 0;
        int cCounter = 0;
        int gCounter = 0;
        int tCounter = 0;

        for (int i = 0; i < dna.length(); i++){
            if (dna.charAt(i) == 'A'){
                aCounter++;
            }

            else if (dna.charAt(i) == 'C'){
                cCounter++;
            }

            else if (dna.charAt(i) == 'G'){
                gCounter++;
            }

            else {
                tCounter++;
            }
        }

        System.out.println(aCounter + " " + cCounter + " " + gCounter + " " + tCounter);
    }

//main function which passes the dna string to the counter function
    public static void main(String[] args)
    {
        String dna = "CATGCTGGTCTCGACGCAAGTATGCGACATATTAGCAACAGAAAGCCGTAGAGCCAGGACAACAGTATTTCAAGGCCCTTCCTTCTTACACACGCCTAAGGGTCTGAAGAGCGTTTTAGCTGAAAAACACCTCTAGTTTCGCGGACAAGAGTTAAAGGACGGCCGTTCGTCGGCGTATCTTAGGTAAGCGCACGTACCAGTTGAGCAATTCCGTCGTAGCTAAAACTTCCGGTTGCCAGTATGTATATACTAATTTGGACACGTACCACGACGAATCACTACGGCCCTTAAAGGACGTTAGATTTATTGCCGCCCTTTCACGAATTGGTCCACCAGTATACCAGACCACCATGCCACGCACCTGTAGTGTGACCCAGGCACCTCGCCGCGATTATGGCACGGCTGCGTGGTTGGGTGTGAGCGAGGGAGGACTAGAGTAACGAACCTGGCAGGATCTCATGAAATCCAAACCGTCGGGCACCCTTATAAAATATGTGAATATCGAATAGGCCGCCATAGGCTAGAATGCCATCGCACCATGGCACCGCGAGATGAGCCAATAAGTGCGTGACCGTTCTGTTCAGCTTGGCGGGGTTCCCCGTTATTACCGCTATGGGCAAGAGGTCGTGTGTACCCCCATCGACCGCAATACCCTTTATAAGCATATCAGTTAGGCGTTCAGGCCCTGGGTAACATCTCCCACCTATCGAAGACCCAATGGAATGTGCATGCGTCCAGGGGCAGCTTCGGAGGTACCGTGCGAGTGGAGCAGCATTGTACTTATCGCCGTCTTCCACTGTTCTCAAGTGATGGCTACCTGCGACTATGTGAGCCTCCATTACGTAGGGCAGTACCTTCACGCCT";
        counter(dna);
    }
}

