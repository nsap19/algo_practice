package SSAFY;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳_이혜민 {
    static String[][] arr;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new String[R + 2][C + 2];
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                arr[i][j] = String.valueOf(str.charAt(j - 1));
            }
        }

        getAlpha(1, 1, arr[1][1], 1);

        System.out.println(max);

    }

    private static void getAlpha(int r, int c, String str, int cnt) {

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (arr[nr][nc] != null) {
                if (!str.contains(arr[nr][nc])) {
                    getAlpha(nr, nc, str + arr[nr][nc], cnt + 1);
                } else {
                    max = Math.max(max, cnt);
                }
            }
        }
    }
}
