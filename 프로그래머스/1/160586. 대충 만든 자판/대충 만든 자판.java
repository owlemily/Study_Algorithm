class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int k = 0; k<targets.length; k++){
            int count = 0;
            boolean possible = true;//타겟 문자열을 만들 수 있는지 여부
            for (int i =0; i<targets[k].length(); i++){
                char targetChar = targets[k].charAt(i);
                int minCount = -1;//최소 키 누름 수 변수
                for(String button : keymap){
                    int index = button.indexOf(targetChar);//indexOf로 중요하게 바꾼 부분
                    if(index != -1){//버튼에 해당 글자가 없다면
                        int keyCount = index + 1;
                        if(minCount == -1 || keyCount < minCount){
                            minCount = keyCount;//최소 키 누름 수 갱신                   
                        }
                    }
                }
                if(minCount == -1){
                    count = -1;
                    break; //더이상 글자 안봐도됨
                }
                else{
                    count += minCount; //최소 누름 수 다 합치기
                }
            }
            answer[k] = count;//결과 배열에 저장    
        }
    return answer;
    }
}