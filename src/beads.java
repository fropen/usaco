/*
ID: flangdr1
LANG: JAVA
PROG: beads
*/

import java.io.*;
import java.util.*;

class beads {
    static List<String> arrangements = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int N = Integer.parseInt(f.readLine());
        String beads = f.readLine();
        beads += beads;
        int l = 0, m, r;
        int count = 0;
        while (l < beads.length()) {
            while (l < beads.length() && beads.charAt(l) == 'w') {
                l++;
            }
            m = l;
            while (m < beads.length()) {
                if (beads.charAt(m) == 'w' || beads.charAt(m) == beads.charAt(l)) {
                    m++;
                } else {
                    break;
                }
            }
            r = m;
            while (r < beads.length()) {
                if (beads.charAt(r) == 'w' || beads.charAt(r) == beads.charAt(m)) {
                    r++;
                } else {
                    break;
                }
            }
            l--;
            while (l >= 0) {
                if (beads.charAt(l) == 'w') {
                    l--;
                } else {
                    break;
                }
            }
            count = Math.max(count, r - l - 1);
            l = m;
            //System.out.println(l);
        }
        count = Math.min(count, beads.length() / 2);
        out.println(count);
        out.close();
    }
}