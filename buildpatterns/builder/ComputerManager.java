package ru.innopolis.uni.course2.buildpatterns.builder;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class ComputerManager {

    private ComputerBuilder computerBuilder;

    public ComputerManager(ComputerBuilder computerBuilder){
        this.computerBuilder = computerBuilder;
    }

    public Computer buildComputer(){
        this.computerBuilder.buildNewComputer();
        this.computerBuilder.buildMotherBoard();
        this.computerBuilder.buildCPU();
        this.computerBuilder.buildRAM();
        this.computerBuilder.buildHDD();
        return this.computerBuilder.getComputer();
    }
}
