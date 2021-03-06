public class homeworkProblem6 {

    public static void hammingDistance(String dna1, String dna2){
        int distance = 0;
        for(int i = 0; i < dna1.length() || i < dna2.length(); i++){
            if (dna1.charAt(i) != dna2.charAt(i)){
                distance++;
            }
        }
        System.out.println(distance);
    }

    public static void main(String[] args){
        String dna1 = "TCAAAACGGACTTAAAGAAAGCAGCAAGGATATTAAGACCATAGTTGGATTGCCCGCAGACGGGGAGGGCTCAAGGCACTTACCTGCTTTCTTCATCTATTACTACACGAATCGGACGATGCATGTTATGGGGCGGCGTCGTATACGGTGAGGAAACCCGGGCTCAATGTTAATTTCTTCACGGGTCTCTGTGTTGCCCGTGTCAAGCGCGACTTACAAGCGCACTCAGGTACCGAGCATCAGTTGCAACTGTTTCGGCCGCAACCTCTCGTGGCCACTCCCGACGGGAGGCTTGAAGGGCACTGTACTTTGCGCCCCCGTAGCTGGCTCTGAGAGGGCTCGAACCTATAATGGAGGCGTAGTGAGGCCGAGATAGGACGGTAACGGACCTCTCCAAATTCAGAACGACTACCCCTCACATTCTATCCCATTAGTGGTCCTTAGTGAAATTTTGTTACACGGAGGCAACTAGGGCCGTTAAACTTCCTACACCTACTCTTCGTTTCTCACACCATGCAGACAATCGGGTTATTTCCCTGGGATTTAAATGTATAGAAACGATAGGTCAGGTATCCACGGCCGCGCTGGTTGTCCCCCTTAAGCCGCCGATTAACCATCCCCCCTGATCCTGCTCGTTACTCTCGGTAATGACACTTAATGGCCATTCATTGGTTACAATGTGACTAGGCGGACAGTGTAAGACCAAGGCAAATGCCGCACTATTTGGCGAGACGTCTCCGAGTACACCTCAGGTCTTTCTCGAGAAGTGTTCGACAGTCCTAACGGAAGTCCTGGGGACTTGCAATGCGGATGAAGGCACCCCATAGTCGTCAGTAATGATGCAGGCTCGCGAAGAAAGAACCACTCAGGTTCAGAGATCCGCTCCGTCGATCTCCCGTGCGTATCGGTGGATTACGGAATCTCTCCTTACACTTCACAACTCACCTCTCTCTGCGAAAACAGCGTACTACGGCGAGGTGAAGGATCAAATCAGGTGAACTATACAAGGGCCTGCATTATTTTTAATACCAATTGGAGCACACTCGCATTCGCGTCCACACGAGATTAGTCCTTGAAAGTGACCAGTCTCTGACATCGTAGGAGCCGGAAGTTGCGAGTCACCTCCTCATAGATAGCATTTCAGCCACTCGCTTACCATTTCAAGCGAGGAAGGGTCAGCCCTCATGTCA";
        String dna2 = "TACTTCTGTAGATTTCTCATAAAGTCACCAGGTCTCCTAAGAAGCATAACCGGAAAACATCCACTCGATCCCACGGTCTTAGGAGAAATGAGTCTGAATCAGTGAAGCATGCAGTTCTTGGTAGAAATGTAAGTCAAAATCCTGGGCCGATTAGGAACGCCGTCCTGGAGGGTTGGGTGTCCGCAATAAACATCCGTTAATTGGTGCGGGGGTTAAGTGGTTGTCTCCTCAGGTACTCCCACGGCGAACTTTCTCATACATATAGTGTGTCCAATGCCCGTCATCGGATAACTCCGTCGTGAGACGCAGATTGTACCGTGGTAACCCCGGCCGACACCAGCGTTCATAGAAACTTCGAAGAGGCCCATCCAATCGTATATGGCTCCGATAACCAACACGAGGGAATAAGGCTATGAGCACCAGGGCGTCTGGATCTACACTGTATCCGGCAGAAAGTTAGTACGTGCTTGTGTAGTTTTGTAATTTGGGTGAGAACCTTTGCATTATCCTCAGATTGTGGATTTGCGAGCAATCCTGTAGCCTTAGACCACGCAACGACGGTTGTTTTAGGTTGTTGTTATACACCTGGTGGCTGAATTAAAACGAGCCCTTAACATTGAACGCTTCCCACGGATGTTGACCACCTCGAATGATATCCCCTAATGTAAGAACGGGCCGCCTGATCCGATATTACCTACCCCAAGACAACATTCGCCAGCCTAACACCGCCCTTAAGCTTCCAGAGCATATTCCTTAAATATTCTGCCCAGGGTTAGAACGGCTAATACGAGGAGCTCCTTCCTTTCAGTCCGACCACGACGAGTGTTGACACAGTCAGCTGGAGGGCGCATAGGCCTACGATAGGCGGTTGGGCAGGTGTAAACCGTTTCGAGTGCGGCTCTAATACAAAGTAACCCCCAGCCATTGGTATATCGCTGATAGTGTGGCACATAATGCCACAGTTGGAACGTCAGGACGTCTCCTGCAGGAACAAAGTGAGTGATCGACCGGCCAGATTCCCCACAATTCGTGGTAACTTTGTCGTGAGGCTATGGGGAGTTCCGTGTTGCGCTGGGTGGAGTGTACCAACATCAGGTATGCATGTCATGCATCCAATCTACCAGTTTTTTACAGGCGCGTCCAACCCATGAAATGTGACGGTTCGTTCGGAATTCCTTTAAGCAGCGTAA";

        hammingDistance(dna1, dna2);
    }
}
