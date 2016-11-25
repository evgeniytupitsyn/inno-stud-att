package ru.innopolis.uni.course2.buildpatterns.builder;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class IntelComputerBuilder extends ComputerBuilder{
    @Override
    public void buildNewComputer() {
        this.computer = new Computer(null);
    }

    @Override
    public void buildMotherBoard() {
        //this.computer.setMotherBoard("Intel");
    }

    @Override
    public void buildCPU() {
        //this.computer.setCPU("Intel");
    }

    @Override
    public void buildRAM() {
        //this.computer.setRAM("Intel");
    }

    @Override
    public void buildHDD() {
       // this.computer.setHDD("Intel");
    }
}
