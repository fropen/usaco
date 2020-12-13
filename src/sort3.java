/*
 ID: flangdr1
 LANG: JAVA
 TASK: sort3
 */

import java.io.*;
import java.util.StringTokenizer;

public class sort3 {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int[] count = new int[4];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(f.readLine());
            if (nums[i] == 1) {
                count[1]++;
            } else if (nums[i] == 2) {
                count[2]++;
            } else {
                count[3]++;
            }
        }
        int c2in1 = 0;
        int c3in1 = 0;
        for (int i = 0; i < count[1]; i++) {
            if (nums[i] == 2) {
                c2in1++;
            } else if (nums[i] == 3) {
                c3in1++;
            }
        }

        int c1in2 = 0, c3in2 = 0;
        for (int i = count[1]; i < count[1] + count[2]; i++) {
            if (nums[i] == 1) {
                c1in2++;
            } else if (nums[i] == 3) {
                c3in2++;
            }
        }
        int c1in3 = 0, c2in3 = 0;
        for (int i = count[1] + count[2]; i < N; i++) {
            if (nums[i] == 1) {
                c1in3++;
            } else if (nums[i] == 2){
                c2in3++;
            }
        }
        int ans = Math.min(c1in2, c2in1) + Math.min(c1in3, c3in1) + Math.min(c2in3, c3in2);
        int r = Math.abs(c2in1 - c1in2);
        out.println(ans + 2 * r);
        out.close();
    }
}