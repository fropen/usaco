/*
ID: flangdr1
LANG: JAVA
PROG: numtri
*/

import java.io.*;
import java.util.*;

class numtri {
    static Set<Integer> result = new HashSet<>();
    static int[] cap = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        Scanner scn = new Scanner(new File("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] tri = new int[N][N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String line = f.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
                if (i > 0) {
                    if (j == 0) {
                        tri[i][j] += tri[i-1][j];
                    } else {
                        tri[i][j] += Math.max(tri[i-1][j-1], tri[i-1][j]);
                    }
                }
                ans = Math.max(ans, tri[i][j]);
            }
        }
        out.println(ans);
        out.close();
    }
}