import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[] n = new int[N];
        for (int i = 0; i < N; i++) {
            n[i] = sc.nextInt();
        }
        Arrays.sort(n);
        int M = sc.nextInt();
        int[] m = new int[M];
        for (int i = 0; i < M; i++) {
            m[i] = sc.nextInt();
            sb.append(BinarySearch(n, m[i])).append("\n");
        }
        System.out.println(sb);
    }
    static int BinarySearch(int[] n, int key){
        int low = 0;
        int high = n.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(n[mid] < key){
                 low = mid+1;
            }
            else if(n[mid] == key){
                return 1;
            }
            else{
                high = mid-1;
            }
        }
        return 0;
    }
}