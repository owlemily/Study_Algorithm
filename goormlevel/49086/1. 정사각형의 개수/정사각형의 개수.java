import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// 원하는 격자판 크기로 변경하세요
        long N = sc.nextInt();
				System.out.println(countSquares(N));
    }

    public static long countSquares(long N) {
        long total = 0;
				for(long i =1; i <= N; i++){
					total += i*i;
				}
			return total;
    }
}

