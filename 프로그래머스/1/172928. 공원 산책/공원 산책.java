class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = 0;
        int y = 0;
        for(String str: park){
            if(str.contains("S")){
                x = str.indexOf("S");
                break;
            }
            y++;
        }
        
        for (String move : routes){
            String[] arr = move.split(" ");
            char dir = arr[0].charAt(0);
            int num = Integer.parseInt(arr[1]);
            int moveX = x;
            int moveY = y;
            
            if(dir == 'W' || dir == 'N'){
                num *= -1;
            }
            
            //이동하는 것 구현
            if(dir == 'E' || dir == 'W'){
                moveX += num;
            }
            else{
                moveY += num;
            }
            
            //공원을 벗어나는지 확인
            if(moveX < 0 || moveY < 0 || moveY >= park.length || moveX >= park[0].length()){
                continue;
            }
            //장애물을 만나는지 확인 //x축 상에서
            boolean isBlocked = false;
            for(int i = (x < moveX ? x: moveX); i <= (x<moveX ? moveX: x); i++){
                if(park[y].charAt(i) == 'X'){
                    isBlocked = true;
                    break;
                }
            }
            //장애물을 만나는지 확인 //y축 상에서
            for(int i = (y < moveY ? y: moveY); i<= (y<moveY ? moveY: y); i++){
                if(park[i].charAt(x) == 'X'){
                    isBlocked = true;
                    break;
                }
            }
            if(!isBlocked){
                x = moveX;
                y = moveY;
            }
        }
        int[] answer = new int[] {y,x};
        return answer;
    }
}