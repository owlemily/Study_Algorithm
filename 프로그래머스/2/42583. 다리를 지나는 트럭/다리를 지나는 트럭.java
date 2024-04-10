import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;//걸린 시간
        int sum = 0; //다리 위 트럭 총 무게
        Queue<Integer> q = new LinkedList<>();
        
        for(int t : truck_weights){
            while(true){
            if(q.isEmpty()){//다리가 비었을 때
                q.add(t);
                answer ++;
                sum += t;
                break;
            }            
            else if(q.size() == bridge_length){//다리가 꽉찼을 때
                sum -= q.poll();//맨앞 원소 제거
            }
            else{//다리가 빈공간이 있을 때
                if(sum + t > weight){
                    q.add(0);
                    answer ++;
                }
                else{//sum+t <= weight
                    q.add(t);
                    answer++;
                    sum += t;
                    break;
                }
                
            }
                
            }
            
        } 
    
        return answer+bridge_length;
    }
}