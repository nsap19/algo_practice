package SSAFY.IM_Prepare;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_2005_파스칼의삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            arr[0][0] = 1;
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) arr[i][j] = 1;
                    else {
                        arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                    }
                }
            }

            sb.append("#").append(testCase).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] != 0) sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
