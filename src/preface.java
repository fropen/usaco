/*
 ID: flangdr1
 LANG: JAVA
 TASK: preface
 */

import java.io.*;

public class preface {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("preface.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        int N = Integer.parseInt(f.readLine());
        char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        int[] ans = new int[7];
        for (int x = 1; x <= N; x++) {
            add(ans, x);
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > 0) {
                out.println(roman[i] + " " + ans[i]);
            }
        }
        out.close();
    }
    //I, X, L,
    private static void add(int[] ans, int number) {
        int shift = 0;
        //System.out.print(number + "\t");
        while (number > 0) {
            int r = number % 10;
            switch (r) {
                case 3:
                case 8:
                    ans[shift]++;
                case 2:
                case 7:
                    ans[shift]++;
                case 1: case 4: case 6:
                    ans[shift]++;
                case 5:
                    if (r >= 4) {
                        ans[shift + 1]++;
                    }
                    break;
                case 9:
                    ans[shift]++;
                //case 0:
                    ans[shift + 2]++;
                    break;
            }
            shift += 2;
            number /= 10;
        }
//        for (int x : ans) {
//            System.out.print(x + "\t");
//        }
//        System.out.println();
    }
}