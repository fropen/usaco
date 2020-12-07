/*
ID: flangdr1
LANG: JAVA
PROG: namenum
*/

import java.io.*;
import java.util.*;

class namenum {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        BufferedReader f2 = new BufferedReader(new FileReader("dict.txt"));
        String strNum = f.readLine();
        char[] nums = strNum.toCharArray();
        int[] letters = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 0, 7, 7, 8, 8, 8, 9, 9, 9, 0};
        ArrayList<String> results = new ArrayList<>();
        String line = "";
        while ((line = f2.readLine()) != null) {
            if (line.length() != strNum.length()) {
                continue;
            }
            boolean found = true;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                //System.out.println("char = " + c);
                if (letters[c - 'A'] != nums[i] - '0') {
                    found = false;
                    break;
                }
            }
            if (found) {
                results.add(line);
            }
        }

        for (String s : results) {
            out.println(s);
        }
        if (results.size() == 0) {
            out.println("NONE");
        }
        long end = System.currentTimeMillis();
        //System.out.println((end - start)/1000.0);
        out.close();
    }
}