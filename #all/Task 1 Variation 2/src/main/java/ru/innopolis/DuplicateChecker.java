package ru.innopolis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.resources.Resource;
import static ru.innopolis.constants.Constants.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Класс представляет собой нить, проверяющую текст ресурса на наличие повторяющихся слов.
 * Между словами стоят пробелы, знаки препинания и переводы строк.
 * Когда, одна из нитей находит дубль, или возникает ошибка, все нити прекращают свою работу.
 * @see ru.innopolis.resources.Resource
 * @see Main
 */
public class DuplicateChecker implements Callable<Integer> {

    private static final Logger logger = LoggerFactory.getLogger(DuplicateChecker.class);

    private Resource resource;

    private static AtomicBoolean foundDuplicate = new AtomicBoolean(false);
    private static AtomicBoolean stopped = new AtomicBoolean(false);

    /**
     * Метод запускает нить. Сначала у ресурса инициализируется текст, затем каждое слово из текста заносится в общий
     * словарь. Если в нём уже есть такое слово, метод возвращает 1, и все нити прекращают работу.
     * Также все нити останавливаются при возникновении ошибок при инициализации текста.
     * @return 1, если нить нашла дубль, 0, если - нет.
     */
    @Override
    public Integer call() {

        try {

            resource.initText();

        } catch (FileNotFoundException e) {

            logger.error("Файл {} не найден.", resource.getInputParam());
            stopped.set(true);
            return 0;

        } catch (IOException e1) {
            logger.error("{} call executed ", Thread.currentThread().getName(), e1);

            stopped.set(true);
            return 0;
        }

        if (!resource.isTextCorrect()){

            String resourceShortName;

            if (resource.getInputParam().length() >= 20) {
                resourceShortName = resource.getInputParam().substring(0, 19) + "...";
            } else {
                resourceShortName = resource.getInputParam();
            }

            logger.error("Ресурс {} содержит недопустимые символы.", resourceShortName);
            stopped.set(true);

            return 0;

        }

        String[] words = resource.getText().split(" |\\p{Punct}|\\r|\\n");

        for (int i = 0; i < words.length && !foundDuplicate.get() && !stopped.get(); i++) {

            if (DICTIONARY.contains(words[i])) {

                foundDuplicate.set(true);
                return 1;

            } else {

                DICTIONARY.add(words[i]);

                if(DEBUG){
                    logger.debug("Поток {} добавил в словарь слово {}", Thread.currentThread().getName(), words[i]);
                }
            }
        }

        return 0;
    }

    /**
     * Конструктор.
     * @param resource Ресурс, который необходимо обработать.
     */
    public DuplicateChecker(Resource resource) {
        this.resource = resource;
    }

    /**
     * Метод проверяет, найден ли дубликат.
     * Если дубли не найдены, нити завершают свою работу сами и этот метод возвращает false.
     * @return проверка, найден ли дубликат. true - да, false - нет.
     */
    public static boolean foundDuplicate() {
        return foundDuplicate.get();
    }

    /**
     * Метод проверяет, возникла ли ошибка в какой-либо нити.
     * @return проверка, остановлены ли нити с ошибкой. true - да, false - нет.
     */
    public static boolean isStopped() {
        return stopped.get();
    }
}
