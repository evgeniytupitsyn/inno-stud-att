
package ru.innopolis.uni.course2.classloader;

import java.io.File;
import java.util.Scanner;


/**
 * Created by evgeniytupitsyn on 15/11/2016.
 */

public class Main {

    public static void main(String[] args) {

        File pathOut = new File("./test_compile_class");

        Scanner scanner = new Scanner(System.in);
        MyClassLoader myClassLoader;
        while (true) {
            System.out.println("Enter class name or exit: ");
            String name = scanner.nextLine();
            if (name.equals("exit")) {
                break;
            }
            System.out.println("Enter source inline: ");
            String source = scanner.nextLine();
            System.out.println("compile");
            try {
                myClassLoader = new MyClassLoader(Main.class.getClassLoader(), (pathOut).getAbsolutePath()+"/");

                CompileSource.doCompilation(pathOut, source, name);

                System.out.println("find class");
                Class clazz = myClassLoader.loadClass(name);
                System.out.println("new instance of class");
                Executable object = (Executable) clazz.newInstance();
                System.out.println("Enter arguments for execute class:");
                String[] argsForObject = scanner.nextLine().split(" ");
                System.out.println("execute");
                object.execute(argsForObject);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

