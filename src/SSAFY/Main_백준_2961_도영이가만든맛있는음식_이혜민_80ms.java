package SSAFY;

import java.io.*;
import java.util.StringTokenizer;

public class Main_백준_2961_도영이가만든맛있는음식_이혜민_80ms {
    static int N, sour[], bitter[], min = Integer.MAX_VALUE;
    static boolean checked[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //재료의 갯수

        sour = new int[N]; //신맛, 곱
        bitter = new int[N]; //쓴맛, 합
        checked = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        getSubSet(0);

        System.out.println(min);
    }

    private static void getSubSet(int cnt) {
        if (cnt == N) {
            int cntCheck = 0;

            int sumSour = 1, sumBitter = 0;
            for (int i = 0; i < N; i++) {
                if (checked[i] == true) {
                    cntCheck++;
                    sumSour *= sour[i];
                    sumBitter += bitter[i];
                }
            }
            if (cntCheck == 0) return;
            min = Math.min(Math.abs(sumBitter - sumSour), min);
            return;
        }

        checked[cnt] = true;
        getSubSet(cnt + 1);

        checked[cnt] = false;
        getSubSet(cnt + 1);
    }
}
