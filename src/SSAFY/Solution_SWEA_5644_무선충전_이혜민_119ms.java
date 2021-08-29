package SSAFY;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_5644_무선충전_이혜민_119ms {
    static int M, A;
    static int[] Amove, Bmove;
    static int[] dr = {0, 0, 1, 0, -1};  //이동x, 상, 우, 하, 좌
    static int[] dc = {0, -1, 0, 1, 0}; //이동x, 상, 우, 하, 좌
    static int[][] ap;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); //총 걸리는 시간
            A = Integer.parseInt(st.nextToken()); //BC의  갯수
            total = 0;

            Amove = new int[M];
            Bmove = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                Amove[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                Bmove[i] = Integer.parseInt(st.nextToken());
            }

            ap = new int[A][4];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 4; j++) {
                    ap[i][j] = Integer.parseInt(st.nextToken()); //열, 행, 충전범위, 성능
                }
            }

            //A, B 시간별로 이동
            //시간 별 위치에서의 최대값 구하기
            int Ar = 1, Ac = 1, Br = 10, Bc = 10;
            //시작위치에서도 체크
            total += charge(Ar, Ac, Br, Bc);

            for (int time = 0; time < M; time++) {
                Ar += dr[Amove[time]];
                Ac += dc[Amove[time]];
                Br += dr[Bmove[time]];
                Bc += dc[Bmove[time]];

                //각 위치에서 모든 충전기의 정보를 순회하며 충전가능 범위인지 확인
                total += charge(Ar, Ac, Br, Bc);

            }

            sb.append("#").append(testCase).append(" ").append(total).append("\n");
        }
        System.out.println(sb);
    }

    private static int charge(int ar, int ac, int br, int bc) {
        int sum;
        int max = 0;
        for (int i = 0; i < A; i++) { //모든 BC를 돌며 충전가능 범위인지 확인
            for (int j = 0; j < A; j++) {
                int a = checkRange(ar, ac, i);
                int b = checkRange(br, bc, j);
                sum = a + b;

                if (i == j && a == b) { //이미 겹쳤다면 sum이 두배가 되어있기때문에 /2
                    sum /= 2;
                }

                if (max < sum) max = sum; //충전할수 있는 값의 최대값 구하기

            }
        }

        return max;
    }

    private static int checkRange(int x, int y, int BC) {
//        ap[i][] //i번 충전기의 열, 행, 충전범위, 성능
        //해당 위치가 충전기의 충전범위 내에 들어오는지 확인
        if (Math.abs(ap[BC][0] - x) + Math.abs(ap[BC][1] - y) <= ap[BC][2])
            return ap[BC][3];
        return 0;
    }
}
