import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        String testdata = """
$ cd /
$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
$ cd a
$ ls
dir e
29116 f
2557 g
62596 h.lst
$ cd e
$ ls
584 i
$ cd ..
$ cd ..
$ cd d
$ ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
                """;
        
        BufferedReader br = new BufferedReader(new FileReader("lib/day7.txt"));

        List<String> commands = new ArrayList<>();
        Stack<String> paths = new Stack<>();
        HashMap<String,Integer> dir_size = new HashMap<>();
        HashMap<String,List<String>> children = new HashMap<>();
        // String line;
        // while ((line = br.readLine()) != null) {
        for (String line : testdata.split("\n")) {
            if(line.charAt(0) != '$'){
                commands.add(line);
            }else{
                commands.add(line.substring(2));
            }
        }

        System.out.println(commands.toString());

        // String[] commandsAndOp = fileInput.split("\n");
        for(String command : commands){
            
        }
    }
}
