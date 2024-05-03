import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] countNum = new int[10];
        long total = 0;//자릿수의 합
        for(int i =0; i<str.length(); i++){
            int num = Integer.parseInt(str.substring(i, i+1)); //문자를 정수형으로 변환
            countNum[num] += 1;
            total += num;//입력받은 숫자들의 합 구하기
        }
        if(!str.contains("0") || total % 3 !=0){
            System.out.println(-1);
            return; //끝내기
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i>=0; i--){//거꾸로 세기
            while(countNum[i] > 0){//countNum[i]의 값이 0이 될때까지 반복한다.
                sb.append(i);
                countNum[i]--;//한번출력할때마다 값은 줄어든다. 개수만큼 모두 숫자를 출력한다.
            }
        }
        System.out.println(sb);
    }
}