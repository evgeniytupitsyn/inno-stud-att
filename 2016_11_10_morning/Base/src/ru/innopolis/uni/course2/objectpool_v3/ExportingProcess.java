package ru.innopolis.uni.course2.objectpool_v3;

/**
 * Created by evgeniytupitsyn on 08/11/2016.
 */
public class ExportingProcess {
    private long processNo;

    public ExportingProcess(long processNo)  {
        this.processNo = processNo;
        // do some  expensive calls / tasks here in future
        // .........
        System.out.println("Object with process no. " + processNo + " was created");
    }

    public long getProcessNo() {
        return processNo;
    }
}// End of the ExportingProcess class.
