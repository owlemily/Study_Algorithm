import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int K;
    static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sb.append(bfs(N));
        System.out.println(sb);
    }
    static int bfs(int start){
        Queue<Integer> q =  new LinkedList<>();
        q.add(start);
        check[start] = 1;//bfs를 시작하는 곳의 값을 1올려준다.

        while(!q.isEmpty()){
            int num = q.poll();
            if(num == K){
                return check[num] -1;
            }
            if(num-1 >= 0 && check[num-1] == 0){//check[num-1]==0이라는 것은 아직 방문한 적이 없는곳
                check[num-1] = check[num]+1;
                q.add(num-1);
            }
            if(num + 1 <= 100000 && check[num+1] == 0){
                check[num+1] = check[num] +1;
                q.add(num+1);
            }
            if(2*num <= 100000 && check[2*num]== 0){
                check[2*num] = check[num]+1;
                q.add(2*num);
            }
        }
        return -1; //while문에서 return되지 않았다면 -1을 리턴


    }
}