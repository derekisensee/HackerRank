import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class CoinChange {
    static HashMap<Integer[], Integer> solutions;
    static Integer[] noCoins;
    static int count;

    static void solve(Integer[] coins, int solveFor) {
        // for (Map.Entry m : solutions.entrySet()) { // check if we already have a solution
        //     if (m.getKey().equals(coins)) {
        //         // if above is true, we found a solution
        //     }
        // }

        int sum = 0;
        for (int i = 0; i < coins.length; i++) {
            sum += coins[i];
        }
	solutions.put(coins, sum);
        if (sum == solveFor) {
            count++;
        } else {
            for (int i = 0; i < coins.length; i++) { // find repeating sum of a coin
		int aMod = solveFor % coins[i];
		if (aMod == 0) {
		    count++;
		    Integer[] newCoins = new Integer[solveFor / coins[i]];
		    for (int a = 0; a < solveFor / coins[i]; a++) {
			newCoins[a] = coins[i];
		    }
		    solutions.put(newCoins, solveFor);
		}
		System.out.println("Finding: " + solveFor + " % " + coins[i] + " = " + (solveFor % coins[i]));
	    }
            // TODO: figure out what new "coins" array to create
            for (int a = 0; a < coins.length; a++) {
		for (int b = 0; b < coins.length; b++) {
		    
		}
	    }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("coin.dat"));

	solutions = new HashMap<>();
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
	    for (int i = 0; i < key.length; i++) {
		System.out.print(key[i] + " " );
	    }
	    System.out.println(val);
	}
	
    }
}
