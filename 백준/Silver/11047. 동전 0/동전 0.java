import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int count = 0; //동전 개수세기

        for(int i = N-1; i>=0; i--){
            if (arr[i] <= K) {
                count += (K / arr[i]);
                K = K % arr[i];
            }

        }
        System.out.println(count);
    }
}