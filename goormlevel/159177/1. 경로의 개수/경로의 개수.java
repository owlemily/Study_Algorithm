import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long answer = 1;
		for(int i = 0; i<N; i++){
			answer *= Long.parseLong(st.nextToken());
		}
		System.out.println(answer);
	}
}