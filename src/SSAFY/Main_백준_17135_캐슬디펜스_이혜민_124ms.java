package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17135_캐슬디펜스_이혜민_124ms {
    static int[][] arr;
    static int[][] tmpArr;
    static int N, M, D, max = 0;
    static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열
        D = Integer.parseInt(st.nextToken()); //공격거리 제한

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //궁수가 배치될 수 있는 조합 구하기
        combi(0, 0);

        System.out.println(max);

    }

    private static void combi(int cnt, int start) {
        if (cnt == 3) {
            //조합이 구해졌으면 시뮬레이션 해보기
            int total = 0;
            tmpArr = new int[arr.length][arr[0].length]; //복사본 배열
            for (int i = 0; i < tmpArr.length; i++) {
                System.arraycopy(arr[i], 0, tmpArr[i], 0, arr[0].length);
            }

            for (int i = N; i > 0; i--) {  //한 행씩 올라가며 처리
                for (int j = 0; j < 3; j++) {
                    total += remove(i, result[j]);
                }

                //중복처리해놓은 곳 제거
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (tmpArr[j][k] == 2) tmpArr[j][k] = 0;
                    }
                }
            }

            if (total > max) max = total;

            return;
        }

        for (int i = start; i < M; i++) {
            result[cnt] = i;
            combi(cnt + 1, i + 1);
        }

    }

    //거리가 제일 가깜고, 같은 거리에 있다면 가장 왼쪽에 있는 적 제거
    private static int remove(int r, int c) { //궁수의 위치 입력
        int cnt = 0;
        int startC = c - D + 1;
        int endC = c + D - 1;
        if (startC < 0) startC = 0;
        if (endC >= M) endC = M - 1;

        for (int d = 1; d <= D; d++) { //가까운 거리부터 조회
            int nr = r, nc = c - d;
            for (int x = 1; x < d * 2; x++) {
                if (x <= d) {
                    nr--;
                } else {
                    nr++;
                }
                nc++;

                if (nr >= 0 && nc >= startC && nc <= endC && tmpArr[nr][nc] != 0) {
                    if (tmpArr[nr][nc] == 1) {
                        tmpArr[nr][nc]++;
                        cnt++;
                    } else return 0;

                    return cnt;
                }
            }
        }
        return 0;
    }
}
