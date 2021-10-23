import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println(LCS("ABCBDAB".toCharArray(), "BDCABA".toCharArray()));

    }

    private static int LCS(char[] x, char[] y){
        int l1 = x.length;
        int l2 = y.length;
        int[][] dp = new int[l1+1][l2+1];

        for (int i = 0; i <= l1 ; i++) {
            for (int j = 0; j <= l2; j++) {
                if(i==0 || j==0) dp[i][j] = 0;
                else if(x[i-1]==y[j-1]){ //마지막 두문자 비교, 같다면
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {//마지막 두 문자가 다르다면
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                }
            }
        }
        return dp[l1][l2];
    }

}
