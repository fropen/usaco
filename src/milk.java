/*
ID: flangdr1
LANG: JAVA
PROG: milk
*/

import java.io.*;
import java.util.*;

class milk {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        Scanner scn = new Scanner(new File("milk.in"));

        int N = scn.nextInt();
        int M = scn.nextInt();
        int[][] cand = new int[M][2];
        for (int i = 0; i < M; i++) {
            cand[i][0] = scn.nextInt();
            cand[i][1] = scn.nextInt();
        }
        Arrays.sort(cand, (a, b) -> a[0] - b[0]);
        int amount = 0;
        for (int[] p : cand) {
            if (N >= p[1]) {
                amount += p[0] * p[1];
                N -= p[1];
            } else {
                amount += p[0] * N;
                N = 0;
            }
        }
        out.println(amount);

        long end = System.currentTimeMillis();
        //System.out.println((end - start)/1000.0);
        out.close();
    }
}