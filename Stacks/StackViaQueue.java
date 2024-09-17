import java.util.LinkedList;
import java.util.Queue;

class StackViaQueue {
    Queue<Integer> q;

    public StackViaQueue() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {

        StackViaQueue obj = new StackViaQueue();
        obj.push(10);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2 + " " + param_3 + " " + param_4);

    }
}
