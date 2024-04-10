import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> list = new LinkedList<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 1; i<=n; i++){
            list.add(i);
        }

        sb.append("<");
        while(!list.isEmpty()){
            for(int i = 0; i <= k-1; i++){
                if(i == k-1){
                    sb.append(list.remove());
                    if(list.size() >= 1){
                        sb.append(", ");
                    }
                }
                else{
                    list.add(list.remove());
                }
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}