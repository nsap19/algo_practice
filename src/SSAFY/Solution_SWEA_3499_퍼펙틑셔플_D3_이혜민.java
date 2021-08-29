package SSAFY;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙틑셔플_D3_이혜민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            Queue<String> q1 = new LinkedList<>();
            Queue<String> q2 = new LinkedList<>();

            for (int i = 0; i < N/2; i++) {
                q1.add(st.nextToken());
            }
            if(N%2!=0) q1.add(st.nextToken());

            for (int i = 0; i < N/2; i++) {
                q2.add(st.nextToken());
            }

//            System.out.println(q1.toString());

            sb.append("#").append(testCase).append(" ");
            for (int i = 0; i < N/2; i++) {
                sb.append(q1.poll()).append(" ");
                sb.append(q2.poll()).append(" ");
            }
            if(N%2!=0) sb.append(q1.poll());

            sb.append("\n");
        }
        System.out.println(sb);

    }
}
