package Stack;

import java.util.Arrays;

public class stackUsingArray {

    private int top;

    private int[] arr = new int[5];

    public stackUsingArray() {
        this.top = -1;
        Arrays.fill(this.arr, -1);
    }

    public void push(int val) {
        if (top == arr.length - 1){         //overflow
            System.out.println("Stack is full(Stack Overflow) element is not added to stack");
            return;
        }
            
        arr[++top] = val;
    }

    public int pop() {
        if (top == -1) //underflow
            return -1;
        int temp = arr[top];
        arr[top] = -1;
        --top;
        return temp;
    }

    public void display() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        stackUsingArray st = new stackUsingArray();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.display();
        st.push(50);
        st.push(60);
        st.display();

        System.out.println("poped element : " + st.pop());
        System.out.println("poped element : " + st.pop());
        st.display();

    }
}
