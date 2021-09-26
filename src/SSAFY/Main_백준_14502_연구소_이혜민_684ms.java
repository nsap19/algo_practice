package SSAFY;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus {
    int r, c;

    public Virus(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main_백준_14502_연구소_이혜민_684ms {
    static int N, M, arr[][], max = 0, count=0;
    static Queue<Virus> queue;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        queue = new LinkedList<>(); //바이러스 위치 담기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) queue.add(new Virus(i, j));
            }
        }

        makeWall(0);
        System.out.println(max);
        System.out.println(count); //호출 횟수

    }

    private static void makeWall(int cnt) {
        count++;
        if (cnt == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    makeWall(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }


    private static void spreadVirus() {
        Queue<Virus> temp = new LinkedList<>();
        temp.addAll(queue);
        int[][] tempArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(arr[i], 0, tempArr[i], 0, M);
        }

        while (temp.size() > 0) {
            Virus virus = temp.poll();
            int vr = virus.r, vc = virus.c;

            for (int i = 0; i < 4; i++) {
                int nr = vr + dr[i];
                int nc = vc + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (tempArr[nr][nc] == 0) {
                    tempArr[nr][nc] = 2;
                    temp.add(new Virus(nr, nc));
                }
            }
        }

        countSafe(tempArr);
    }

    private static void countSafe(int[][] temp) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) count++;
            }
        }

        max = Math.max(max, count);
    }
}
