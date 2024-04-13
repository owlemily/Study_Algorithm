import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());//테스트 데이터 개수

        while(t-- >0){//반복을 한번 할때 테스트케이스 하나하는데, t가 0이되면 종료
            Stack<Character> stack = new Stack<>();
            String s = br.readLine() + "\n";//한 라인에 엔터 기호까지 포함시키기
            //한 라인을 읽고 스택에 다 담는다
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == ' ' || s.charAt(i) == '\n'){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(s.charAt(i));
                }
                else{
                    stack.push(s.charAt(i));
                }
            }
        }
        System.out.println(sb);
    }
}