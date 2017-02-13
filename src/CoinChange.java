import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class CoinChange {
    static HashMap<Integer[], Integer> solutions;
    static Integer[] noCoins;
    static int count;

    static void solve(Integer[] coins, int solveFor) {
        for (Map.Entry m : solutions.entrySet()) { // check if we already have a solution
            if (m.getKey().equals(coins)) {
                // if above is true, we found a solution
            }
        }

        int sum = 0;
        for (int i = 0; i < coins.length; i++) {
            sum += coins[i];
        }
        if (sum == solveFor) {
            count++;
        } else {
            // TODO: figure out what new "coins" array to create
            
            solve(coins, solveFor);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("coin.dat"));

        solutions.put(noCoins, 0);

        // read in amount, read in coins we have.
        int n = in.nextInt();
        int m = in.nextInt();
        Integer[] coins = new Integer[m];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = in.nextInt();
        }
        // //
        solve(coins, n);
        System.out.println(count);
    }
}