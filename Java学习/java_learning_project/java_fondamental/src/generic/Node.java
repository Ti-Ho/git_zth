package generic;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    public Node<T> left;
    public Node<T> right;
    public T value;

    public void add(T t){
        if(null == value)
            value = t;
        else{
            if((Integer)t - ((Integer)value) <= 0){
                if(left == null)
                    left = new Node<T>();
                left.add(t);
            }else{
                if(right == null)
                    right = new Node<T>();
                right.add(t);
            }
        }
    }
    //中序遍历所有节点
    public List<T> values(){
        List<T> values = new ArrayList<>();
        if(left != null) values.addAll(left.values());
        values.add(value);
        if(right != null) values.addAll(right.values());
        return values;
    }

    public static void main(String args[]){
        int random[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
        Node<Integer> root = new Node<>();
        for(int i : random){
            root.add(i);
        }
        System.out.println(root.values());
    }
}
