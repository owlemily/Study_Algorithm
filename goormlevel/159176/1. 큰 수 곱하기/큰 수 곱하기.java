import java.io.*;
import java.util.StringTokenizer;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger answer = BigInteger.ONE;
		for(int i = 0; i<10; i++){
			BigInteger num = new BigInteger(st.nextToken());
			answer = answer.multiply(num);
		}
		
		System.out.println(answer);
	}
}