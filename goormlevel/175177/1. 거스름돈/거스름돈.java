import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0; //동전 개수
		
		while(N != 0){
			if(N >= 40){
				answer += (int)N / 40;
				N = N % 40;
			}
			else if(N >= 20){
				answer += (int)N / 20;
				N = N % 20;				
			}
			else if(N >= 10){
				answer += (int)N / 10;
				N = N % 10;
			}
			else if(N >= 5){
				answer += (int)N / 5;
				N = N % 5;
			}
			else if(N >= 1){
				answer += (int)N / 1;
				N = N % 1;
			}
		}
		System.out.println(answer);
	}
}