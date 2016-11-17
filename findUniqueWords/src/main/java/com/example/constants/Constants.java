package com.example.constants;

/**
 * Created by evgeniytupitsyn on 13/11/2016.
 */

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * В этом классе хранятся константы.
 */
public class Constants {

    /**
     * Переключатель режима дебага, в котором записываются дополнительные логи.
     */
    public static final boolean DEBUG = true;

    /**
     * В эту переменную будут добавляться слова из всех ресурсов.
     */
    public static final Set<String> DICTIONARY = Collections.newSetFromMap(new ConcurrentHashMap<>());

    /**
     * Регулярное выражение, описывающее запрещённые в тексте символы (запрещены все, кроме перечисленных).
     */
    public static final Pattern UNAVAILABLE_SYMBOLS = Pattern.compile("[^а-яА-Я0-9\\p{Punct}\\s]");

    /**
     * Регулярное выражение пути к txt файлу или названия txt файла.
     */
    public static final String TXT_FILE_REGEX =
            "(^([a-zA-Z]\\:|\\\\)\\\\([^\\\\]+\\\\)*[^\\/:*?\"<>|]+\\.txt)|([^\\/:*?\"<>|]+\\.txt)$";

}
