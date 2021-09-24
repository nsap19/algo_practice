package SSAFY;

import java.io.*;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로_이혜민 {
    static int N, arr[][], min = Integer.MAX_VALUE, minTemp = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getLen1(0, 0);

        System.out.println(min);

    }

    private static void getLen1(int loc, int len) { // 0~N-1까지 가기
        if (loc == N - 1) {
            getLen2(loc, len);
            return;
        }

        if (minTemp < len) return;
        if (min < len) return;

        for (int i = 0; i < N; i++) {
            if (arr[loc][i] == 0) continue;
            if (visited[i]) continue;
            visited[i] = true;
            getLen1(i, len + arr[loc][i]);
            visited[i] = false;
        }
    }

    private static void getLen2(int loc, int len) { //0번(회사)으로 돌아오기
        if (loc == 0) {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) return; //들르지않은 장소가 하나라도 있는 경우 돌아감
            }
            min = Math.min(min, len);
            return;
        }

        if (min < len) return;

        for (int i = 0; i < N; i++) {
            if (arr[loc][i] == 0) continue;
            if (visited[i]) continue;
            visited[i] = true;
            getLen2(i, len + arr[loc][i]);
            visited[i] = false;
        }
    }
}
