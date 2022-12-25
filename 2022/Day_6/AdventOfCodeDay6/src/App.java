import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String testdata = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
        
        BufferedReader br = new BufferedReader(new FileReader("lib/day6.txt"));
        String fileInput = br.readLine();
        
        String[] chars = fileInput.split("");
        List<String> buffer = new ArrayList<>();
        int idx = 0;
        for(String s : chars){
            if(buffer.size() > 12){
                buffer.add(s);
                if(buffer.size() == new HashSet<>(buffer).size()){
                    idx++;
                    break;
                }
                buffer.remove(0);
            }else{
                buffer.add(s);
            }
            idx++;
        }

        System.out.println(idx);
    }
}
