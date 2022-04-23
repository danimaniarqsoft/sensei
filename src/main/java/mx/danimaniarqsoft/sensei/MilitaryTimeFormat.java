package mx.danimaniarqsoft.sensei;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {

        String[] elements = s.split(":");
        int hours = Integer.parseInt(elements[0]);

        String hoursString = "";
        String seconds = elements[2];

        int indexOfPm = s.indexOf("PM");
        if (indexOfPm > -1) {// es PM

            if (hours == 12) {
                hoursString = elements[0];
            } else {
                hours = hours + 12;
                hoursString = hours + "";
            }

            seconds = seconds.replace("PM", "");

        } else {// es AM
            if (hours == 12) {
                hoursString = "00";
            } else {
                hoursString = elements[0];
            }
            seconds = seconds.replace("AM", "");
        }

        return hoursString + ":" + elements[1] + ":" + seconds;
    }

}

public class MilitaryTimeFormat {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
