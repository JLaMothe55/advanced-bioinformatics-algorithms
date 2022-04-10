import java.util.ArrayList;

public class homeworkProblem11 {
    public static double scoreSquared(double[][] matrix, String passedOverKmer){
        double currentScore = 1;

        for (int i = 0; i < passedOverKmer.length(); i++){
            double count = 0;

            switch(passedOverKmer.charAt(i)){

                case 'A': count = matrix[0][i]; break;
                case 'C': count = matrix[1][i]; break;
                case 'G': count = matrix[2][i]; break;
                case 'T': count = matrix[3][i]; break;

            }

            currentScore = currentScore * count;

        }

        return currentScore;
    }


    public static String profileMostProbable(String currentDna, int kmerSize, double[][] matrix){
        String currentKmer = currentDna.substring(0, kmerSize);

        double currentScore = scoreSquared(matrix, currentKmer);

        for (int i = 1; i < currentDna.length() - kmerSize + 1; i++){

            String nextKmer = currentDna.substring(i, i + kmerSize);
            double nextScore = scoreSquared(matrix, nextKmer);

            if (nextScore > currentScore){
                currentKmer = nextKmer;
                currentScore = nextScore;
            }
        }
        return currentKmer;
    }


    public static double[][] creatingAMatrix(ArrayList<String> currentMotifs){
        double[][] matrix = new double[4][currentMotifs.get(0).length()];

        for(int i = 0; i < currentMotifs.get(0).length(); i++){
            double A = 1;
            double C = 1;
            double G = 1;
            double T = 1;

            for (int j = 0; j < currentMotifs.size(); j++){
                char currentChar = currentMotifs.get(j).charAt(i);

                if (currentChar == 'A'){
                    A++;
                }
                if (currentChar == 'C'){
                    C++;
                }
                if (currentChar == 'G'){
                    G++;
                }
                if (currentChar == 'T'){
                    T++;
                }
            }

            matrix[0][i] = A / currentMotifs.size();
            matrix[1][i] = C / currentMotifs.size();
            matrix[2][i] = G / currentMotifs.size();
            matrix[3][i] = T / currentMotifs.size();
        }

        return matrix;
    }


    public static ArrayList <String> nextBMotifs(ArrayList<String> bMotifs, ArrayList<String> dnaStrands, int kmerSize, int amountOfDnaStrands){
        int highestScore = score(bMotifs);

        for (int i = 0; i < dnaStrands.get(0).length() - kmerSize + 1; i++){
            ArrayList<String> currentMotifs = new ArrayList<>();

            currentMotifs.add(dnaStrands.get(0).substring(i, i + kmerSize));

            for (int j = 1; j < amountOfDnaStrands; j++){
                double[][] matrix = creatingAMatrix(currentMotifs);
                String currentDna = dnaStrands.get(j);

                String profileMostProbableMotif = profileMostProbable(currentDna, kmerSize, matrix);

                currentMotifs.add(profileMostProbableMotif);
            }

            int currentScore = score(currentMotifs);
            if (currentScore < highestScore){
                highestScore = currentScore;
                bMotifs = new ArrayList<String>(currentMotifs);
            }

        }

        return bMotifs;
    }


    public static int score(ArrayList<String>bMotifs){
        int score = 0;

        for (int i = 0; i < bMotifs.get(0).length(); i++){
            int A = 0;
            int C = 0;
            int G = 0;
            int T = 0;

            for (int j = 0; j < bMotifs.size(); j++){

                if (bMotifs.get(j).charAt(i) == 'A'){
                    A++;
                }

                if (bMotifs.get(j).charAt(i) == 'C'){
                    C++;
                }

                if (bMotifs.get(j).charAt(i) == 'G'){
                    G++;
                }

                if (bMotifs.get(j).charAt(i) == 'T'){
                    T++;
                }
            }

            int maxCharAmount = 0;

            if (A > maxCharAmount){
                maxCharAmount = A;
            }

            if (C > maxCharAmount){
                maxCharAmount = C;
            }

            if (G > maxCharAmount){
                maxCharAmount = G;
            }

            if (T > maxCharAmount){
                maxCharAmount = T;
            }

            score = score + bMotifs.size() - maxCharAmount;
        }
        return score;
    }


