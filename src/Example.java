import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Example {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int[] result = solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //report 중복 제거
        Set<String> set = new HashSet<>();
        for (int i = 0; i < report.length; i++) {
            set.add(report[i]);
        }

        //정지대상
        ArrayList<String> pause_user = new ArrayList<>();
        //이용자별 신고당한 횟수 count hashmap
        HashMap<String, Integer> map = new HashMap<>();
        //이용자별 신고 리스트
        HashMap<String, ArrayList<String>> report_list = new HashMap<>();
        for (String str : set) {
            String[] temp = str.split(" ");
            String user = temp[0];
            String decla = temp[1];
            //이용자별 신고당한 횟수 카운트
            map.put(decla, map.getOrDefault(decla, 0) + 1);
            if (map.get(decla) == k) pause_user.add(decla);

            //이용자별 신고 리스트 정리
            if (report_list.containsKey(user)) {
                report_list.get(user).add(decla);
                report_list.put(user, report_list.get(user));
            } else {
                ArrayList<String> temp2 = new ArrayList<>();
                temp2.add(decla);
                report_list.put(user, temp2);
            }
        }

//        System.out.println(pause_user.toString());
//        System.out.println(report_list.toString());

        for (int i = 0; i < id_list.length; i++) {
            int result = 0;
//            System.out.println(report_list.get(id_list[i]).toString());
            if (report_list.containsKey(id_list[i])) {
                ArrayList<String> temp = report_list.get(id_list[i]);
                for (String user : temp) {
                    if (pause_user.contains(user)) result++;
                }
            }
            answer[i] = result;
        }

        return answer;
    }


}
