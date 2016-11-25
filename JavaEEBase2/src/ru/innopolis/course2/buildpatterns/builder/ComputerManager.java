package ru.innopolis.course2.buildpatterns.builder;

/**
 * Created by evgeniytupitsyn on 21/11/2016.
 */
public class ComputerManager {

    private ComputerBuilder computerBuilder;

    public ComputerManager (ComputerBuilder computerBuilder){
        this.computerBuilder = computerBuilder;
    }

    public Computer buildComputer(){
        this.computerBuilder.buildNewComputer(); //появится new computer
        this.computerBuilder.buildMotherBoard(); //появится new
        this.computerBuilder.buildCPU(); //появится new
        this.computerBuilder.buildRAM(); //появится new
        this.computerBuilder.buildHDD(); //появится new

        return this.computerBuilder.getComputer();
    }
}
