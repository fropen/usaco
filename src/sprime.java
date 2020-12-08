/*
ID: flangdr1
LANG: JAVA
PROG: sprime
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class sprime {
    static List<Integer> ans = new ArrayList<>();
    static int[] edge = new int[2];
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));

        int N = scanner.nextInt();
        int[] edge = {2, 3, 5, 7};
        int[] num = new int[N];
        genPalindrom(num, 0, 1);

        for (int x : ans) {
            out.println(x);
        }
        out.close();
    }

    private static boolean isPrime(int x) {
        if (x == 1) return false;
        for (int i = 2; i <= (int) Math.pow(x, 0.5); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void genPalindrom(int[] num, int i, int x) {
        //System.out.println(i + "," + j);
        if (i >= num.length) {
            ans.add(x);
            return;
        }
        for (int j = 1; j <= 9; j++) {
            num[i] = j;
            x = 0;
            for (int k = 0; k <= i; k++) {
                x *= 10;
                x += num[k];
            }
            if (isPrime(x)) {
                genPalindrom(num, i + 1, x);
            }
        }
    }
}