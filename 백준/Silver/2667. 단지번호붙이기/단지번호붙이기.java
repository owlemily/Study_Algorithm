import java.util.*;
import java.io.*;
public class Main {
    static int arr[][];
    static boolean visit[][];
    static int dirX[] = {0,0,-1,1};
    static int dirY[] = {-1, 1, 0, 0};

    static int count = 0;
    static int number = 0;
    static int nowX, nowY, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }//input입력

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == false && arr[i][j] == 1) {//방문하지 않았고, arr에서 1인 곳을 만날경우 DFS()가 실행되도록 하면 arr전체를 탐색할 수 있다
                    count = 0;
                    number++;
                    dfs(i, j);
                    list.add(count);//list는 집 숫자를 정하기 위한 것
                }
            }
        }
        Collections.sort(list);
        bw.append(number + "\n");
        for(int num : list){
            bw.append(num+"\n");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int x, int y){
        visit[x][y] = true;
        arr[x][y] = number;
        count ++;

        for(int i =0; i<4; i++){
            nowX = dirX[i] + x;
            nowY = dirY[i] + y;

            if(Range_check() && visit[nowX][nowY] == false && arr[nowX][nowY] == 1){
                visit[nowX][nowY] = true;
                arr[nowX][nowY] = number;

                dfs(nowX, nowY);
            }
        }
    }
    static boolean Range_check(){
        return(nowX>=0 && nowX < N && nowY >=0 && nowY < N);

    }


}