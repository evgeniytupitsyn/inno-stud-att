import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
    private static int LOOP_COUNT = 1_000_000;
    public static void main(String[] args) throws InterruptedException {
        try(Scanner scanner = new Scanner(System.in)){
            while(scanner.hasNext()){
                createObject();
                scanner.next();
            }
        }

    }

    static Object createObject() throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < LOOP_COUNT; i++) {
            Random r = new Random();
            String s = r.nextInt() + "" + i;
            list.add(s);
        }
        return list;
    }

}

/*
public class Main {
    private static int LOOP_COUNT = 100_000_000;
    public static void main(String[] args) throws InterruptedException {
        try{
            Scanner scanner = new Scanner(System.in)

        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < LOOP_COUNT; i++) {
            Random r = new Random();
            String s = r.nextInt() + "" + i;
            list.add(s);
            System.out.println(s);
        }
        System.out.println(list.size());
    }
*/


/*
    public static void main(String[] args) {
         System.out.println("Hello World!");
    }
}*/
