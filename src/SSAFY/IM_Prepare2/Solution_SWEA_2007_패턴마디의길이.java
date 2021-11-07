package SSAFY.IM_Prepare2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_2007_패턴마디의길이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int result = 0;
            String str = br.readLine();
            for (int i = 1; i <= 10; i++) {
                String temp1 = str.substring(0, i);
                String temp2 = str.substring(i, i + i);

                if (temp1.equals(temp2)) {
                    result = i;
                    break;
                }
            }
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
