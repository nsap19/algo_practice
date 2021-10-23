package SSAFY;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1121_행운의로또번호_이혜민 {
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            dp = new long[N + 1][M + 1]; //n번째 자리에 m이하의 수가 올수있는 경우의 수

            for (int i = 0; i <= N; i++) Arrays.fill(dp[i], -1);

            for (int i = 1; i <= M; i++) dp[1][i] = i;

            for (int i = 2; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    dp[i][j] = find(i, j);
                }
            }

            sb.append(dp[N][M]).append("\n");
        }
        System.out.println(sb);
    }

    private static long find(int n, int m) {
        if (m <= 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];

        long val = 0;
        val += find(n - 1, m / 2);
        val += find(n, m - 1);
        return val;
    }


}

