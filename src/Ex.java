import java.io.*;
import java.util.*;

public class Ex {
    public static void main(String[] args) {
        System.out.println("ace15".compareTo("card"));
        System.out.println("ace15".compareTo("ace14"));
        System.out.println("ace15".compareTo("ace16"));
        System.out.println(solution(new String[]{"card", "ace13", "ace16", "banker", "ace17", "ace14"}, "ace15"));
    }

    public static String solution(String[] registered_list, String new_id) {
        String answer = "";

        Map<String, Boolean> map = new HashMap<>();
        for(int i=0; i<registered_list.length; i++){
            map.put(registered_list[i], true);
        }

        System.out.println(map.size());


        if(!map.get(new_id)) {
            answer = new_id;
            return answer;
        }

        String s = new_id.replaceAll("[0-9]","");
        String sn = new_id.replaceAll("[^0-9]","");
        int n = sn.equals("") ? 0 : Integer.parseInt(sn);

        while(true){
            n++;
            new_id = s+String.valueOf(n);

            if(!map.get(new_id))
                break;
        }
        return new_id;
    }

}
