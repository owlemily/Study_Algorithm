import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> list = new ArrayList<>();//중복되지 않는 숫자만 담는 리스트
    
        int prev = arr[0];
        list.add(prev);
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != prev){
                list.add(arr[i]);
                prev = arr[i];
            }
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}