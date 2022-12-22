import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String strategy = """
            A Y
            B X
            C Z
                """;
        HashMap<String,Integer> pointTable = new HashMap<>();
        pointTable.put("R", 1);
        pointTable.put("P", 2);
        pointTable.put("S", 3);
        pointTable.put("X", 0);
        pointTable.put("Y", 3);
        pointTable.put("Z", 6);

        HashMap<String,String> conditionMap = new HashMap<>();
        conditionMap.put("A Y","R");
        conditionMap.put("A X","S");
        conditionMap.put("A Z","P");

        conditionMap.put("B Y","P");
        conditionMap.put("B X","R");
        conditionMap.put("B Z","S");

        conditionMap.put("C Y","S");
        conditionMap.put("C X","P");
        conditionMap.put("C Z","R");

        BufferedReader br = new BufferedReader(new FileReader("lib/day2.txt"));

        int myScore = 0;
        String line;
        // for (String line : strategy.split("\n")) {
        while ((line = br.readLine()) != null) {
            String strStra = line.trim();
            String[] moves = strStra.split(" ");
            
            String roundResult = "";

            roundResult = conditionMap.get(strStra);
            myScore += pointTable.get(moves[1]) + pointTable.get(roundResult);
        }
        System.out.println(myScore);
    }
}
