/*
ID: flangdr1
LANG: JAVA
PROG: milk3
*/

import java.io.*;
import java.util.*;

class milk3 {
    static Set<Integer> result = new HashSet<>();
    static int[] cap = new int[3];
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(new File("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        cap[0] = scn.nextInt();
        cap[1] = scn.nextInt();
        cap[2] = scn.nextInt();
        HashSet<String> visited = new HashSet<>();
        dfs(0, 0, cap[2], visited);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.addAll(result);
        Collections.sort(ans);
        for (int x : ans) {
            out.print(x);
            if (x != ans.get(ans.size() - 1)) {
                out.print(" ");
            } else {
                out.println("");
            }
        }
        out.close();
    }

    private static void dfs(int a, int b, int c, HashSet<String> visited) {
        String key = a+","+b+","+c;
        if (visited.contains(key)) {
            return;
        } else {
            visited.add(key);
        }
        if (a == 0) {
            result.add(c);
        }
        // a ==> b
        if (a > 0 && b != cap[1]) {
            if (a + b <= cap[1]) {
                dfs(0, a + b, c, visited);
            } else {
                dfs(a - cap[1] + b, cap[1], c, visited);
            }
        }

        //b ==> a
        if (a < cap[0] && b > 0) {
            if (a + b <= cap[0]) {
                dfs(a + b, 0, c, visited);
            } else {
                dfs(cap[0], a + b - cap[0], c, visited);
            }
        }

        // a ==> c
        if (a > 0 && c < cap[2]) {
            if (a + c <= cap[2]) {
                dfs(0, b, a + c, visited);
            } else {
                dfs(a + c - cap[2], b, cap[2], visited);
            }
        }

        //c ==> a
        if (a < cap[0] && c > 0) {
            if (a + c <= cap[0]) {
                dfs(a + c, b, 0, visited);
            } else {
                dfs(cap[0], b, a + c - cap[0], visited);
            }
        }
        // b ==> c
        if (b > 0 && c < cap[2]) {
            if (c + b <= cap[2]) {
                dfs(a, 0, b + c, visited);
            } else {
                dfs(a, b + c - cap[2], cap[2], visited);
            }
        }

        //c ==> b
        if (b < cap[1] && c > 0) {
            if (c + b <= cap[1]) {
                dfs(a, b + c, 0, visited);
            } else {
                dfs(a, cap[1], b + c - cap[1], visited);
            }
        }
    }
}