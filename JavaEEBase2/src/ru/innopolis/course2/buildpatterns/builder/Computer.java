package ru.innopolis.course2.buildpatterns.builder;

/**
 * Created by evgeniytupitsyn on 21/11/2016.
 */
public class Computer {
    private final String CPU;
    private final String motherBoard;
    private final String RAM;
    private final String HDD;

    private final String OS = null;

    private String GPU;

    public Computer(Builder builder){
        this.motherBoard = builder.motherBoard;
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.HDD = builder.HDD;
       // if (builder.OS != null)
    }
    /*public Computer(String CPU, String motherBoard, String RAM, String HDD){
        this.CPU = CPU;
        this.motherBoard = motherBoard;
        this.RAM = RAM;
        this.HDD = HDD;
    }*/

    public String getCPU() {
        //this.CPU = CPU;
        return CPU;
    }

    public String getMotherBoard() {
        return motherBoard;
    }

    public String getRAM() {
        return RAM;
    }

    public String getHDD() {
        return HDD;
    }


    public String toString(){
        return new StringBuilder(motherBoard).append(" | ")
                .append(CPU).append ("|")
        .append(motherBoard).append ("|")
        .append(RAM).append ("|")
        .append(HDD).toString();
    }

    //v2



    public static class Builder{
        private String CPU;
        private String motherBoard;
        private String RAM;
        private String HDD;

        public Builder(){}

        public void withMotherBoard(String motherBoard){
            this.motherBoard = motherBoard;
        }

        public void withCPU(String CPU){
            this.motherBoard = motherBoard;
        }

        public void withRAM(String RAM){
            this.motherBoard = motherBoard;
        }

        public void withHDD(String HDD){
            this.motherBoard = motherBoard;
        }

        public void withOS(String OS){
            this.motherBoard = motherBoard;
        }
    }
}
