/*
ID: flangdr1
LANG: JAVA
PROG: palsquare
*/

import java.io.*;

class palsquare {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int B = Integer.parseInt(f.readLine());

        for (int i = 1; i <= 300; i++) {
            String value = baseBValue(i * i, B);
            if (isPalindromic(value)) {
                out.println(baseBValue(i, B) + " " + value);
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