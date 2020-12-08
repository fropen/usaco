/*
ID: your_id_here
LANG: JAVA
PROG: skidesign
*/
import java.io.*;
import java.util.*;

public class skidesign {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(new File("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));

        int N = scn.nextInt();
        int[] height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = scn.nextInt();
        }
        Arrays.sort(height);
        int min = height[0];
        int max = height[height.length - 1];
        int minCost = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int cost = 0;
            for (int x : height) {
                if (x < i) {
                    cost += (i - x) * (i - x);
                } else if (x > i + 17) {
                    cost += (x - i - 17) * (x - i - 17);
                }
            }
            minCost = Math.min(cost, minCost);
        }

        out.println(minCost);
        out.close();
    }
}
