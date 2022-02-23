import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;

        // add all lines in the txt file to the ArrayList
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        // choose the word that you want to find
        String wordToFind = "the";

        ArrayList<Integer> positionsOfWord = findWordIndex(lines, wordToFind);
        System.out.println("Indexes in ArrayList with "+wordToFind+":");
        System.out.println(positionsOfWord);
    }
    // method to find word in ArrayList
    public static ArrayList<Integer> findWordIndex(ArrayList<String> sentenceList, String word) {
        ArrayList<Integer> posList = new ArrayList<>();
        for (int i = 0; i < sentenceList.size(); i++) {
            // checks to see if the word is in the ArrayList
            if (sentenceList.get(i).indexOf(" "+word+"") > 0) {
                posList.add(i);
            }
        }
        return posList;
    }
}
