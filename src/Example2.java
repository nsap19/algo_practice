import java.io.*;
import java.util.StringTokenizer;

public class Example2 {
    public static void main(String[] args) throws IOException {
    }
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int current = n;
        while(current>0){
            if(current %k<10){
                sb.append(current%k);
            }else{
                sb.append((char)(current%k-10+'A'));
            }
            current/=k;
        }

        String strN = sb.reverse().toString();
        // String[] temp = sb.reverse().toString().split("0");

        //에라토스테네스의체
        boolean[] prime = new boolean[1001];
        prime[0]= prime[1] = true;

        for(int i=2; i*i<=1000; i++){
            if(!prime[i]){
                for(int j= i*i; j<=1000; j+=i) prime[j] = true;
            }
        }


        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<strN.length(); i++){
            if(strN.charAt(i)!='0'){
                sb2.append(strN.charAt(i));
            }
            else{
                if(sb2.toString().equals("")) continue;
                int num = Integer.parseInt(sb2.toString());
                if(!prime[num]) answer++;
                sb2 = new StringBuilder();
            }
        }
        if(!sb2.toString().equals("")) {
            try{
                int num = Integer.parseInt(sb2.toString());
                if(!prime[num]) answer++;
            }
            catch(Exception e){
                Long num = Long.parseLong(sb2.toString());
                Double num2 = Math.sqrt(num)+1;
                boolean check=true;
                for(Double i=2.0; i<num2; i++){
                    if(num%i==0) {
                        check=false;
                        break;
                    }
                }
                if(check) answer++;


            }
        }

        // System.out.println(Arrays.toString(temp));
        return answer;
    }
}