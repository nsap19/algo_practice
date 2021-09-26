package SSAFY;

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Rupee implements Comparable<Rupee> {
    int r, c, val;

    public Rupee(int r, int c, int val) {
        this.r = r;
        this.c = c;
        this.val = val;
    }


    @Override
    public int compareTo(Rupee o) {
        return this.val - o.val;
    }
}

public class Main_백준_4485_녹색옷입은애가젤다지_이혜민_240ms {
    static int[][] arr, dist;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;


            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dist = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            minRupee();
            sb.append("Problem ").append(tc++).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }

        System.out.println(sb);
    }

    private static void minRupee() {
        PriorityQueue<Rupee> pq = new PriorityQueue<>();
        pq.add(new Rupee(0, 0, arr[0][0]));
        dist[0][0] = arr[0][0];

        while (pq.size() > 0) {
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if(dist[i][j]==Integer.MAX_VALUE) System.out.print("INF\t");
//                    else
//                    System.out.print(dist[i][j]+"\t");
//                }
//                System.out.println();
//            }
//            System.out.println();

            Rupee cur = pq.poll();
            int r = cur.r, c = cur.c;
            if (visited[r][c]) continue;
            visited[r][c] = true;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                dist[nr][nc] = Math.min(dist[nr][nc], dist[r][c] + arr[nr][nc]);
                pq.add(new Rupee(nr, nc, dist[nr][nc]));
            }
        }
    }
}
