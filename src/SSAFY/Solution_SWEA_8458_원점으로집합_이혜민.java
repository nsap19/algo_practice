package SSAFY;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_8458_원점으로집합_이혜민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
                max = Math.max(max, arr[i]);
            }

            int result = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] % 2 != arr[i - 1] % 2) result = -1;
            }

            int sum = 0;
            if (result == 0) {
                while (true) {
                    if (sum >= max && (sum - max) % 2 == 0) break;
                    sum += ++result;
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
