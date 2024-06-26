class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            for(int j =1; j<= index; j++){//index횟수만큼 s.charAt()을 이동시킨다.
                if(c == 'z'){
                    c -= 26; //알파벳은 26개 //그 다음부터 a가 될 수 있을 것.
                }
                c++;
                if(skip.contains(String.valueOf(c))){
                    j--;
                }
            }
            answer += String.valueOf(c);
        }
        return answer;
    }
}