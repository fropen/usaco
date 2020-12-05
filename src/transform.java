/*
ID: flangdr1
LANG: JAVA
PROG: transform
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class transform {
    static List<String> arrangements = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        int N = Integer.parseInt(f.readLine());
        char[][] srcMatrix = new char[N][N];
        String[] dstStr = new String[N];
        for (int i = 0; i < N; i++) {
            String tmp = f.readLine();
            srcMatrix[i] = tmp.toCharArray();
        }
        for (int i = 0; i < N; i++) {
            dstStr[i] = f.readLine();
        }

        for (int i = 1; i <= 3; i++) {
            srcMatrix = rotateClockWise(srcMatrix, N);
            if (equals(srcMatrix, dstStr)) {
                out.println(i);
                out.close();
                return;
            }
        }
        srcMatrix = reflectHorizontally(rotateClockWise(srcMatrix, N), N);
        if (equals(srcMatrix, dstStr)) {
            out.println(4);
            out.close();
            return;
        }
        for (int i = 1; i <= 3; i++) {
            srcMatrix = rotateClockWise(srcMatrix, N);
            if (equals(srcMatrix, dstStr)) {
                out.println(5);
                out.close();
                return;
            }
        }
        if (equals(reflectHorizontally(rotateClockWise(srcMatrix, N), N), dstStr)) {
            out.println(6);
            out.close();
            return;
        }
        out.println(7);
        out.close();
    }

    private static char[][] reflectHorizontally(char[][] src, int N) {
        for (int i = 0; i < N; i++) {
            int s = 0, e = N - 1;
            while (s < e) {
                char tmp = src[i][e];
                src[i][e] = src[i][s];
                src[i][s] = tmp;
                s++;
                e--;
            }
        }
        return src;
    }

    private static boolean equals(char[][] srcMatrix, String[] dstStr) {
        for (int i = 0; i < dstStr.length; i++) {
            //System.out.print(dstStr[i] + ":" + i + ":");
            //System.out.println(new String(srcMatrix[i]));
            if (!dstStr[i].equals(new String(srcMatrix[i]))) {
                return false;
            }
        }
        return true;
    }

    private static char[][] rotateClockWise(char[][] srcMatrix, int N) {
        char[][] result = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[j][N-i-1] = srcMatrix[i][j];
            }
        }

        return result;
    }
}