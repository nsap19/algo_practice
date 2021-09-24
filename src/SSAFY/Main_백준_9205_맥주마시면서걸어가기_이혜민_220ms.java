package SSAFY;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_백준_9205_맥주마시면서걸어가기_이혜민_220ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); //테스트케이스
        for (int test = 0; test < t; test++) {

            int n = Integer.parseInt(br.readLine()); //편의점 갯수
            int[][] arr = new int[n + 2][2];

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

//            System.out.println(Arrays.deepToString(arr));
            boolean[][] dp = new boolean[n + 2][n + 2];


            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    int len = getLen(arr[i], arr[j]);
//                    System.out.println(len);
                    if (len <= 1000)
                        dp[i][j] = true;
                }
            }

            //플로이드 와샬
            for (int k = 0; k < n + 2; k++) {
                for (int i = 0; i < n + 2; i++) {
                    for (int j = 0; j < n + 2; j++) {
                        if (dp[i][k] && dp[k][j])
                            dp[i][j] = true;
                    }
                }
            }

            if (dp[0][n + 1]) sb.append("happy\n");
            else sb.append("sad\n");
        }
        System.out.println(sb);
    }

    private static int getLen(int[] x1, int[] x2) {
        return Math.abs(x1[0] - x2[0]) + Math.abs(x1[1] - x2[1]);
    }
}
