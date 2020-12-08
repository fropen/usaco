/*
ID: your_id_here
LANG: JAVA
PROG: wormhole
*/
import java.io.*;
import java.util.StringTokenizer;

public class wormhole {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] X = new int[n + 1];
        int[] Y = new int[n + 1];
        int[] pairs = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(f.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        int[] next_step = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (Y[j] == Y[i] && X[j] > X[i] && (X[j] < X[next_step[i]] || next_step[i] == 0)) {
                    next_step[i] = j;
                    //System.out.println(i + "->" + j);
                }
            }
        }

        // composite a solution
        int count = findSolution(pairs, n, next_step);
        //System.out.println("count = " + count);
        out.println(count);
        out.close();
    }

    private static int findSolution(int[] pairs, int n, int[] next_step) {

        int count = 0;
        int i = 0;
        for (i = 1; i <= n; i++) {
            if (pairs[i] == 0) {
                break;
            }
        }

        if (i > n) {
            if (hasLoop(pairs, n, next_step)) {
                return 1;
            } else {
                return 0;
            }
        }

        for (int j = i + 1; j <= n; j++) {
            if (pairs[j] == 0) {
                pairs[i] = j;
                pairs[j] = i;
                count += findSolution(pairs, n, next_step);
                pairs[i] = 0;
                pairs[j] = 0;
            }
        }

        return count;
    }

    private static boolean hasLoop(int[] pairs, int n, int[] next_step) {
        for (int idx = 1; idx <= n; idx++) {
            int start = idx;
            for (int i = 1; i <= n; i++) {
                //System.out.print(start + "->");
                int p = pairs[start];
                //System.out.print(p + "->");
                start = next_step[p];
            }
            //System.out.println("");
            if (start != 0) {
                //System.out.println(true);
                return true;
            }
        }
        //System.out.println(false);
        return false;
    }
}
