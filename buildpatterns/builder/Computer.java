package ru.innopolis.uni.course2.buildpatterns.builder;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class Computer {

    private final String CPU;
    private final String motherBoard;
    private final String RAM;
    private final String HDD;
    private final String OS;

    public Computer(Builder builder){
        this.motherBoard = builder.motherBoard;
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.HDD = builder.HDD;
        if(builder.OS != null)
            this.OS = builder.OS;
        else
            this.OS = "Linux";

    }

    public String getCPU() {
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
                .append(CPU).append(" | ")
                .append(RAM).append(" | ")
                .append(HDD).append(" | ").append(OS).toString();
    }

    public static class Builder{
        private String CPU;
        private String motherBoard;
        private String RAM;
        private String HDD;
        private String OS;


        public Builder(){}

        public Builder withMotherBoard(String motherBoard){
            this.motherBoard = motherBoard;
            return this;
        }

        public Builder withCPU(String CPU){
            this.CPU = CPU;
            return this;
        }

        public Builder withRAM(String RAM){
            this.RAM = RAM;
            return this;
        }

        public Builder withHDD(String HDD){
            this.HDD = HDD;
            return this;
        }

        public Builder withOS(String OS){
            this.OS = OS;
            return this;
        }
    }
}
