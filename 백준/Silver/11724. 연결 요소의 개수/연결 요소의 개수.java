import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int N;
    static int[][] graph = new int[1001][1001];
    static boolean[] visit = new boolean[500000]; //N x (N-1) /2 = 499500
    static int CC = 0; //그룹에 노드가 들어 왔는지 확인하는 변수
    static int count =0; //연결이 없는 노드를 파악하기 위한 변수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //출력값을 저장할 변수
        int result = 0;

        for(int i = 0; i<M; i++){ //간선수만큼 반복
            st = new StringTokenizer(br.readLine());//한줄씩 읽어들이고
            int u = Integer.parseInt(st.nextToken());//u와 v는 연결된것
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = 1; //두 정점을 서로 연결 1로 표현
        }

        for(int i = 1; i<=N; i++){ //노드수만큼 반복
            dfs(i);

            if(CC != 0){//CC는 그룹에 노드가 들어왔는지 확인, 0이 아니라면 그룹에 노드가 있다는 뜻
                result ++; //그룹수를 +1해준다
            }
            if(count == N){//count는 연결된 노드가 없는지 파악하기 위한것. count가 N정점개수와 같다면 연결된 정점이 없다는 뜻
                result ++; //이 노드 자체를 그룹 하나로 쳐줘야함
            }
            CC = 0;
            count = 0;//확인이 끝나면 CC와 count를 0으로 초기화시키기
        }
        System.out.println(result);
    }

    public static void dfs(int node){
        visit[node] = true;//node를 입력받으면 일단 방문 표시

        //방문한 노드부터 연결되어있는지 전체 노드 확인
        for(int i = 1; i<=N; i++){
            if(!visit[i] && graph[node][i] == 1){//방문한 적이 없는 노드 이면서 현재 노드와 연결되어 있는 정점이라면
                dfs(i);
                CC++; //그룹에 노드가 들어왔는지 확인, 노드가 들어왔다면 +1
                count = 0;
            }
            if(graph[node][i] == 0){//현재 노드와 연결된 간선이 없다면?
                count ++; //연결된 노드가 없는지를 파악하기 위해
            }
        }
    }
}