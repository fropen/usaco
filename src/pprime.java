/*
ID: flangdr1
LANG: JAVA
PROG: pprime
*/

import java.io.*;
import java.util.*;

class pprime {
    static List<Integer> ans = new ArrayList<>();
    static int[] edge = new int[2];
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));

        edge[0] = scanner.nextInt();
        edge[1] = scanner.nextInt();

        for (int len = ("" + edge[0]).length(); len <= ("" + edge[1]).length(); len++) {
            int[] num = new int[len];
            genPalindrom(num, 0, len - 1);
        }
        for (int x : ans) {
            out.println(x);
        }
        out.close();
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i <= (int) Math.pow(x, 0.5); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void genPalindrom(int[] num, int i, int j) {
        //System.out.println(i + "," + j);
        if (i > j) {
            int x = 0;
            for (int d : num) {
                x *= 10;
                x += d;
            }
            if (x >= edge[0] && x <= edge[1] && isPrime(x)) {
                ans.add(x);
            }
            return;
        }
        if (j + 1 != num.length) {
            for (int k = 0; k <= 9; k++) {
                num[i] = num[j] = k;
                genPalindrom(num, i + 1, j - 1);
            }
        } else {
            for (int k = 1; k <= 9; k += 2) {
                int x = 1;
                for(int l = 1; l < num.length; l++) {
                    x *= 10;
                }
                //System.out.println(x);
                if (k * x > edge[1]) {
                    break;
                }
                num[i] = num[j] = k;
                genPalindrom(num, i + 1, j - 1);
            }
        }
    }
}