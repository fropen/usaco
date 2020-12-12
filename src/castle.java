/*
 ID: flangdr1
 LANG: JAVA
 TASK: castle
 */

import java.util.*;
import java.io.*;

public class castle {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] walls = new int[N][M];

        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < M; j++) {
                walls[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> q = new LinkedList<>();
        HashMap<String, Integer> pointInRoom = new HashMap<>();
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        int rooms = 0;
        int maxSize = 0;
        int[] dir = {1, 2, 4, 8};
        int[] delX = {0, -1, 0, 1};
        int[] delY = {-1, 0, 1, 0};
        for(int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c]) {
                    visited[r][c] = true;
                    q.offer(new int[] {r, c});
                    rooms++;
                    map.put(rooms, new ArrayList<>());
                } else {
                    continue;
                }
                int size = 0;
                while (!q.isEmpty()) {
                    int[] temp = q.poll();
                    map.get(rooms).add(temp);
                    pointInRoom.put(temp[0] + "," + temp[1], rooms);
                    size++;
                    int x = temp[0];
                    int y = temp[1];
                    int l = walls[temp[0]][temp[1]];
                    //dir is not wall
                    for (int i = 0; i < 4; i++) {
                        if ((l & dir[i]) == 0) {
                            int nx = x + delX[i];
                            int ny = y + delY[i];
                            if (!visited[nx][ny]) {
                                q.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
                maxSize = Math.max(maxSize, size);
            }
        }
        int total = 0;
        String remove = "";
        for (int j = 0; j < M; j++) {
            for (int i = N - 1; i >= 0; i--) {
                //System.out.println(i + "," + j);
                if ((walls[i][j] & 2) == 2 && i!= 0 && pointInRoom.get(i + "," + j) != pointInRoom.get((i - 1) + "," + j)) {
                    int a = map.get(pointInRoom.get(i + "," + j)).size();
                    int b = map.get(pointInRoom.get((i - 1) + "," + j)).size();
                    if (a + b > total) {
                        total = a + b;
                        remove = (i+1) + " " + (j+1) + " N";
                    }
                }
                if ((walls[i][j] & 4) == 4 && j != M - 1 && pointInRoom.get(i + "," + j) != pointInRoom.get(i + "," + (j + 1))) {
                    int a = map.get(pointInRoom.get(i + "," + j)).size();
                    int b = map.get(pointInRoom.get(i + "," + (j + 1))).size();
                    if (a + b > total) {
                        total = a + b;
                        remove = (i+1) + " " + (j+1) + " E";
                    }
                }
            }
        }

        out.println(rooms);
        out.println(maxSize);
        out.println(total);
        out.println(remove);
        out.close();
    }
}