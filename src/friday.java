/*
ID: flangdr1
LANG: JAVA
PROG: friday
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;


class friday {
    static List<String> arrangements = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        int N = Integer.parseInt(f.readLine());
        int[] days = new int[7];
        int dayOfWeek = 2;
        for (int i = 0; i < N; i++) {
            int year = 1900 + i;
            int febDays = daysOfFeb(year);
            int add = 30;
            for (int j = 1; j <= 12; j++) {
                days[(dayOfWeek + 12) % 7]++;
                switch (j) {
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        add = 30;
                        break;
                    case 2:
                        add = febDays;
                        break;
                    default:
                        add = 31;
                }
                dayOfWeek = (dayOfWeek + add) % 7;
            }

        }
        for (int i = 0; i < 6; i++) {
            out.print(days[i] + " ");
        }
        out.println(days[6]);
        out.close();
    }

    private static int daysOfFeb(int n) {
        if (n % 4 == 0) {
            if (n % 100 == 0 && n % 400 != 0) {
                return 28;
            }
            return 29;
        }
        return 28;
    }
}