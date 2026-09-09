class Stack{
    private int[] arr;
    private int top;

    Stack(int size){
        arr = new int[size];
        top = -1;
    }

        void push(int value){
        if(top == arr.length - 1){
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = value;
    }

    int pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    int peek(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    void display(){
        if(top == -1){
            System.out.println("Stack is empty");
            return;
        }
        for(int i = top; i >= 0; i--){
            System.out.println(arr[i] );
        }
        //System.out.println();
    }


}

class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display(); // Output: 30 20 10
        System.out.println();
        System.out.println("Top element is: " + stack.peek()); // Output: Top element is: 30
        System.out.println("Popped element is: " + stack.pop()); // Output: Popped element is: 30
        stack.display(); // Output: 20 10
    }
}