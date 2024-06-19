import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> giftRecords = new HashMap<>();
        Map<String, Integer> giftNum = new HashMap<>();
        Map<String, Integer> nextMonthGift = new HashMap<>();
        for (String friend:friends){
            giftRecords.put(friend, new HashMap<String, Integer>());
            giftNum.put(friend, 0);
            nextMonthGift.put(friend, 0);
        }
        for (String gift:gifts){
            String[] arr = gift.split(" ");
            String giver = arr[0];
            String receiver = arr[1];
            giftRecords.get(giver).put(receiver, giftRecords.get(giver).getOrDefault(receiver,0)+1);
            giftNum.put(giver,giftNum.get(giver) + 1);
            giftNum.put(receiver, giftNum.get(receiver) -1);
        }
        for(String giver:friends){
            for(String receiver:friends){
                if(!giver.equals(receiver)){
                    //giver->receiver 선물 개수
                    int numFromGiver = giftRecords.get(giver).getOrDefault(receiver,0);
                    //receiver->giver 선물개수
                    int numFromReceiver = giftRecords.get(receiver).getOrDefault(giver,0);
                    if(numFromGiver>numFromReceiver){
                        nextMonthGift.put(giver, nextMonthGift.get(giver)+1);
                    }//그 반대의 경우도 있으니까 한쪽이 큰 경우만 해도 되겠다.
                    else if(numFromGiver == numFromReceiver && giftNum.get(giver) > giftNum.get(receiver)){
                        nextMonthGift.put(giver, nextMonthGift.get(giver)+1);
                    }
                }
            }
        }
        int answer = 0; //nextMonthGift에서 가장 큰 수 넣기    
        answer = Collections.max(nextMonthGift.values());
        return answer;
    }
}