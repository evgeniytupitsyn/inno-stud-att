package innopolis.uni.course2.java8;

/**
 * Created by evgeniytupitsyn on 06/12/2016.
 */
public interface FunctionalInterface {
    public void doSome();

    public int hashCode();

    default void doSomeDefault(){
        int i = hashCode();
        System.out.println(i);
    }
}
