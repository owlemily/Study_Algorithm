import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pain = Integer.parseInt(br.readLine());
		int answer = 0;
		
		while(pain != 0){
			if(pain >= 14){
				answer += (int)pain/14;
				pain %= 14;
			}
			else if(pain >= 7){
				answer += (int)pain/7;
				pain %= 7;
			}
			else if(pain >= 1){
				answer += (int)pain/1;
				pain %= 1;
			}
		}
		
		System.out.println(answer);
	}
}