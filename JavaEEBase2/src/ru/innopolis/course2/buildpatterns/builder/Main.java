package ru.innopolis.course2.buildpatterns.builder;

/**
 * Created by evgeniytupitsyn on 21/11/2016.
 */
public class Main {

    public static void main(String[] args){
        /*ComputerManager computerManager = new ComputerManager((new IntelComputerBuilder()));
        System.out.println(computerManager.buildComputer());*/

        //v2
        Computer.Builder builder = new Computer.Builder();
            builder.withMotherBoard("Intel");
            builder.withCPU("Intel");
            builder.withRAM("Intel");
            builder.withHDD("Intel");
        System.out.println(new Computer(builder));
    }
}
