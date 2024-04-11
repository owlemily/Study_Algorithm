import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());

    for (int i = 0; i < count; i++) {
      boolean succeed = true;
      String[] split = br.readLine().split("");
      Stack<String> stack = new Stack<>();
      for (int j = 0; j < split.length; j++) {
        if (split[j].equals("(")) {
          stack.push("(");
        } else {
          if (stack.size() > 0) {
            stack.pop();
          } else {
            succeed = false;
            break;
          }
        }
      }

      if (stack.size() > 0 || !succeed) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
      }
    }
  }

}