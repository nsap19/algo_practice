package SSAFY.IM_Prepare2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_5356_의석이의세로로말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            String[][] arr = new String[5][];
            int max = 0;
            for (int i = 0; i < 5; i++) {
                arr[i] = br.readLine().split("");
                max = Math.max(max, arr[i].length);
            }

            sb.append("#").append(testCase).append(" ");
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < 5; j++) {
                    if (arr[j].length > i) sb.append(arr[j][i]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
