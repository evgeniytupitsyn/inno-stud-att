package ru.innopolis.uni.course2.buildpatterns.builder;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class Main {

    public static void main(String[] args) {
       /* ComputerManager computerManager = new ComputerManager(new IntelComputerBuilder());
        System.out.println(computerManager.buildComputer());*/

       Computer.Builder builder = new Computer.Builder().withMotherBoard("Intel")
               .withCPU("Intel").withRAM("Intel").withHDD("Intel");
        System.out.println(new Computer(builder));


    }
}
