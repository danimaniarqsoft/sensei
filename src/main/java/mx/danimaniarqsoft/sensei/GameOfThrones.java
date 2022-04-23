package mx.danimaniarqsoft.sensei;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Result {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
        if (s.length() == 1) {
            return "YES";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        char[] elements = s.toCharArray();

        int deep = 0;

        for (char c : elements) {
            Integer result = map.get(c);
            if (result == null) {
                map.put(c, 1);
                deep++;
            } else {
                result = result + 1;
                deep = result % 2 == 0 ? (deep - 1) : (deep + 1);
                map.put(c, result);
            }
        }

        if (deep == 0 || deep == 1) {
            return "YES";
        } else {
            return "NO";
        }

    }

}

public class GameOfThrones {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
