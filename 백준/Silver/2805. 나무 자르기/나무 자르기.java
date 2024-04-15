import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int min = 0;//최소 나무 길이
        int max = 0;//최대 나무 길이
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if(max < arr[i]){
                max = arr[i];
            }
        }//나무 길이 입력 완료

        while(min < max){
            int mid = (min + max)/2; //중간나무길이 -> 자를 높이H
            long sum = 0; //가져갈 수 있는 나무길이 M
            for(int i : arr){
                if(i - mid > 0){
                    sum += (i - mid);
                }
            }
            if(sum < M){ //sum<M //너무 H가 높다. mid 낮춰야한다.
                max = mid;
            }
            else{//너무 H가 낮다. mid를 높여야한다.
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}