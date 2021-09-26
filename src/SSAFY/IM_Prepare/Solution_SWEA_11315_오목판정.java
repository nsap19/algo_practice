package SSAFY.IM_Prepare;

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

            char[][] omok = new char[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    omok[i][j] = str.charAt(j);
                }
            }

            int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
            int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

            boolean flag = false;
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (omok[i][j] == 'o') {
                        for (int k = 0; k < 8; k++) {
                            count = 1;
                            for (int l = 1; l < 5; l++) {
                                int nr = i + dr[k] * l;
                                int nc = j + dc[k] * l;

                                if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
                                else if (omok[nr][nc] != 'o') break;
                                count++;
//                                System.out.println(nr + " " + nc + " " + count);
                            }
                            if (count == 5) {
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }

            sb.append("#").append(testCase).append(" ");
            if (flag) sb.append("YES\n");
            else sb.append("NO\n");

//            System.out.println();
        }
        System.out.println(sb);
    }
}
