package SSAFY.IM_Prepare;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_2007_패턴마디의길이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            String str = br.readLine();

            int result = 0;
            for (int i = 1; i < 10; i++) { //마디의 길이 1~10
                String temp1 = str.substring(0, i); //맨 첫 마디
                String temp2 = str.substring(i, i + i); //두번째 마디

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
