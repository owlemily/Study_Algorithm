import java.io.*;
import java.util.*;
class Main {
	public static boolean possible(int y, int x, int n){
			if(y > 0 && y <= n && x > 0 && x <= n){
				return true;
			}
			else{
				return false;
			}
		}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] ground = new char[N+1][N+1];
		int[][] bomb = new int[N+1][N+1];
		
		int[] dx = new int[]{-1, 1, 0, 0};//좌우상하
		int[] dy = new int[]{0, 0, -1, 1};
		
		for(int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine());//한줄 읽어오는 위치 조심
			for(int j = 1; j <= N; j++){
				ground[i][j] = st.nextToken().charAt(0);//공백으로 분리 //각 땅 값 저장
			}
		}
		
		//폭탄 실행
		for(int i = 0; i < K; i++){//K번 폭탄
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if(ground[y][x] == '0'){
				bomb[y][x] += 1;
			}
			else if(ground[y][x] == '@'){
				bomb[y][x] += 2;
			}
			
			//폭탄 떨어진 좌표 근처 실행
			for(int j = 0; j < 4; j++){
				int tempX = x + dx[j];
				int tempY = y + dy[j];
				if(possible(tempY, tempX, N)){//이동한값이 범위안에 있다면(true라면)
					if(ground[tempY][tempX] == '0'){
						bomb[tempY][tempX] += 1;
					}
					else if(ground[tempY][tempX] == '@'){
						bomb[tempY][tempX] += 2;
					}
				}
			}
		}
		
		//최대값 정답 출력하기
		int answer = 0;
		for(int i = 1; i <= N; i++){//인덱스 주의 -> 1부터 N까지 한다
			for(int j = 1; j <= N; j++){
				answer = Math.max(answer, bomb[i][j]);
			}
		}
		System.out.println(answer);
	}
}