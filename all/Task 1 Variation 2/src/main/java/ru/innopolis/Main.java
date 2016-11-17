package ru.innopolis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.resources.Resource;
import ru.innopolis.resources.ResourceFactory;

import java.util.*;
import java.util.concurrent.*;

import static ru.innopolis.constants.Constants.*;

/**
 * Точка входа в приложение.
 * @see ru.innopolis.resources.Resource
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger("ru.innopolis");

    /**
     * Метод последовательно перебирает все полученные параметры и создаёт ресурсы нужных типов.
     * Затем запускаются нити, в которых ресурсы обрабатываются.
     * @param args Массив строковых параметров, содержащих либо имена файлов, либо пути к файлам, либо строки текста.
     *             Передаётся в метод с помощью командной строки.
     * @see ru.innopolis.resources.Resource
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

        if (DEBUG){
            logger.debug("Итоговый словарь: {}", DICTIONARY.toString());
        }

    }
}
