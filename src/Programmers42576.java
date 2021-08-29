import java.io.IOException;
import java.util.HashMap;

//participant	completion	return
//["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
//["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
//["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
public class Programmers42576 {
    public static void main(String[] args) throws IOException {
//        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
//        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));

    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        //동명이인을 count하기 위해 getOrDefault를 이용함
        //key - 이름, value - 이름을 가진 사람의 수
        for (String name : participant) map.put(name, map.getOrDefault(name, 0) + 1);
        System.out.println(map.entrySet()); //디버깅

        //completion을 조회하며 완주한 선수를 빼줌
        for (String name : completion) map.put(name, map.get(name) - 1);

        //value가 0이 아닌 key가 완주하지 못한 선수
        for (String key : map.keySet()) {
            if (map.get(key) != 0) return key;
        }

        return null;
    }
}
