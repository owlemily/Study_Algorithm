import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i = 0; i<completion.length ; i++){
            if(!completion[i].equals(participant[i])){
                answer = participant[i];
                return answer;
                }
            }
        //모든 요소가 매치된 경우 participant의 마지막 요소가 완주못한 사람
        answer = participant[participant.length - 1];
        return answer;
    }
}