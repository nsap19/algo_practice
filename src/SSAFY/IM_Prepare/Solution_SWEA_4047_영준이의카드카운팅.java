package SSAFY.IM_Prepare;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_4047_영준이의카드카운팅 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int s, d, h, c;
            s = d = h = c = 0;
            boolean[][] nums = new boolean[4][14];

            String cards = br.readLine();
            boolean flag = true;
            for (int i = 0; i < cards.length(); i += 3) {
                char pattern = cards.charAt(i);
                int num = (cards.charAt(i + 1) - '0') * 10 + (cards.charAt(i + 2) - '0');

                if (pattern == 'S' && !nums[0][num]) {
                    nums[0][num] = true;
                } else if (pattern == 'D' && !nums[1][num]) {
                    nums[1][num] = true;
                } else if (pattern == 'H' && !nums[2][num]) {
                    nums[2][num] = true;
                } else if (pattern == 'C' && !nums[3][num]) {
                    nums[3][num] = true;
                } else {
//                    System.out.println(pattern+" "+num);
                    flag = false;
                    break;
                }
            }

            sb.append("#").append(testCase).append(" ");
            if (flag) {
                for (int i = 1; i < 14; i++) {
                    if (!nums[0][i]) s++;
                    if (!nums[1][i]) d++;
                    if (!nums[2][i]) h++;
                    if (!nums[3][i]) c++;

                }
                sb.append(s).append(" ").append(d).append(" ").append(h).append(" ").append(c).append("\n");
            } else sb.append("ERROR").append("\n");
        }
        System.out.println(sb);
    }
}

