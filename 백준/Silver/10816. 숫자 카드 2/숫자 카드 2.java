import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for(int i =0; i<N; i++){
            int n = sc.nextInt();
            if(map.get(n) == null){
                map.put(n, 1);
            }
            else{
                map.put(n, map.get(n)+1);
            }
        }
        int M = sc.nextInt();
        for(int i =0; i<M; i++){
            int m = sc.nextInt();
            if(map.containsKey(m)){
                sb.append(map.get(m)).append(' ');
            }
            else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
