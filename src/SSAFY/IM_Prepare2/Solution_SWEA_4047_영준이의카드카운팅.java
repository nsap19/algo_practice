package SSAFY.IM_Prepare2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_4047_영준이의카드카운팅 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= tc; testCase++) {
            int[][] check = new int[4][14];
            boolean flag = true;
            String str = br.readLine();
            for (int i = 0; i < str.length(); i += 3) {
                char T = str.charAt(i);
                int XY = (str.charAt(i + 1) - '0') * 10 + str.charAt(i + 2) - '0';
                int card = 0;
                switch (T) {
                    case 'S':
                        card = 0;
                        break;
                    case 'D':
                        card = 1;
                        break;
                    case 'H':
                        card = 2;
                        break;
                    case 'C':
                        card = 3;
                        break;
                }
                if (check[card][XY] != 0) {
                    flag = false;
                    break;
                } else check[card][XY]++;
            }

            sb.append("#").append(testCase).append(" ");
            if (!flag) sb.append("ERROR").append("\n");
            else {
                for (int i = 0; i < 4; i++) {
                    int cnt = 0;
                    for (int j = 1; j <= 13; j++) {
                        if (check[i][j] == 0) cnt++;
                    }
                    sb.append(cnt).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
