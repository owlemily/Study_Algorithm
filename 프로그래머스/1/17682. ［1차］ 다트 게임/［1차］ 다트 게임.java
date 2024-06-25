import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String numstr = "";
        int[] arr = new int[3];
        int index = 0;
        
        for(int i = 0; i<dartResult.length(); i++){
            switch(dartResult.charAt(i)){                   
                case 'S':
                    arr[index] = (int)Math.pow(Integer.parseInt(numstr), 1);
                    index++;
                    numstr =""; //초기화
                    break;
                case 'D':
                    arr[index] = (int)Math.pow(Integer.parseInt(numstr), 2);
                    index++;
                    numstr = "";
                    break;                    
                case 'T':
                    arr[index] = (int)Math.pow(Integer.parseInt(numstr), 3);
                    index++;
                    numstr = "";
                    break;
                case '*':
                    arr[index-1] *= 2;
                    if(index > 1){
                        arr[index - 2] *= 2;
                    }
                    break;
                case '#':
                    arr[index -1] *= -1;
                    break;
                default:
                    numstr += String.valueOf(dartResult.charAt(i));
                    break;
            }
        }
        for(int a : arr){
            answer += a;
        }
        
        return answer;
    }
}