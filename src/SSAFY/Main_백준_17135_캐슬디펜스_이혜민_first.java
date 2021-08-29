package SSAFY;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_백준_17135_캐슬디펜스_이혜민_first {
    static int[][] arr;
    static int N, M, D, total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
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

        //각 열마다 궁수가 위치했을 때 공격할 수있는 범위에 적이 몇명있는지 다 세어준다
        //공격할 수 있는 범위는 밑변이 D*2-1인 삼각형
        //공격할 수 있는 범위가 arr을 넘어가지 않는지 범위체크도 해줘야겠지?
        int cnt[][] = new int[M][2]; //각 열에 위치한 궁수가 공격할 수 있는 적의 수를 카운트
        for (int i = 0; i < M; i++) { //궁수의 위치 (열 번호)
            cnt[i][0] = i; //위치
            cnt[i][1] = checkAttack(i); //공격할 수 있는 적의 수
        }

        Arrays.sort(cnt, ((o1, o2) -> o2[1] - o1[1]));
        //가장 많은 적을 공격할 수 있는 궁수의 위치를 찾아준다.
//        System.out.println(Arrays.deepToString(cnt));

        //직접 시뮬레이션하며 세어준다. - 중복이 있을 수 있으니?
        for (int row = N; row > 0; row--) { //행은 점점 위로
            for (int j = 0; j < 3; j++) { //top3 궁수 위치
                int a = cnt[j][0]; //궁수 위치
//                System.out.println(a);
                remove(row, a);

            }
        }

        System.out.println(total);

    }

    //공격할 수 있는 범위내에 적이 몇명있는지 구하기
    private static int checkAttack(int c) { //궁수의 위치 입력
        int startC = c - D + 1;
        int endC = c + D - 1;
        if (startC < 0) startC = 0;
        if (endC >= M) endC = M - 1;

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = startC; j <= endC; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    //거리가 제일 가깜고, 같은 거리에 있다면 가장 왼쪽에 있는 적 제거
    private static void remove(int r, int c) { //궁수의 위치 입력
        int startC = c - D + 1;
        int endC = c + D - 1;
        if (startC < 0) startC = 0;
        if (endC >= M) endC = M - 1;

        //가장 가까운 적 제거하려면 바로 윗 행~ D만큼떨어진행까지
        for (int d = 1; d <= 3; d++) { //가까운 거리부터 조회
//            System.out.println(d);
            int nr = r, nc = c - d;
            for (int x = 1; x < d * 2; x++) {
                if (x <= d) {
                    nr--;
                    nc++;
                } else {
                    nr++;
                    nc++;

                }
//                System.out.println(nr + " " + nc);
                if (nr < 0 || nc < startC || nc > endC) continue;
                else {
                    if (arr[nr][nc] == 1) {
                        arr[nr][nc] = 0;
                        total++;
                        return;
                    }
                }
            }


        }

    }
}
