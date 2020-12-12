/*
 ID: flangdr1
 LANG: JAVA
 TASK: frac1
 */

import java.io.*;
import java.util.*;

public class frac1 {

    static private int N;
    static private PrintWriter out;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        out.println("0/1");
        recfrac(0, 1, 1, 1);
        out.println("1/1");
        out.close();
    }

    private static void recfrac(int n1, int d1, int n2, int d2) {
        if (d1 + d2 > N) {
            return;
        }
        recfrac(n1, d1, n1 + n2, d1 + d2);
        out.println(String.format("%d/%d",n1 + n2, d1 + d2));
        recfrac(n1 + n2, d1 + d2, n2, d2);
    }
}