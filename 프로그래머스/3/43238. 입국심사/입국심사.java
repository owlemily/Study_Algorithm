import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long low = 0;
        long high = (long)n * times[times.length-1];
        long mid = 0;
        while(low<=high){
            long count = 0; //심사할 수 있는 사람 수
            mid = (low + high) / 2;
            for(int a : times){
                count += mid/a;
            }
            if(count < n){
                low = mid+1;
            }
            else{
                high = mid-1;
                answer = mid;
            }
        }
        
        return answer;
    }
}