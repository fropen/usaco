/*
ID: flangdr1
LANG: JAVA
PROG: ariprog
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ariprog {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));

        int N = Integer.parseInt(f.readLine());
        int M = Integer.parseInt(f.readLine());
        int max = M * M * 2;
        int[] bisquares = new int[max + 1];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= M; j++) {
                bisquares[i * i + j * j] = 1;
            }
        }
        ArrayList<int[]> results = new ArrayList<>();
        for (int a = 0; a < bisquares.length; a++) {
            if (bisquares[a] == 0) {
                continue;
            }
            loop: for (int b = 1; b <= (max - a)/(N - 1); b++) {
                for (int k = N - 1; k > 0; k--) {
                    if (bisquares[a + k * b] == 0) {
                        continue loop;
                    }
                }
                int[] tmp = new int[2];
                tmp[0] = a;
                tmp[1] = b;
                results.add(tmp);
            }
        }
        Collections.sort(results, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        if (results.size() == 0) {
            out.println("NONE");
        } else {
            for (int[] p : results) {
                out.println(p[0] + " " + p[1]);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000.0);
        out.close();
    }
}