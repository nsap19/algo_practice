package SSAFY;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_이혜민 {
    static int[] taste, cal;
    static int N, L, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); //테스트케이스

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());//재료의 수
            L = Integer.parseInt(st.nextToken());//제한 칼로리

            taste = new int[N]; //맛 점수
            cal = new int[N]; //칼로리
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                taste[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            max = 0;
            getSubSet(0, 0, 0);

            sb.append("#").append(testCase).append(" ").append(max).append("\n");
        }
        System.out.print(sb);


    }

    private static void getSubSet(int cnt, int calSum, int tasteSum) { //재료 부분집합 구하기
        if (calSum > L) return; //최대 칼로리 초과하면 돌아가기
        if (calSum <= L) max = Math.max(max, tasteSum);
        if (cnt == N) return; //끝까지 다 확인했으면 돌아가기

        //해당 재료 선택했을 때
        getSubSet(cnt + 1, calSum + cal[cnt], tasteSum + taste[cnt]);

        //해당 재료 선택하지 않았을 때
        getSubSet(cnt + 1, calSum, tasteSum);


    }
}
