import java.util.Arrays;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[10];
        int cnt = 0; //일치하는 번호 개수 세기
        int zeros = 0; //지워진 0 개수 세기
        for(int i = 0; i<lottos.length; i++){
            if(lottos[i] == 0){
                zeros += 1;
            }
            for(int j = 0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    cnt += 1;
                }
            }
        }
        int best = cnt+zeros;
        int worst = cnt;
        for(int i = 0; i <= 7; i++){
            if(i == 0| i == 1){
                answer[i] = 6;
            }
            else if(i == 2){
                answer[i] = 5;
            }
            else if(i == 3){
                answer[i] = 4;
            }
            else if(i == 4){
                answer[i] = 3;
            }
            else if(i == 5){
                answer[i] = 2;
            }
            else if(i == 6){
                answer[i] = 1;
            }
        }
        
        int a = answer[best];
        int b = answer[worst];
        
        return new int[]{a, b};
    }
}