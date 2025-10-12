package homework5;

public class Stack {
    private char[] array = new char[1000];
    private int size = 0;

    public void push(char c) {
        array[size++] = c;
    }
    public char pop() {
        if (isEmpty()) {
    return'\0';
        }
        return array[--size];
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
