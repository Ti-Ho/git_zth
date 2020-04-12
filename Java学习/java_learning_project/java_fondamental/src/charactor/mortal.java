package charactor;

public interface mortal {
    default void die(){
        System.out.println("die");
    }
}
