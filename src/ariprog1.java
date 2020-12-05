/*
ID: flangdr1
LANG: JAVA
PROG: ariprog
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class ariprog1 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));

        int N = Integer.parseInt(f.readLine());
        int M = Integer.parseInt(f.readLine());
        int max = M * M * 2;
        HashSet<Integer> setp = new HashSet<>();
        for (int i = 0; i <= M; i++) {
            setp.add(i * i);
        }
        HashSet<Integer> setpq = new HashSet<>();
        for (int x : setp) {
            for (int y : setp) {
                setpq.add(x + y);
            }
        }
        //System.out.println(setpq.size());
        ArrayList<int[]> results = new ArrayList<>();

        for (int a : setpq) {
            for (int b = 1; b <= (max - a)/(N - 1); b++) {
                boolean found = true;
                for (int j = N - 1; j > 0; j--) {
                    if (!setpq.contains(a + b * j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    int[] tmp = new int[2];
                    tmp[0] = a;
                    tmp[1] = b;
                    results.add(tmp);
                }
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