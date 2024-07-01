import java.util.*;
class Solution {
    public int solution(int[] nums) {

        Arrays.sort(nums); //종류 숫자 순대로 정렬
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        if(map.size() <= (int)(nums.length / 2)){
            return map.size();
        }
        else{
            return (int)nums.length / 2;
        }
    }
}