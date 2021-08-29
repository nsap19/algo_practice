import java.io.*;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
        int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            char[][] arr = new char[n][n];

            //입력
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    boolean check = true;
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[i].length) {
                            if (arr[nx][ny] == 'G') {
                                check = false;
                                break;
                            }
                        }
                    }

                    int count = 0;
                    if (arr[i][j] == 'B' && check) { //인근의 공원이 없는 빌딩이 있는 경우
                        for (int k = 0; k < n; k++) { //가로에 위치한 빌딩 구획 수
                            if (arr[i][k] == 'B') count++;
                        }
                        for (int k = 0; k < n; k++) { //세로에 위치한 빌딩 구획 수
                            if (arr[k][j] == 'B') count++;
                        }
                        count--; //중복된 자기자신 빼기
                    } else if (arr[i][j] == 'B' && !check) { //인근의 공원이 있는 빌딩이 있는 경우
                        count = 2;
                    }

                    if (max < count) max = count;
                }
            }
            System.out.printf("#%d %d\n", test_case, max);
        }

    }
}
