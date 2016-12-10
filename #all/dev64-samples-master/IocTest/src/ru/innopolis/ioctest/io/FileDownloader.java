package ru.innopolis.ioctest.io;

/**
 * Created by evgeniytupitsyn on 24/11/2016.
 */
/**
 * Created by d.sapaev on 28.10.2016.
 */
@Component
public class FileDownloader implements Downloader {
    public String download(String path) {
        System.out.println(new StringBuilder("Resource from path ")
                .append(path)
                .append(" was downloaded!")
                .toString());

        return "CoNtEnT";
    }
}