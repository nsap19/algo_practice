package SSAFY.IM_Prepare2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_11315_오목판정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            boolean flag = false;

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
            int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

            loop:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 'o') {
                        for (int k = 0; k < 8; k++) {
                            int cnt = 1;
                            int nr, nc;
                            for (int l = 1; l < 5; l++) {
                                nr = i + dr[k] * l;
                                nc = j + dc[k] * l;

                                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                    if (arr[nr][nc] == 'o') cnt++;
                                }
                            }
                            if (cnt == 5) {
                                flag = true;
                                break loop;
                            }
                        }
                    }
                }
            }

            sb.append("#").append(testCase).append(" ");
            if (flag) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
