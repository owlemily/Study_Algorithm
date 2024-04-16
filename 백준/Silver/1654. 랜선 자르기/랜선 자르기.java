import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long low = 0;
        long high = 0;

        for(int i = 0; i< K; i++){//K 길이들 입력 받기
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st2.nextToken());
            if(arr[i] > high){
                high = arr[i];
            }
        }
        high ++;
        while(low < high){
            long mid = (low+high) / 2;
            long count = 0;
            for(int i = 0; i<K; i++){
                count += arr[i] / mid;
            }
            if(count < N){ //mid낮추어야함
                high = mid;
            }
            else{ //mid를 높여야함
                low = mid+1;
            }
        }
        System.out.println(low-1);
    }
}