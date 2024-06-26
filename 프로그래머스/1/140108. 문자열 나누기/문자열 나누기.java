class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int cnt = 0;
        int other = 0;
        for (int i = 0; i < s.length(); i++){
            if(cnt == other){
                answer++;
                x = s.charAt(i);//여기서 x를 다시 지정해주어야함 
            }
            if(x == s.charAt(i)){
                cnt ++;
            }
            else{
                other ++;
            }
        }
        return answer;
    }
}