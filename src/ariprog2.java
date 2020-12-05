/*
ID: flangdr1
LANG: JAVA
PROG: ariprog
*/

import java.io.*;
import java.util.*;

class ariprog2 {
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
        int count = 0;
        for (int b = 1; b <= max/(N - 1); b++) {
            for (int a : setpq) {
                boolean found = true;
                for (int j = N - 1; j > 0; j--) {
                    if (!setpq.contains(a + b * j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    count++;
                    out.println(a + " " + b);
                }
            }
        }

        if (count == 0) {
            out.println("NONE");
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000.0);
        out.close();
    }
}