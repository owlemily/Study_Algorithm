import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0 ; i < reserve.length;i++){
            
            for(int j = 0 ; j < lost.length; j++){
                
                if(reserve[i] == lost[j]){
                    
                    answer += 1;
                    reserve[i] = -1;
                    lost[j] = -1;
                    
                }
            }
        }

        for(int i = 0 ; i < reserve.length; i++){
            
            for(int j = 0 ; j < lost.length; j++){
                
                if(reserve[i] != -1 && lost[j] != -1){
                    
                    if(reserve[i] - lost[j] == 1 || reserve[i] - lost[j] == -1){
                        
                        answer += 1;
                        reserve[i] = -1;
                        lost[j] = -1;
                        
                    }
                }
            }
        }
        return answer;
    }
}