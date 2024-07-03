import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] max = new int[N];//각 자리수의 최대값
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++){
			max[i] = Integer.parseInt(st.nextToken());
		}
	
		int[] num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<num.length; i++){
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());		
		int K = Integer.parseInt(st.nextToken());
		
		int index = N-1;
		for(int i = 0; i < K; i++){
			if(num[index] < max[index]){
				num[index]++;
			}
			else{
				while(index >= 0 && num[index] == max[index]){
					num[index] = 0;
					index --;
				}
				if(index >= 0){
					num[index]++;
				}
				index = N-1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n : num){
			sb.append(n);
		}
		System.out.println(sb);
	}
}