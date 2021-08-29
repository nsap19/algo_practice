//progresses	speeds	return
//[93, 30, 55]	[1, 30, 5]	[2, 1]
//[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers42586 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(Solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
//        System.out.println(Arrays.toString(Solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
//        System.out.println(Arrays.toString(Solution2.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(Solution2.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

}

class Solution {
    static public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>(); //기능(prgress)별 작업 기간을 담는 Queue
        // 먼저 입력된 순으로 처리해야하기 때문에 First in First Out인 큐를 선택
        ArrayList<Integer> resultList = new ArrayList<>(); //몇번의 배포가 발생할지 모르므로 Arraylist 사용
        int[] result;

        //progress별 작업 기간을 구해 queue에 담아준다.
        for (int i = 0; i < progresses.length; i++) {
            int pDay = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]); //작업 기간
            //3.1일 => 4일로 처리해야하므로 Math.ceil을 이용해 올림

            queue.add(pDay);
        }
//        System.out.println(queue.toString());

        int day = queue.peek(); //첫 기능과 같은 날에 배포될 기능을 구할 것임
        int count = 0;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek() <= day) {
                // 첫번째 기능이 배포되는 날에 같이 배포할 수 있는 기능 갯수 count
                // 작업 기간이 첫번째 기능 배포 날보다 작거나 같은 경우 함께 배포될 것이기 때문에 count++
                count++;
                queue.poll();
            }

            //같은 날에 배포할 수 있는 기능 count가 끝났기 때문에 resultList에 count를 add해줌
            resultList.add(count);
            count = 0;

            //day를 다음 기능이 배포되는 날로 지정
            if (!queue.isEmpty()) day = queue.peek();

        }

        //arraylist to array
        result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}

//while문 중첩이 너무 시간적으로 별로 인 것 같아 다른 풀이 참고
class Solution2 {
    static public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        int[] result;

        //queue에는 같은 날에 배포될 기능을 담을 것
        for (int i = 0; i < progresses.length; i++) { //7,3,9
            int pDay = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]); //기능별 작업기간

            if (!queue.isEmpty()) System.out.println(queue.toString()+"\n"); //디버깅

            // queue에는 같은 날에 배포될 기능의 작업기간을 담고
            // 같은 날에 배포될 수 없을 때 queue의 사이즈를 resultList에 담고 queue를 비워준다.
            if (!queue.isEmpty() && queue.peek() < pDay) { //먼저 배포될 날(queue.peek())보다 이후에 배포될 기능(pDay)이 있을 때
                //디버깅
                System.out.println("다음 기능의 배포일(pDay)이 "+pDay+"이므로\n"+queue.peek()+"일(queue.peek())에 "+queue.size()+"개 배포!\n");

                resultList.add(queue.size()); //queue.size()는 같은날에 배포될 수 있는 기능의 갯수
                queue.clear();
            }

            //같은 날에 배포될 기능의 작업기간을 넣어준다.
            queue.add(pDay);

            //디버깅
            if (!queue.isEmpty()) {
                System.out.println("배포될 날(queue.peek()): " + queue.peek());
            }
            System.out.println("기능 작업 기간(pDay): "+pDay);

        }
        resultList.add(queue.size());

        result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}