/*
ID: flangdr1
LANG: JAVA
PROG: barn1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class barn1 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        Scanner scn = new Scanner(new File("barn1.in"));

        int M = scn.nextInt();
        int S = scn.nextInt();
        int C = scn.nextInt();

        int[] stall = new int[C];
        for (int i = 0; i < C; i++) {
            stall[i] = scn.nextInt();
            //System.out.println(stall[i]);
        }
        Arrays.sort(stall);
        int amount = 0;
        ArrayList<Integer> gap = new ArrayList<>();
        for (int i = 1; i < stall.length; i++) {
            int x = stall[i] - stall[i - 1] - 1;
            if (x > 0) {
                gap.add(x);
            }
        }
        Collections.sort(gap);
        int count = 0;
        for (int i = 1; i < M && gap.size() > 0; i++) {
            count += gap.remove(gap.size() - 1);
        }
        out.println(stall[C - 1] - stall[0] + 1 - count);

        long end = System.currentTimeMillis();
        //System.out.println((end - start)/1000.0);
        out.close();
    }
}