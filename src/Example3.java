import java.io.*;
import java.util.*;

public class Example3 {
    static Map<String,Integer> time = new HashMap<>();
    public static void main(String[] args) throws IOException {
        int[] result = solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        System.out.println(Arrays.toString(result));
    }
    public static int[] solution(int[] fees, String[] records) {
        //map으로 자동차별 출,하차 시간 구하기 - 출차map, 하차map 따로 지정
        int[] answer;
        //map으로 자동차별 출,하차 시간 구하기 - 출차map, 하차map 따로 지정
        Map<String,String> in = new HashMap<>();
        for(int i=0; i<records.length; i++){
            String[] info = records[i].split(" ");
            String car = info[1];
            String time = info[0];
            if(info[2].equals("IN")){
                in.put(car,time);
            }
            else{
                String inTime = in.get(car);
                getTime(car, inTime, time);
                in.remove(car);
            }
        }

        if(!in.isEmpty()){
            for(String car : in.keySet()){
                getTime(car, in.get(car), "23:59");
            }
        }

        HashMap<String, Integer> result = new HashMap<>();
        int stTime = fees[0];
        int stFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        for(String car : time.keySet()){
            int totalTime = time.get(car);
            System.out.println(car+" "+totalTime);
            int totalFee=0;
            if(totalTime<=stTime) totalFee = stFee;
            else {
                totalTime -=stTime;
                totalFee+=stFee;
                totalFee+= (Math.ceil(totalTime/unitTime) * unitFee);
                System.out.println(Math.ceil((double)totalTime/unitTime));
            }
            result.put(car,totalFee);
        }

        ArrayList<String> list = new ArrayList<>(result.keySet());
        Collections.sort(list);

        int index=0;
        answer = new int[list.size()];
        for(String car : list){
            answer[index++] = result.get(car);
        }

        return answer;
    }

    static void getTime(String car, String in, String out){
        String[] inTime = in.split(":");
        String[] outTime = out.split(":");
        int inH = Integer.parseInt(inTime[0]) *60;
        int outH = Integer.parseInt(outTime[0])*60;
        int inM = Integer.parseInt(inTime[1]);
        int outM = Integer.parseInt(outTime[1]);
        int total = (outH+outM) - (inH+inM);
        if(time.containsKey(car))
            time.put(car, time.get(car)+total);
        else time.put(car, total);
    }
}