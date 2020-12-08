/*
ID: flangdr1
LANG: JAVA
PROG: combo
*/

import java.io.*;
import java.util.*;

class combo {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        Scanner scn = new Scanner(new File("combo.in"));

        int N = scn.nextInt();
        HashSet<Integer>[] sets = new HashSet[6];
        int[] comb = new int[6];
        for (int i = 0; i < 6; i++) {
            comb[i] = scn.nextInt();
            sets[i] = new HashSet<>();
            for (int j = -2; j <= 2; j++) {
                sets[i].add((comb[i]+j+N)%N);
            }
        }
        int[] count = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int x : sets[i]) {
                if (sets[i+3].contains(x)) {
                    count[i]++;
                }
            }
        }
        int a = 1, b = 1, c = 1;
        for (int i = 0; i < 3; i++) {
            a *= sets[i].size();
            b *= sets[i+3].size();
            c *= count[i];
        }
        out.println(a + b -c);

        long end = System.currentTimeMillis();
        //System.out.println((end - start)/1000.0);
        out.close();
    }
}