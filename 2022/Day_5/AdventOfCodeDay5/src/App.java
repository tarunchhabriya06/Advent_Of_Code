import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        String stacksDesc = """
    [D]
[N] [C]
[Z] [M] [P]
 1   2   3

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
                """;

        BufferedReader br = new BufferedReader(new FileReader("lib/day5.txt"));

        String fileInput = "";
        String line;
        int lineCounter = 0;
        while ((line = br.readLine()) != null) {
            if (lineCounter == 0) {
                fileInput = line;
                lineCounter++;
            } else {
                fileInput = fileInput + "\n" + line;
            }
        }

        // System.out.println(fileInput);

        int stackIndexLine = 9;

        String[] Parts = fileInput.split("\n\n");

        String[] drawing = Parts[0].split("\n");
        String[] moves = Parts[1].split("\n");
        List<Stack<String>> crates = new ArrayList<Stack<String>>();

        for (int i = 0; i < stackIndexLine; i++) {
            Stack<String> tempST = new Stack<>();
            crates.add(tempST);
        }

        for (int i = drawing.length - 2; i >= 0; i--) {
            int stringLength = drawing[i].length();
            // System.out.println(stringLength);
            // System.out.println(drawing[i]);
            int StackNum = 0;
            for (int j = 1; j < stringLength; j = j + 4) {
                if (!Character.isWhitespace(drawing[i].charAt(j))) {
                    crates.get(StackNum).push("" + drawing[i].charAt(j));
                    // System.out.println(crates.get(StackNum).peek());
                }
                StackNum++;
            }
        }

        for (int i = 0; i < moves.length; i++) {
            String[] tokens = moves[i].split(" ");
            int n = Integer.parseInt(tokens[1]);
            int src = Integer.parseInt(tokens[3]);
            int dtn = Integer.parseInt(tokens[5]);
            String element = "";
            for(int j = 1;j <= n;j++){
                element = element + crates.get(src-1).pop();
            }
            // System.out.println(element);
            for(int K = element.length()-1;K >= 0;K--){
                crates.get(dtn-1).push(""+element.charAt(K));
            }
        }

        for (int i = 0; i < crates.size(); i++) {
            // System.out.println(i);
            System.out.print(crates.get(i).peek());
        }
    }
}