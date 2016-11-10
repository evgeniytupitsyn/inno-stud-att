package ru.innopolis.uni.course2.reflect;

import java.lang.reflect.*;

/**
 * Created by evgeniytupitsyn on 08/11/2016.
 */
public class Main {

    public static void main(String[] arg) throws IllegalAccessException, InvocationTargetException, InstantiationException {
 /*       Human human = new Human();
        Class<Human> humanClass = (Class<Human>) human.getClass();
        Field[] fields = humanClass.getDeclaredFields(); // вернёт все поля, у которых есть доступ (не private)


        Field money = fields[0];
        money.setAccessible(true);
        money.set(human, 50);

        Field name = fields[1];
        name.setAccessible(true);
        name.set(human, "John");

        System.out.println(humanClass);


        ///
        Constructor[] constructors = humanClass.getConstructors();
        Object o = constructors[0].newInstance();
        System.out.println(humanClass);
*/

///v2 start
        Object proxy = Proxy.newProxyInstance(Main.class.getClassLoader(),
                new Class[]{InterfaceOne.class},
                new InvocationHandler() {
                    private InterfaceOneImpl interfaceOne = new InterfaceOneImpl(); //реализация реального интерфейса
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("logging" + args[0]);
                        return method.invoke(interfaceOne, args);
                    }

                    //private InterfaceOneImpl interfaceOne = new InterfaceOneImpl();
                }
        );
    InterfaceOne one = (InterfaceOne) proxy;
        one.doSome(5);
        System.out.println(proxy);

///v2 end
    }
}
