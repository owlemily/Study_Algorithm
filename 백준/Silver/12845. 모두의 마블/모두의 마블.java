import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());//n을 입력받는다
        String[] arr = br.readLine().split(" ");//카드의 레벨 배열로 입력받기

        int max = 0; //카드 레벨의 최댓값
        int sum = 0; //골드의 합 저장하기
        //max를 찾아보자
        for(int i = 0; i<n; i++){
            int L = Integer.parseInt(arr[i]);
            sum += L;//모든 카드의 합을 구한다.
            if(L> max){
                max = L; //max를 구한다.
            }

        }
        int result = sum + max * (n-2);
        System.out.println(result);

    }
}