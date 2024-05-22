import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        int n=10;
        int ctr = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        if(stack.contains(1)){
            System.out.println("Present");
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.add(2);
        System.out.println(queue.peek());
        int arr = ((ArrayDeque<Integer>) queue).peekLast();
        System.out.println(arr);

//        for(int i =0 ; i< n ; i++){
//            if(!check(i)){
//                i--;
//            }
//            System.out.println(ctr);
//        }
    }
    public static boolean check(int n){
        return n==3;
    }
}
