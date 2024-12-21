import java.io.*;
import java.util.*;
public class Main{
    static Queue<Integer> q;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        StringTokenizer st;
        sb = new StringBuilder();
        String s;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            if(s.equals("push")) push(Integer.parseInt(st.nextToken()));
            if(s.equals("pop")) pop();
            if(s.equals("size")) size();
            if(s.equals("empty")) empty();
            if(s.equals("front")) front();
            if(s.equals("back")) back();
        }
        System.out.print(sb);
    }

    //큐에 x 삽입
    static void push(int x){
        q.add(x);
    }

    //큐 첫번째 숫자 빼내기
    static void pop(){
        if(q.isEmpty()){
            sb.append("-1\n");
        }else{
            sb.append(q.remove() + "\n");
        }
    }

    //큐 사이즈 출력
    static void size(){
        sb.append(q.size() + "\n");
    }

    //큐가 비어있으면 1, 비어있지 않으면 0 출력
    static void empty(){
        if(q.isEmpty()){
            sb.append("1\n");
        }else{
            sb.append("0\n");
        }
    }

    //큐가 비어있으면 -1, 비어있지 않으면 첫번째 숫자 출력
    static void front(){
        if(q.isEmpty()){
            sb.append("-1\n");
        }else{
            sb.append(q.peek() + "\n");
        }
    }

    //큐가 비어있으면 -1, 비어있지 않으면 마지막 숫자 출력
    static void back(){
        if(q.isEmpty()){
            sb.append("-1\n");
            return;
        }
        int n = q.size();
        for(int i = 1; i <= n-1; i++){
            q.add(q.remove());
        }
        sb.append(q.peek() + "\n");
        q.add(q.remove());
    }
}