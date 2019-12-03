import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BullsCows {
    BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {
        BullsCows bullsCows = new BullsCows();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String base = "1230";//3244
        char[] compare = str.toCharArray();
        char[] number = base.toCharArray();
        int[]res  = bullsCows.checkBullCow(number,compare);
        System.out.println("Bulls " + res[0] + " cows " + res[1]);
    }

    public BullsCows(){

    }

    public int[] checkBullCow(char[] number, char[] compare) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < 4; i++) {
            if (number[i] == compare[i]) {
                bulls++;
                continue;
            } else {
                for (int j = 0; j < 4; j++) {
                    if (number[i] == compare[j]) {
                        cows++;
                        continue;
                    }
                }
            }

        }
        System.out.println("Bulls " + bulls + " Cows " + cows);
        int[]ints = new int[2];
        ints[0] = bulls;
        ints[1] = cows;
        return ints;
    }
}
