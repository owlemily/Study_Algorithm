import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;//섞어야하는 최소 횟수
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        while(pq.peek() < K){
            if(pq.size() >= 2){
                int first = pq.poll();
                int second = pq.poll();
                int newfood = first + (second * 2);   
                pq.offer(newfood);
                answer ++;
            }
            else if(pq.size() == 1){
                return -1;
            }
        }
        return answer;
    }
}