    public static void main(String[] args){
        ArrayList<String> dnaStrands = new ArrayList<>();
        int kmerSize = 12;
        int amountOfDnaStrands = 25;

        dnaStrands.add("TTTGCCGTGCGGTTTTCTAGAAAGAAAATCGAGCTCTCGTCGCCCAGGTCACAGGTCTTCCTAGATGAAGTTGCGTGCGTGGTGGTTGTCCGATGTGCGAGGTGTCAAAGTCTACGAGATGGGATCTAACCATCAGGGTACCTGGACGCCCTTTTC");
        dnaStrands.add("CCAGAATAGCACACTTGAAAGGCTCAAGTCGGTTAAGATGCTGTAGGTCTGAAAAGCTACGGGGCGCGAACGTTAGAAGCTGGAGGCGTTGACTACTCGGAGTGAATTTACGTCGCGCGGGACGACCATTCATAGCAGAACTTAGTGATGATCCGT");
        dnaStrands.add("ACACGGCGGCCGGTAAAGGATATTTGCGAGATTGGCGGGGCTCGATAGGTTAGCTCGAGATAACATGCGTGCACTTAGAAAGGGTTCAGCAGTAGGGATAACTCTCGTAACGGTGCGTTGTAGAATCAAAATTGTGACGCGCGGGATCCTTCGAGT");
        dnaStrands.add("TCGCGGACCTCTAGGATGTCCTTATATGCAGTTCCGAGGCGCTGGATTTAGGTCGAGCGGATTCAGATACGGAGAATACGCCTCGGTAAAACTGTGCAGCTATTATTTACGCCTACGTAGCTTCGACCTGCCCCCGAAGTACGCGCTACATTCCAT");
        dnaStrands.add("TCCTTATATAAGCTGCCATTATTCGCTGGCAGGCGAGTAGGACGCAGCAAACCTGCCGCCAGCCATCGGCTACGGGAATTGGATAAGTAAGATCTTTGTGCCGTGCGGTCGGGAGACACCAGATTTCATACTGTACTAGCAGATACTCGATTGACT");
        dnaStrands.add("GCCCTGGCTAGCCAAGTACCACAGTTGGGTCGGTGTCTGCGAGGCCCTCAAACAGGTGTCAATAGGGGGACGTAATGTAAAAGTGACAAACTATTGACGATTTATCGCTAGGTCGAGCGGTGCAAGAGATAAACTCTCTTACTTCGGCAACCTTCG");
        dnaStrands.add("GACAATTATCGTTTAGGCCCCAACCGGCCATAAGCATCAACATTATATCTACTAGAACATGGCTAACGTAGAGACCTGGCGCGGTCGAGTTCCAAGTTCTGTGGCCATGGTAATCTCATATACGACGCGCGGGTCGGTACAGACGGTATCCGAGTC");
        dnaStrands.add("AGCTATCGATATAGATGGAAATCGGTTAATAGCACGGAAGGGGATGACCTCTGGGGACCATATAACTGGTCCATCGCACCTGTCATGTACTGCGGATCAGTCGTAGCGAGAAAACAACAGTACGTCGCGCGGTGCGGCGTAGCCCAACACCGAGAG");
        dnaStrands.add("ACGCAAGGGCAAGTTATTGATCGATTGGGCGAGCGGAACATGTCAATCACGAGGCCCCATTTGGGTGCGTCCATGCATGCTCAGTTCCACTCCAAATCGCAAGAGCTACCTTGGATCATTTCATCTGCTTGGACGCATTGTCGTTCGACAAATACC");
        dnaStrands.add("CCGGCGCGGTTAGACCGACATTAGGCACGCCCGAGAATCGCGATGGTTTCTTTTATTCATCAGCTCACAGAATATGCAAGGGCTACTGATCTGCATGCGGAGCCCCAATTGGACGTGCGGGACCGAAACTGGATAACTGCACGAGGGGAAACTATG");
        dnaStrands.add("TCACTGATATGACTACATTTGCACTCAGGGAAACGGCCACACGCTTATCGATTGAAGTTGTACTCTAATCCACAATTCCGAACGGCCGTCGGAGAAGCACTTCCAAATTGCTCGCGAGGTGATCCGCCCGGATCAGGCGAGCGGCGCGTTGGAGCC");
        dnaStrands.add("TATGGCGCGCGGAGCTTGTTGTGCGCCCGGGTTTAGCCAGGATGACCCTTTTCCACTCTGTGGCACCTTACTCCCGGCATTTACTTACTGGGCATGTACCGGGGAAGTTGTCGAACCGCCCACGTTTCTCGCTTTAGAGTTCTTTGTGTGACGGCC");
        dnaStrands.add("GCAGGCCCCGTGGCCCACCGGGCCCTTCGAATTAATACGCGCTCGCTTGGTGCCGGTAGGATCCGGTCTCCAATTCAGGCAGCTATATGACAAGCCGATAATAAATGTTTCGGCGTGCGGCATGCCCGACACTATAATTGCATGGCCCAGCTCGAT");
        dnaStrands.add("TTTTAACATCCGTTTTAAGCCTACTGTACGGGAACAATATTATGTGTATTAGTCAAGGCTGTATGCAGCGTCTCTTTAAATAATTGCGGCGCGCGGTTCTAAATTTCTTTAGGAAGAGTACTAGAGGACCTGTTCGACCGATCCGTCAAGTGTGGA");
        dnaStrands.add("AACTGCTCCTTAATGCATTGATCCTGTGCCGGGCGGCATTGGGCATTGGCTATTTCCTGTCGGCCCAAGAATGCTTGTGTATATGCCCCTGTTATATGCACTGTTGGCTTCGCTGAATTCATCGCAGGCTGACCCTTTAGAAGTGTGCAACGATTG");
        dnaStrands.add("CCAGGGGTTTACCATGCTCAGGTCACTCGGCATCCTTTTCCGCTGACACTCGTTGAAGGACCCTAGGACTGTCAAGCAACAATTTCCGCAGAGATATCTGACGCTCTCTCGGGGGACGAGTTATCAAAGCTGTGCGACGCGCGGGATGTGTCCACA");
        dnaStrands.add("CTTTGTACGCTCGCTCGATCCGAGCCTAAAATTCAGAGTGATTCGGAACAGCTTGATTGAATCTGCGCGCTTCTAGGCAAGAGGTAACCTAAACCTCTGTGACCACTGTGACTGCTCTATTGAGTCGAGCGGTACACTAAATTTCGACCGAGATCA");
        dnaStrands.add("CTCTCTCATTGGTTATCGGCGGATATAGGGGCCCATAAGGCCGACAAACACGCCTATGGCGCCGCCAGCAATTCGGTCGGGCGGTATGTCGCAGGGTTTTAACTGCCAACTTGACCTTACATCAGGTCCTTACGCGTTGCTCGGCATAGCCGGTGC");
        dnaStrands.add("GTGAATACAAATGCCCCGGAGATGATGTAGTACCATGGGGATAGAGCTAAGAAACGAAGCGACTACCATACTTAACCCCTATCATATAACGCCCGATCTGACGAGCGGATGTGTTGCACTTCCGCCTTTCAGTTGAAGTAGCAATTCCAATCAGAC");
        dnaStrands.add("GACCCAACGCTATAAATTCGCGCATGCAATAAGCATTTCGGCGCGCGGGATCTTCGGGTACTACGGCGGACTACCCGGGATATCCGCGTCAATTCTTGGGAACAACGAGTTTGTTTTGGGGGGGTAACAGATACTATATCCGAGAAGCACAGTTCG");
        dnaStrands.add("TAAAATTTGGAGGAGCCACACATCCGTTACCCGAAAATTCCGCATACTGTATTTCATGCTTGAGCCGGGCGGGACGGTGCAGCCTAACTTGATTCGCCTCGAAGGCTCCCGGAAGCATGTCGGCTGTCCAGGGTGAGTACCCGTGACCGATCTAGG");
        dnaStrands.add("CGCCTCTACTCTCAACCCATGCCGGTGATAGAGGTTGCACTTTTTAACATATATTCCGCGTAAGGCGGGCGGCACGGTGCTCTACACTCGAACATCAAACTCAACAAAGTCTGATAAAAGCGACAGGTGGAATGCCGGAGGATAAATTGCCAGTAG");
        dnaStrands.add("CAACGCTCTTAGGCAGCCCTCTCAAGGCTCCGATTGACCTTTGTATTGATCTATTTGATCCTTTCTGACTTGAATGCAATAAGGGCGGATGCCAAGCCATTCTGATTGAACCATTAGTGTACGCCTATTCAGTATGTCGGGCGGTCAAGATAACGT");
        dnaStrands.add("ATTGGAGGAAGCTGGGTAAAAAACTATTTAACAGCCGAAAAACTGAGCAACGAGGGTACACCGCAATTGCGTCTGAATGTAAGTAGAAGGCCTGCGTGAGATGAGTTCTGATGGGCGTGGTACAGTGAGTCATTGGGCGTGCGGCGTGGTATTCGA");
        dnaStrands.add("GAGCCGGGGGCACCTATAAGTCGATAAGTCGTGCGGCACTATAGGGTGCGACTTCGCCCCTGTGGGCACTTAATGCGCGGTCATGAGAACCTTGATTCAAGATCCATAGAGTAATTGAGAATGGCCCAATGAGAGCCGGGTCCGTCTCATAGTCGG");

        ArrayList<String> bMotifs = new ArrayList<>();

        for (int i = 0; i < dnaStrands.size(); i++){
            String kmer = dnaStrands.get(i).substring(0, kmerSize);
            bMotifs.add(kmer);
        }

        ArrayList<String> greediestMotifs = new ArrayList<>();

        greediestMotifs = nextBMotifs(bMotifs, dnaStrands, kmerSize, amountOfDnaStrands);

        for (int i = 0; i < greediestMotifs.size(); i++){
            System.out.println(greediestMotifs.get(i));
        }
    }
}
