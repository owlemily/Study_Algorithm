import java.io.*;
import java.util.*;
class Main {
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static int answer = 0;
	//bfs함수 정의
	public static int dfs(int x){
		visited[x] = true;//현재 노드 방문처리
		answer ++;
		//x노드와 연결된 노드를 재귀적으로 처리
		for(int i = 0; i<list.get(x).size(); i++){
			if(visited[list.get(x).get(i)]==false){//x와 연결된 것들을 방문하지 않았으면
				dfs(list.get(x).get(i));//재귀적으로 방문해라.
			}
		}
		return answer;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());//N과 M은 서로 다른 줄이기 때문에 br.readLine()으로 해줄 것
		int M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];//1부터 넣기 때문에 크기는 N+1이 되어야한다.
		
		//리스트 초기화
		for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
    }
		
		for(int i = 0; i < M; i++){//M개의 관계 정의
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		System.out.println(dfs(1));
	}
}