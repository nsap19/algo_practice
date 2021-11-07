package SSAFY;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2239_스도쿠_이혜민_528ms {
    static int[][] arr = new int[9][9];
    static int len;
    static ArrayList<int[]> blank;
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        blank = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            str = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = str.charAt(j) - '0';
                if (arr[i][j] == 0) blank.add(new int[]{i, j});
            }
        }

        len = blank.size();
        makeSudoku(0);

    }

    private static void makeSudoku(int cnt) {
        if (cnt == len) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        int r = blank.get(cnt)[0];
        int c = blank.get(cnt)[1];
        for (int i = 1; i <= 9; i++) {
            if (check(r, c, i)) {
                arr[r][c] = i;
                makeSudoku(cnt + 1);
                arr[r][c] = 0;
            }
        }

    }

    private static boolean check(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (arr[r][i] == num) return false;
            if (arr[i][c] == num) return false;
        }

        int startR = (r / 3) * 3;
        int startC = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[startR + i][startC + j] == num) return false;
            }
        }
        return true;
    }
}
