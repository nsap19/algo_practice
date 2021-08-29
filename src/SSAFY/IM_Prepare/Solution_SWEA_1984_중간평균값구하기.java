package SSAFY.IM_Prepare;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1984_중간평균값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int arr[] = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            long sum = 0;
            for (int i = 1; i < 9; i++) {
                sum += arr[i];
            }

            sum = Math.round((double) sum / 8);

            sb.append("#").append(testCase).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
