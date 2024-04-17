import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] sorted = new int[N];
        for(int i = 0; i < N; i++){
            sorted[i] = arr[i] = sc.nextInt();
        }
        Arrays.sort(sorted);
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : sorted){
            if(!map.containsKey(a)){
                map.put(a, index);
                index++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int a : arr){
            sb.append(map.get(a));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
