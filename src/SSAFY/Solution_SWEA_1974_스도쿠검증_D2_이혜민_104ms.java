package SSAFY;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_1974_스도쿠검증_D2_이혜민_104ms {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        arr = new int[9][9];
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            //초기화
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean check = true;
            //같은 행, 열 체크 - 맨앞 값들만 들어감
            for (int i = 0; i < 9; i++) {
                if (!checkRow(i)) {
                    check = false;
                    break;
                }
                if (!checkCol(i)) {
                    check = false;
                    break;
                }
            }

            // 3 x 3 사각형에 같은 값이 있는지 확인 - 사각형의 시작점만 넘어올것임
            loop:
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    if (!checkSquare(i, j)) {
                        check = false;
                        break;
                    }
                }
            }

            if (check) sb.append("1\n");
            else sb.append("0\n");

        }
        System.out.println(sb);
    }

    private static boolean checkRow(int row) {
        //각 행의 번호들이 들어올 것
        int[] check = new int[10];
        for (int i = 0; i < 9; i++) {
            int index = arr[row][i];
            if (check[index] == 0) check[index]++;
            else return false;
        }
        return true;
    }

    private static boolean checkCol(int col) {
        //각 열의 번호들이 들어올 것
        int[] check = new int[10];
        for (int i = 0; i < 9; i++) {
            int index = arr[i][col];
            if (check[index] == 0) check[index]++;
            else return false;
        }
        return true;
    }

//    private static boolean checkRC(int row, int col, int val) {
//        //같은 행, 같은 열에 같은 값이 있는지 체크
//        int nr = row, nc = col;
//        for (int i = 1; i < 9; i++) {
//            nc = (nc + i) % 9;
//            if (arr[row][nc] == val) return false;
//        }
//
//        for (int i = 1; i < 9; i++) {
//            nr = (nr + i) % 9;
//            if (arr[nr][col] == val) return false;
//        }
//
//        return true;
//    }

    private static boolean checkSquare(int row, int col) {
        // 3 x 3 사각형에 같은 값이 있는지 확인 - 사각형의 시작점만 넘어올것임
        int[] check = new int[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int index = arr[row + i][col + j];
                if (check[index] == 0) check[index]++;
                else return false;
            }
        }
        return true;

    }
}
