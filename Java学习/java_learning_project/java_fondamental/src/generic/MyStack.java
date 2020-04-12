package generic;

import charactor.Hero;
import charactor.Item;

import java.util.LinkedList;

public class MyStack <T>{
    LinkedList<T> stk = new LinkedList<>();
    public void push(T t){
        stk.addLast(t);
    }
    public T pull(){
        return stk.removeLast();
    }
    public T peek(){
        return stk.getLast();
    }
    public static void main(String args[]){
        MyStack<Hero> heroStack = new MyStack<>();
        heroStack.push(new Hero());
        MyStack<Item> itemStack = new MyStack<>();
        itemStack.push(new Item());
    }
}
