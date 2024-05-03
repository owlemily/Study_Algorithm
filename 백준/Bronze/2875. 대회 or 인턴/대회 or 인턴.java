import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //여학생수
        int M = sc.nextInt(); //남학생수
        int K = sc.nextInt(); //인턴쉽 가야하는 학생수
        int team = 0;
        while(N>=2 && M>=1 && N+M-K>=3){
            N = N-2;
            M = M-1;
            team += 1;
        }
        System.out.println(team);
    }
}