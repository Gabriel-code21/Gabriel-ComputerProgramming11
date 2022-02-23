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
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        String wordToFind = "the";

        ArrayList<Integer> positionsOfWord = findWordIndex(lines, wordToFind);
        System.out.println("Indexes in ArrayList with "+wordToFind+":");
        System.out.println(positionsOfWord);
    }

    public static ArrayList<Integer> findWordIndex(ArrayList<String> sentenceList, String word) {
        ArrayList<Integer> posList = new ArrayList<>();
        for (int i = 0; i < sentenceList.size(); i++) {
            if (sentenceList.get(i).indexOf(" "+word+"") > 0) {
                posList.add(i);
            }
        }
        return posList;
    }
}
