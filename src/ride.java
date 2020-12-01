/*
ID: your_id_here
LANG: JAVA
PROG: ride
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;


class ride {
    static List<String> arrangements = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        String src = f.readLine();
        String dst = f.readLine();

        int i = 1;
        int j = 1;

        for (char c : src.toCharArray()) {
            i *= c - 'A' + 1;
            i %= 47;
        }

        for (char c : dst.toCharArray()) {
            j *= c - 'A' + 1;
            j %= 47;
        }

        if (i == j) {
            out.println("GO");
        } else {
            out.println("STAY");
        }

        out.close();
    }
}