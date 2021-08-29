package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_이혜민_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); //테스트케이스

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());//재료의 수
            int L = Integer.parseInt(st.nextToken());//제한 칼로리

            int[] taste = new int[N + 1]; //맛 점수
            int[] cal = new int[N + 1]; //칼로리
            int[][] dp = new int[N + 1][L + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                taste[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) { //재료 순회
                for (int j = 1; j <= L; j++) { //구해야하는 최대칼로리 순회
                    dp[i][j] = dp[i - 1][j]; //해당 재료를 선택하기 이전의 값
                    if (j - cal[i] >= 0) { //해당 재료를 선택했을 때 현재 구해야하는 최대칼로리보다 작은지 확인
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cal[i]] + taste[i]);
                        //i번 재료를 선택하지 않았을 때 vs i번 재료를 선택했을 때
                    }
                }
            }

            int max = 0;
            for (int i = 1; i <= N; i++) {
                if (dp[i][L] > max) max = dp[i][L];
            }
            sb.append("#").append(testCase).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
}
