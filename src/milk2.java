/*
ID: flangdr1
LANG: JAVA
PROG: milk2
*/

import java.io.*;
import java.util.*;

class milk2 {
    static List<String> arrangements = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        int N = Integer.parseInt(f.readLine());
        List<int[]> milk = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] entry = new int[2];
            entry[0] = Integer.parseInt(st.nextToken());
            entry[1] = Integer.parseInt(st.nextToken());
            milk.add(entry);
        }
        Collections.sort(milk, (a, b) -> a[0] - b[0]);
        int start = milk.get(0)[0], end = milk.get(0)[1];
        int maxDur = end - start;
        int maxGap = 0;
        for (int[] p : milk.subList(1, milk.size())) {
            if (p[0] > end) {
                maxGap = Math.max(maxGap, p[0] - end);
                start = p[0];
                end = p[1];
            } else {
                end = Math.max(end, p[1]);
            }
            maxDur = Math.max(maxDur, end - start);
        }

        out.println(maxDur + " " + maxGap);
        out.close();
    }
}