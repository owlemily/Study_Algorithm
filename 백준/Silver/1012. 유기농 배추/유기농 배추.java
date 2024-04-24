import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

   static int M;
   static int N;
   static int K;
   static int map[][];
   static int[] dx = {0, 0, -1, 1};
   static int[] dy = {-1, 1, 0, 0};
   static boolean[][] visit;
   static int count;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      StringTokenizer st;

      for (int i = 0; i < T; i++) {
         count = 0;
         st = new StringTokenizer(br.readLine());

         M = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());
         map = new int[M][N];
         visit = new boolean[M][N];

         for (int j = 0; j < K; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
         }

         for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
               if (map[j][k] == 1 && !visit[j][k]) {
                  dfs(j, k);
                  count++;
               }
            }
         }
         System.out.println(count);

      }

   }

   public static void dfs(int x, int y) {
      visit[x][y] = true;
      for (int i = 0; i < 4; i++) {
         int next_x = x + dx[i];
         int next_y = y + dy[i];
         if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N) {
            if (map[next_x][next_y] == 1 && !visit[next_x][next_y]) {
               dfs(next_x, next_y);
            }
         }
      }
   }

}
