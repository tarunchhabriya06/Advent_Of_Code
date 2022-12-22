import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        String testdata = """
                2-4,6-8
                2-3,4-5
                5-7,7-9
                2-8,3-7
                6-6,4-6
                2-6,4-8
                                """;

        BufferedReader br = new BufferedReader(new FileReader("lib/day4.txt"));
        int fullOverlapCount = 0;
        int partialOverlapCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            // for (String line : testdata.split("\n")) {

            int arrPairOneRange1 = Integer.parseInt(line.trim().split(",")[0].split("-")[0]);
            int arrPairOneRange2 = Integer.parseInt(line.trim().split(",")[0].split("-")[1]);

            int arrPairTwoRange1 = Integer.parseInt(line.trim().split(",")[1].split("-")[0]);
            int arrPairTwoRange2 = Integer.parseInt(line.trim().split(",")[1].split("-")[1]);

            if ((arrPairTwoRange1 >= arrPairOneRange1 && arrPairOneRange2 >= arrPairTwoRange2)
                    || (arrPairTwoRange1 <= arrPairOneRange1 && arrPairOneRange2 <= arrPairTwoRange2)) {
                fullOverlapCount++;
            }

            if (((arrPairTwoRange1 >= arrPairOneRange1 && arrPairOneRange2 >= arrPairTwoRange1)
                    || (arrPairTwoRange2 >= arrPairOneRange1 && arrPairTwoRange2 <= arrPairOneRange2))
                    || ((arrPairTwoRange1 <= arrPairOneRange1 && arrPairOneRange1 <= arrPairTwoRange2)
                            || (arrPairTwoRange1 <= arrPairOneRange2 && arrPairTwoRange2 >= arrPairOneRange2))) {
                partialOverlapCount++;
            }

        }
        System.out.println(fullOverlapCount);
        System.out.println(partialOverlapCount);
    }
}
