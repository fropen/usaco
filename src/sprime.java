/*
 ID:
 LANG: JAVA
 TASK: sprime
 */
import java.util.*;
import java.io.*;
public class sprime {
    static List<Integer> valid = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        findValidSolutions(n, 1, 2);
        findValidSolutions(n, 1, 3);
        findValidSolutions(n, 1, 5);
        findValidSolutions(n, 1, 7);
        Collections.sort(valid);
        for(int i: valid) {
            out.println(i);
        }
        out.close();
    }
    static void findValidSolutions(int n, int idx, int path) {
        if(idx==n) {
            valid.add(path);
            return;
        }

        for(int i = 1; i <= 9; i = i + 2) {
            String s = "" + path + i;
            if(isPrime(Integer.parseInt(s))) {
                //System.out.println(s);
                findValidSolutions(n, idx+1, Integer.parseInt(s));
            }
        }
    }
    static boolean isPrime(int i) {
        if(i==1) {
            return false;
        }
        int f = (int)Math.sqrt(i);
        for(int q = 2; q <= f; q++) {
            if(i%q==0) {
                return false;
            }
        }
        return true;
    }
}