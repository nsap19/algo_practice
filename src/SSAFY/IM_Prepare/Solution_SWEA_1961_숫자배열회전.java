package SSAFY.IM_Prepare;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1961_숫자배열회전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int[][] arr1 = new int[N][N];
            int[][] arr2 = new int[N][N];
            int[][] arr3 = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //90도 회전
            int r = 0, c = 0;
            for (int i = 0; i < N; i++, r++) {
                c = 0;
                for (int j = N - 1; j >= 0; j--, c++) {
                    arr1[r][c] = arr[j][i];
                }
            }

            //180도 회전
            r = 0;
            c = 0;
            for (int i = N - 1; i >= 0; i--, r++) {
                c = 0;
                for (int j = N - 1; j >= 0; j--, c++) {
                    arr2[r][c] = arr[i][j];
                }
            }

            //270도 회전
            r = 0;
            c = 0;
            for (int i = N - 1; i >= 0; i--, r++) {
                c = 0;
                for (int j = 0; j < N; j++, c++) {
                    arr3[r][c] = arr[j][i];
                }
            }


            sb.append("#").append(testCase).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arr1[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < N; j++) {
                    sb.append(arr2[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < N; j++) {
                    sb.append(arr3[i][j]);
                }
                sb.append("\n");
            }


        }
        System.out.println(sb);
    }
}
