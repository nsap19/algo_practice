package SSAFY;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_1228_암호문1_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= 10; testCase++) {
            int N = Integer.parseInt(br.readLine()); //원본 암호문의 길이
            ArrayList<String> passwords = new ArrayList<String>(N);
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                passwords.add(st.nextToken());
            }

            int command = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "I");
            for (int i = 0; i < command; i++) {
                String str = st.nextToken().trim();
//                System.out.println(st.nextToken().trim());
                String[] commands = str.split(" ");
                int index = Integer.parseInt(commands[0]);
                int cnt = Integer.parseInt(commands[1]);
                for (int j = 2; j < commands.length; j++) {
                    passwords.add(index, commands[j]);
                    index++;
                }
            }

            sb.append("#").append(testCase).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(passwords.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
