package com.example;

import com.example.constants.Constants;
import com.example.resource.FarmResource;
import com.example.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.*;

import static com.example.FindDuplicates.DICTIONARY;

/**
 * Точка входа в приложение.
 * @see Resource
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger("com.example");

    /**
     * Метод последовательно перебирает все полученные параметры и создаёт ресурсы нужных типов.
     * Затем запускаются нити, в которых ресурсы обрабатываются.
     * @param args Массив строковых параметров, содержащих либо имена файлов, либо пути к файлам, либо строки текста.
     *             Передаётся в метод с помощью командной строки.
     * @see Resource
     */
    public static void main(String[] args) {

        if(Constants.DEBUG){
            logger.debug("Начало работы");
        }

        if (args.length == 0){
            logger.info("У программы не заданы аргументы. Работа завершена.");
            return;
        }

        ExecutorService service = Executors.newFixedThreadPool(args.length);
        Collection<Callable<Integer>> duplicateCheckers = new ArrayList<>();

        for (String arg : args) {
            Resource resource;

            resource = FarmResource.createResourceWithParam(arg);

            Callable<Integer> checker = new FindDuplicates(resource);
            duplicateCheckers.add(checker);
        }

        try {
            service.invokeAll(duplicateCheckers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();

        String wordCase;
        if (DICTIONARY.size() % 10 == 1 && DICTIONARY.size() % 100 != 11){
            wordCase = "слово";
        } else if (DICTIONARY.size() % 10 > 1 && DICTIONARY.size() < 5){
            wordCase = "слова";
        } else {
            wordCase = "слов";
        }

        if (FindDuplicates.isStopped()){
            logger.info("Приложение остановлено.");
        } else if (FindDuplicates.foundDuplicate()) {
            logger.info("Одно из слов повторяется минимум 5 раз. Проанализировано {} различных {}.", DICTIONARY.size(), wordCase);
        } else {
            logger.info("Повторяющиеся слова не найдены. Проанализировано {} {}.", DICTIONARY.size(), wordCase);
        }

        if (Constants.DEBUG){
            logger.debug("Итоговый словарь: {}", DICTIONARY.toString());
        }

    }
}
