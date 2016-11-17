package com.example.resource;

/**
 * Created by evgeniytupitsyn on 13/11/2016.
 */

import java.io.IOException;

import static com.example.constants.Constants.UNAVAILABLE_SYMBOLS;

/**
 * Абстрактный класс, от  которого наследуются все типы ресурсов.
 * Экземпляры всех классов наследников создаются при помощи {@linkplain ResourceFactory}.
 * Каждый тип ресурса должен переопределить метод получения текста {@linkplain Resource#retrieveText()}.
 * @see com.example.resource.ResourceFactory
 * @see com.example.resource.StringResource
 * @see com.example.resource.TxtFileResource
 */
public abstract class Resource {

    private String text;
    private String inputParam;

    /**
     * Метод возвращает текст ресурса в виде строки. Выполнять только после {@linkplain Resource#initText()}.
     * @return Текст ресурса.
     */
    public String getText() {
        return text;
    }

    /**
     * Метод для получения входного параметра.
     * @return Входной параметр.
     */
    public String getInputParam() {
        return inputParam;
    }

    /**
     * Конструктор ресурсов.
     * @param inputParam входной параметр, по которому будет определяться тип ресурса.
     */
    Resource(String inputParam){
        this.inputParam = inputParam;
    }

    /**
     * Метод, при помощи которого ресурс должен получить текст. Выполняется в методе {@linkplain Resource#initText()}.
     * @return Текст, полученный из ресурса нужным способом.
     * @throws IOException при ошибках ввода-вывода у потомков.
     */
    abstract String retrieveText() throws IOException;

    /**
     * Метод инициализирует текст ресурса при помощи метода {@linkplain Resource#retrieveText()}
     * @throws IOException  при ошибках ввода-вывода.
     */
    public void initText() throws IOException{

        text = retrieveText();

    }

    /**
     * Метод проверяет, текст на наличие запрещённых символов. Выполнять только после {@linkplain Resource#initText()}.
     * @return true, если текст не содержит запрещённых символов, false - если содержит.
     */
    public boolean isTextCorrect(){

        return !UNAVAILABLE_SYMBOLS.matcher(text).find();

    }
}