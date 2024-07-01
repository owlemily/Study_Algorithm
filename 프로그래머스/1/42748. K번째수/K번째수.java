import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int z = 0; z<commands.length; z++){
            int i = commands[z][0] ;
            int j = commands[z][1] ;
            int k = commands[z][2] ;
            int[] arr = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(arr);
            answer[z] = arr[k-1];            
        }
        return answer;
    }
}