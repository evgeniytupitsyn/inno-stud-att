package com.example.resource;

import static com.example.constants.Constants.*;
/**
 * Created by evgeniytupitsyn on 13/11/2016.
 */
/**
 * Класс фабрика ресурсов. Возвращает объект ресурса в зависимости от переданного параметра.
 * @see com.example.resource.Resource
 * @see com.example.resource.StringResource
 * @see com.example.resource.TxtFileResource
 */
public class ResourceFactory {
    private ResourceFactory() {
    }

    /**
     * Метод для создания ресурса в зависимости от переданной в него строки.
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
