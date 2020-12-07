/*
ID: flangdr1
LANG: JAVA
PROG: dualpal
*/

import java.io.*;
import java.util.*;

class dualpal {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        while (N > 0) {
            S++;
            int palCount = 0;
            for (int base = 2; base <= 10; base++) {
                if (isPalindromic(baseBValue(S, base))) {
                    palCount++;
                }
                if (palCount == 2) {
                    break;
                }
            }
            if (palCount == 2) {
                N--;
                out.println(S);
            }
        }

        long end = System.currentTimeMillis();
        //System.out.println((end - start)/1000.0);
        out.close();
    }

    private static boolean isPalindromic(String value) {
        int i = 0, j = value.length() - 1;
        while (i < j) {
            if (value.charAt(i) != value.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static String baseBValue(int i, int b) {
        String value = "";
        while (i != 0) {
            int r = i % b;
            i /= b;
            if (r >= 10) {
                value = (char)((r - 10) + 'A') + value;
            } else {
                value = r + value;
            }
        }
        return value;
    }
}