/*
 ID: flangdr1
 LANG: JAVA
 TASK: hamming
 */

import java.io.*;
import java.util.*;

public class hamming {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        LinkedList<Integer> ans = new LinkedList<>();
        ans.add(0);
        int max = (int)Math.pow(2, B);
        while (ans.size() < N) {
            int next = ans.getLast();
            out.print(next);
            if (ans.size() % 10 == 0) {
                out.println("");
            } else {
                out.print(" ");
            }
            for (int i = next + 1; i < max; i++) {
                boolean minDistD = true;
                for (int x : ans) {
                    if (dist(x, i, B) < D) {
                        minDistD = false;
                        break;
                    }
                }
                if (minDistD) {
                    ans.add(i);
                    break;
                }
            }
        }

        out.println(ans.getLast());

        out.close();
    }

    private static int dist(int x, int y, int B) {
        int dist = 0;
        for (int i = 0; i <B; i++) {
            int v = (1 << i);
            if ((x & v) != (y & v)) {
                dist++;
            }
        }
        return dist;
    }
}