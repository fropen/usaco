/*
ID: flangdr1
LANG: JAVA
PROG: gift1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;


class gift1 {
    static List<String> arrangements = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        int N = Integer.parseInt(f.readLine());
        ArrayList<String> names = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            names.add(f.readLine());
            map.put(names.get(i), 0);
        }
        String name = "";
        while ((name = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int amount = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            //System.out.println(amount + " " + count);
            for (int i = 0; i < count; i++) {
                String to = f.readLine();
                map.put(to, map.get(to) + amount / count);
                map.put(name, map.get(name) - amount / count);
                //System.out.println(to + " " + map.get(to));
            }
        }

        for (String n : names) {
            out.println(n + " " + map.get(n));
        }

        out.close();
    }
}