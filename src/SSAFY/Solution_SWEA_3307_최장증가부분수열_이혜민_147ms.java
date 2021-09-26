package SSAFY;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_3307_최장증가부분수열_이혜민_147ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] LIS = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            for (int i = 0; i < N; i++) {
                LIS[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
                        LIS[i] = LIS[j] + 1;
                    }
                }
                if (max < LIS[i]) max = LIS[i];
            }

            sb.append("#").append(testCase).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
