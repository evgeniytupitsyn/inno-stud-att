/**
 * Created by evgeniytupitsyn on 09/11/2016.
 */
package com.example;

import com.example.constants.Constants;
import com.example.resource.Resource;
import com.example.resource.ResourceFactory;
import org.apache.log4j.Logger;
import com.example.library.Simple;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.example.constants.Constants.DICTIONARY;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.DEBUG;

/**
 * Точка входа в приложение.
 * @see com.example.resource.Resource
 */
public class Main {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger("com.example");

    /**
     * Метод последовательно перебирает все полученные параметры и создаёт ресурсы нужных типов.
     * Затем запускаются нити, в которых ресурсы обрабатываются.
     * @param args Массив строковых параметров, содержащих либо имена файлов, либо пути к файлам, либо строки текста.
     *             Передаётся в метод с помощью командной строки.
     * @see com.example.resource.Resource
     */
    public static void main(String[] args) {

        if(DEBUG){
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

            resource = ResourceFactory.createResourceWithParam(arg);

            Callable<Integer> checker = new DuplicateChecker(resource);
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

        if (DuplicateChecker.isStopped()){
            logger.info("Приложение остановлено.");
        } else if (DuplicateChecker.foundDuplicate()) {
            logger.info("Найдено повторяющееся слово. Проанализировано {} {}.", DICTIONARY.size(), wordCase);
        } else {
            logger.info("Повторяющиеся слова не найдены. Проанализировано {} {}.", DICTIONARY.size(), wordCase);
        }

        if (Constants.DEBUG){
            logger.debug("Итоговый словарь: {}", DICTIONARY.toString());
        }

    }
}