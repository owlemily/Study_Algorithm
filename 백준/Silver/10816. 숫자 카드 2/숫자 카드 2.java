import java.util.Arrays;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int key = sc.nextInt();
            sb.append(upperBound(arr, key)-lowerBound(arr, key)).append(" ");
        }
        System.out.println(sb);
    }

    static int lowerBound(int[] arr, int key){
            int low = 0;
            int high = arr.length;

            while(low< high){
                int mid = (low+high)/2;
                if(key <= arr[mid]){
                    high = mid;
                }
                else{
                    low = mid+1;
                }
            }
            return low;
    }

    static int upperBound(int[] arr, int key){
            int low = 0;
            int high = arr.length;

            while(low < high){
                int mid = (low+high)/2;
                if(key < arr[mid]){
                    high = mid;
                }
                else{
                    low = mid+1;
                }
            }
            return low;
    }

}
