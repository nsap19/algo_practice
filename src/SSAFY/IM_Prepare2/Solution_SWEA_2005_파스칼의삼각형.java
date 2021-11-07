package SSAFY.IM_Prepare2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_2005_파스칼의삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                arr[i][0] = 1;
                arr[i][i] = 1;
            }


            for (int i = 1; i < n; i++) {
                for (int j = 1; j < i; j++) {
                    if (arr[i][j] == 0) arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }

            sb.append("#").append(testCase).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
