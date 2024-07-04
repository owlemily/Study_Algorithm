import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		//2차원배열 숫자 입력
		int[][] num = new int[N+1][N+1];
		for(int i = 1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<N+1; j++){
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//삼각형 꼭짓점		
		for(int i = 1; i<Q+1; i++){
			int sum = 0;//삼각형 내 값들 더하기
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			
			//삼각형의 꼭짓점의 사이 좌표들을 구한다.
			int minY = Math.min(Math.min(y1, y2), y3);
			int maxY = Math.max(Math.max(y1, y2), y3);
			int minX = Math.min(Math.min(x1, x2), x3);
			int maxX = Math.max(Math.max(x1, x2), x3);
			for(int y = minY; y <= maxY; y++){
				for(int x = minX; x <=maxX; x++){
					if(inTriangle(y1, x1, y2, x2, y3, x3, y, x)){//삼각형 안에 있는가?
						sum += num[y][x];
					}
				}
			}
			//sum -= num[y1][x1] + num[y2][x2] + num[y3][x3]; //삼각형 꼭짓점은 한번만 더해야한다.
			System.out.println(sum);
		}
	}
	
	// 벡터 외적을 이용해 삼각형 내부에 해당 점이 있는지 판별하는 함수
    static boolean inTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int px, int py) {
        int d1 = direction(px, py, x1, y1, x2, y2);
        int d2 = direction(px, py, x2, y2, x3, y3);
        int d3 = direction(px, py, x3, y3, x1, y1);
        return (d1 == 0 || d1 > 0) && (d2 == 0 || d2 > 0) && (d3 == 0 || d3 > 0) || 
               (d1 == 0 || d1 < 0) && (d2 == 0 || d2 < 0) && (d3 == 0 || d3 < 0);
    }

    // 벡터 외적을 계산하여 점이 어느 쪽에 있는지 판별하는 함수
    static int direction(int px, int py, int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (py - y1) - (y2 - y1) * (px - x1);
    }
}