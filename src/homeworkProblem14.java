import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class homeworkProblem14 {

    public static void findingFinalString(Map<String, List<String>> debrujinGraph, int k){
        ArrayList <String> nodeList = new ArrayList<>();
        Map<String, Integer> listForFirstNode = new HashMap<>();
        ArrayList <String> anotherNodeList = new ArrayList<>();
        String endKmer = "";

        listForFirstNode = findingFirstNode(debrujinGraph);

        System.out.println(debrujinGraph);

        for (Map.Entry<String,Integer> node : listForFirstNode.entrySet()){
            if (node.getValue() == -1){
                nodeList.add(node.getKey());
                endKmer += node.getKey();
            }
        }

        while (nodeList.size() != 0){
            String u_v = nodeList.get(nodeList.size() - 1);

            try{
                String w = debrujinGraph.get(u_v).get(0);
                nodeList.add(w);
                debrujinGraph.get(u_v).remove(w);
            }
            catch(Exception e){
                anotherNodeList.add(nodeList.get(nodeList.size() - 1));
                nodeList.remove(nodeList.size() - 1);
            }
        }

        for (int i = anotherNodeList.size() - 2; i >= 0; i--){
            String node = anotherNodeList.get(i);
            endKmer += node.charAt(node.length() - 1);
        }

        System.out.println(endKmer);
    }


    public static Map<String, Integer> findingFirstNode(Map<String, List<String>> debrujinGraph){
        Map<String, Integer> nodeValues = new HashMap<>();

        for (Map.Entry<String,List<String>> node : debrujinGraph.entrySet()){
            nodeValues.put(node.getKey(), 0);
            int count = node.getValue().size();
            count = count - count * 2;

            nodeValues.put(node.getKey(), count);
        }

        for(Map.Entry<String,List<String>> node : debrujinGraph.entrySet()){

            for(int i = 0; i < node.getValue().size(); i++){
                if (nodeValues.get(node.getValue().get(i)) == null){
                    nodeValues.put(node.getValue().get(i), 1);
                }

                else {
                    int currentCount = nodeValues.get(node.getValue().get(i));
                    currentCount++;
                    nodeValues.put(node.getValue().get(i), currentCount);
                }
            }
        }

        return nodeValues;
    }


    public static Map<String, List<String>> letsMakeADebrujinGraph(ArrayList<String> kmerList){
        ArrayList<String> kmers = new ArrayList<>();
        Map<String, List<String>> listOfThings = new HashMap<>();

        for (int i = 0; i < kmerList.size(); i++){
            String potentialPrefix = kmerList.get(i).substring(0, kmerList.get(i).length() - 1);

            if (!kmers.contains(potentialPrefix)){
                kmers.add(potentialPrefix);
                listOfThings.put(potentialPrefix, new LinkedList<>());
            }
        }

        for (int i = 0; i < kmerList.size(); i++){
            String prefix = kmerList.get(i).substring(0, kmerList.get(i).length() - 1);
            String suffix = kmerList.get(i).substring(1, kmerList.get(i).length());

            listOfThings.get(prefix).add(suffix);
        }

        return listOfThings;
    }


    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> kmerList = new ArrayList<>();
        Map<String, List<String>> itsADebrujinGraph = new HashMap<>();

        String routine = "C:/Users/Joesph/Downloads/";
        String doc_name = "rosalind.txt";

        Scanner readIn = new Scanner(new File(routine + doc_name));

        while(readIn.hasNextLine()){
            String currSeq = readIn.nextLine();
            if(currSeq.length() > 1)
                kmerList.add(currSeq);
        }

        kmerList.remove(0);

        int k = kmerList.get(0).length();

        itsADebrujinGraph = letsMakeADebrujinGraph(kmerList);

        findingFinalString(itsADebrujinGraph, k);
    }
}
