import java.io.*;
import java.util.*;

public class javaList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<>();
        int sets = in.nextInt();
        for (int i = 0; i < sets; i++) {
            a.add(in.nextInt());
        }
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            String word = in.nextLine();
            if (word.equals("Insert")) {
                String[] data = in.nextLine().split(" ");
                int x = Integer.parseInt(data[0]);
                int y = Integer.parseInt(data[1]);
                a.add(x, y);
            }
            else if (word.equals("Delete")) {
                int r = Integer.parseInt(in.nextLine());
                a.remove(r);
            }
            in.nextLine();
        }
        for (int i = 0; i < a.size(); i++)
            System.out.print(a.get(i) + " ");
    }
}