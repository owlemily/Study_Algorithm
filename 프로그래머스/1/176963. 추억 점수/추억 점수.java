import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        for(int i = 0; i < photo.length; i++){
            int sum = 0;
            for(int j = 0; j<photo[i].length; j++){
                if(map.containsKey(photo[i][j])){
                    sum += map.get(photo[i][j]);
                }                
            }
            answer[i] = sum;
        }
        
        
        return answer;
    }
}