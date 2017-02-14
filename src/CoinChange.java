import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class CoinChange {
    static ConcurrentHashMap<Integer[], Integer> solutions;
    static HashMap<Integer[], Integer> tempSolutions;
    static Integer[] noCoins;
    static int count;

    static void solve(Integer[] coins, int solveFor) {
//        for (Map.Entry<Integer[], Integer> entry : tempSolutions.entrySet()) {
//            Integer[] key = entry.getKey();
//            Integer value = entry.getValue();
//            solutions.put(key, value);
//            System.out.println("Stuck?");
//        }
        for (Map.Entry<Integer[], Integer> entry : solutions.entrySet()) {
            Integer[] key = entry.getKey();
            //Integer value = entry.getValue();

            if (!(Arrays.equals(key, coins))) {
                int sum = 0;
                for (int b = 0; b < coins.length; b++) {
                    sum += coins[b];
                }
                solutions.put(coins, sum);
                if (sum == solveFor) {
                    count++;
                } else {
                    for (int i = 0; i < coins.length; i++) { // find repeating sum of a coin
                        int aMod = solveFor % coins[i];
                        if (aMod == 0) {
                            System.out.println("Mod Tripped");
                            count++;
                            Integer[] newCoins = new Integer[solveFor / coins[i]];
                            for (int a = 0; a < solveFor / coins[i]; a++) {
                                newCoins[a] = coins[i];
                            }
                            solutions.put(newCoins, solveFor);
                        }
                        //System.out.println("Finding: " + solveFor + " % " + coins[i] + " = " + (solveFor % coins[i]));
                    }
                    // TODO: figure out what new "coins" array to create
                    if (!(coins.length == 0)) {
                        System.out.println("Tripped");
                        Integer[] newCoins = new Integer[coins.length - 1];
                        for (int a = 0; a < coins.length - 1; a++) {
                            newCoins[a] = coins[a];
                        }
                        solve(newCoins, solveFor);
                    }
                }
            }
        }
//        for (Map.Entry<Integer[], Integer> entry : tempSolutions.entrySet()) {
//            Integer[] key = entry.getKey();
//            Integer value = entry.getValue();
//            solutions.put(key, value);
//        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("coin.dat"));

        solutions = new ConcurrentHashMap<>();
        tempSolutions = new HashMap<>();
        noCoins = new Integer[1];
        noCoins[0] = 0;
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
        // System.out.println(count);
	    // solutions.forEach((k,v) -> for (Integer s : k) {System.out.println("key: " + s + " value: " + v)});
        for (Map.Entry<Integer[], Integer> e : solutions.entrySet()) { // messy and gross
            Integer[] key = e.getKey();
            Integer val = e.getValue();
            System.out.print("Array: ");
            for (int i = 0; i < key.length; i++) {
                System.out.print(key[i] + " " );
            }
            System.out.println("Sum: " + val);
        }


	
    }
}