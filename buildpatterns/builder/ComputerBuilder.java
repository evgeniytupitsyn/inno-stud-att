package ru.innopolis.uni.course2.buildpatterns.builder;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public abstract class ComputerBuilder {

    protected Computer computer;

    public abstract void buildNewComputer();
    public abstract void buildMotherBoard();
    public abstract void buildCPU();
    public abstract void buildRAM();
    public abstract void buildHDD();

    public Computer getComputer(){
        return this.computer;
    }
}
