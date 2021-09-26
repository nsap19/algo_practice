package SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3307_최장증가부분수열_이혜민_127ms {
    static int[] LIS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            LIS = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int end = 0;
            LIS[0] = arr[0];
            for (int i = 1; i < N; i++) {
                if (LIS[end] == arr[i]) continue;
                if (LIS[end] < arr[i]) {
                    LIS[end + 1] = arr[i];
                    end++;
                } else {
                    int index = find(arr[i], 0, end);
                    LIS[index] = arr[i];
                }
                System.out.println(Arrays.toString(LIS));
            }

            sb.append("#").append(testCase).append(" ").append(end + 1).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int num, int start, int end) {
        int mid = start;
        while (start <= end) {
            mid = (start + end) / 2;
            if (LIS[mid] == num) return mid;
            if (LIS[mid] > num) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
}
