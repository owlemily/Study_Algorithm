import java.util.Scanner;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt(); //테스트 케이스 개수
        while(T-- > 0){
            int N = sc.nextInt();//문서의 개수
            int M = sc.nextInt();//몇번째로 인쇄되었는지 알고싶은 인덱스 번호
            LinkedList<int[]> q = new LinkedList<>(); //테스트케이스 진행 횟수마다 큐를 생성

            for(int i = 0; i < N; i++){
                q.offer(new int[] {i, sc.nextInt()});
            }

            int count = 0; //M이 몇번째로 인쇄되었는지 카운트

            while(!q.isEmpty()){//한 테스트케이스에 대해 반복
                int[] front = q.poll();//가장 첫 원소
                boolean isMax = true; //front 원소가 가장큰지 판단

                //큐에 남아있는 원소들과 중요도 비교하기때문에 q사이즈만큼 반복
                for(int i = 0; i < q.size(); i++){
                    if(front[1] < q.get(i)[1]){
                        q.offer(front);
                        for(int j = 0; j < i; j++){
                            q.offer(q.poll());
                        }

                        isMax = false;//front원소가 가장 크지 않아서 false
                        break;
                    }
                }

                //front 원소가 가장 큰 원소가 아니니 다음 반복문으로 넘어간다.
                if(isMax == false){
                    continue;
                }
                //front 원소가 가장 큰 원소면, 출력해야하므로 카운트 올려줌
                count++;
                if(front[0] == M){//front의 인덱스가 M과 같으면 그만세도된다.
                    break;
                }

            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}