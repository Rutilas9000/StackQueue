import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SplitStack {

    public static void modify(Stack<Integer> s){
        Queue<Integer> t = new LinkedList<Integer>();
        int count = 0;
        while(s.size() != 0){
            Integer temp = s.pop();
            t.add(temp);
            if(temp.intValue() < 0){
                count++;  // count non neg ints
            }
        }
        while(t.size() != 0){
            Integer temp = t.remove();
            if(temp.intValue() >= 0){
                if(s.size() >= count){
                    s.push(temp);
                }
                else{
                    t.add(temp);

                }
            }
            else{
                s.push(temp);
            }
        }
    }

    public static void main(String args[]){
        Stack<Integer> s = new Stack<Integer>();

        s.push(5);
        s.push(-5);
        s.push(67);
        s.push(-45);
        s.push(67);
        s.push(9);
        s.push(0);
        s.push(-42);
        s.push(56);
        s.push(-7);
        System.out.println(s);
        modify(s);
        System.out.println(s);

    }
}