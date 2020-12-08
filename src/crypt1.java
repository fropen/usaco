/*
ID: flangdr1
LANG: JAVA
PROG: crypt1
*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class crypt1 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        Scanner scn = new Scanner(new File("crypt1.in"));

        int N = scn.nextInt();

        int[] digit = new int[N];
        for (int i = 0; i < N; i++) {
            digit[i] = scn.nextInt();
        }
        Arrays.sort(digit);
        int count = 0;
        for (int i = 0; i < digit.length; i++) {
            for (int j = 0; j < digit.length; j++) {
                for (int k = 0; k < digit.length; k++) {
                    int x = digit[i] * 100 + 10 * digit[j] + digit[k];
                    for (int m = 0; m < digit.length; m++) {
                        if (x * digit[m] > 999) {
                            break;
                        }
                        if (!allDigitInSet(digit, x * digit[m])) {
                            continue;
                        }
                        for (int l = 0; l < digit.length; l++) {
                            if (x * digit[l] > 999) {
                                break;
                            }
                            if (!allDigitInSet(digit, x * digit[l])) {
                                continue;
                            }
                            if (allDigitInSet(digit,x * digit[l] * 10 + x * digit[m])) {
                                //System.out.println(x * digit[l] * 10 + x * digit[m]);
                                count++;
                            }
                        }
                    }

                }
            }
        }

        out.println(count);

        long end = System.currentTimeMillis();
        //System.out.println((end - start)/1000.0);
        out.close();
    }

    private static boolean allDigitInSet(int[] digit, int num) {
        while (num > 0) {
            int r = num % 10;
            boolean found = false;
            for (int i = 0; i < digit.length; i++) {
                if (digit[i] == r) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}