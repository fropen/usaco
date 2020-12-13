/*
 ID: flangdr1
 LANG: JAVA
 TASK: holstein
 */

import java.io.*;
import java.util.*;

public class holstein {

    static int max = Integer.MAX_VALUE;
    static ArrayList<String> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));

        int V = Integer.parseInt(f.readLine());
        int[] req = new int[V];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < V; i++) {
            req[i] = Integer.parseInt(st.nextToken());
        }
        int G = Integer.parseInt(f.readLine());
        int[][] feeds = new int[G][V];
        for (int i = 0; i < G; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < V; j++) {
                feeds[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(req, feeds, 0, new ArrayList<String>());

        out.println(ans.size() + " " + String.join(" ", ans));
        out.close();
    }

    private static void dfs(int[] req, int[][] feeds, int idx, ArrayList<String> path) {
        boolean found = true;
        for (int x : req) {
            if (x > 0) {
                found = false;
                break;
            }
        }
        if (found) {
            if (path.size() < max) {
                max = path.size();
                ans = new ArrayList<>(path);
            }
            return;
        }

        if (path.size() + 1 == max) {
            return;
        }
        for (int start = idx; start < feeds.length; start++) {
            for (int i = 0; i < req.length; i++) {
                req[i] -= feeds[start][i];
            }
            path.add((start + 1) + "");
            dfs(req, feeds, start + 1, path);
            path.remove(path.size() - 1);
            for (int i = 0; i < req.length; i++) {
                req[i] += feeds[start][i];
            }
        }
    }
}