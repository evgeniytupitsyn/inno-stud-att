package com.example.resource;

import static com.example.constants.Constants.TXT_FILE_REGEX;

/**
 * "Ферма" ресурсов. Возвращает объект ресурса в зависимости от переданного параметра.
 * @see Resource
 * @see StringResource
 * @see TxtFileResource
 */
public class FarmResource {
    private FarmResource() {
    }

    /**
     * Создание "ресурса". Происходит анализ полученной строки.
     * @param param строка, передающаяся из аргументов метода main.
     * @return Объект TxtFileResource, если в параметре имя файла, либо путь к файлу. В других случаях StringResource.
     */
    public static Resource createResourceWithParam(String param){

        if (param.matches(TXT_FILE_REGEX)){
            return new TxtFileResource(param);
        } else{
            return new StringResource(param);
        }

    }
}
