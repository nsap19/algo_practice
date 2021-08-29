package SSAFY.IM_Prepare;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_1859_백만장자프로젝트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine()); //입력 갯수
            st = new StringTokenizer(br.readLine(), " ");

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = arr[N - 1]; //물건을 팔 수 있는 최대값
            long result = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] < max) { //물건의 이익을 남기는 경우
                    result += max - arr[i];
                } else max = arr[i];
            }

            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
