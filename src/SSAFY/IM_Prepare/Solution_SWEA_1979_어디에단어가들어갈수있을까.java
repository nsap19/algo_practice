package SSAFY.IM_Prepare;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_1979_어디에단어가들어갈수있을까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); //가로, 세로 길이
            int K = Integer.parseInt(st.nextToken());// 단어의 길이

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            //가로 체크
            int len = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1) len++;
                    else {
                        if (len == K) {
                            cnt++;
                        }
                        len = 0;
                    }
                }
                if (len == K) {
                    cnt++;
                }
                len = 0;
            }

            //세로 체크
            len = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[j][i] == 1) len++;
                    else {
                        if (len == K) {
                            cnt++;
                        }
                        len = 0;
                    }
                }
                if (len == K) {
                    cnt++;
                }
                len = 0;
            }

            sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
