package com.example.resource;

/**
 * Created by evgeniytupitsyn on 13/11/2016.
 */
/**
 * Класс, описывающий строковые ресурсы. Объекты создаются через ResourceFactory.
 * @see com.example.resource.Resource
 * @see com.example.resource.ResourceFactory
 */
class StringResource extends Resource{

    /**
     * Конструктор строкового ресурса.
     * @param inputParam Используется в качестве текста.
     */
    StringResource(String inputParam){
        super(inputParam);
    }

    /**
     * Ресурс использует в качестве текста параметр конструктора.
     * @return Текст, полученный в параметре.
     */
    @Override
    String retrieveText(){
        return getInputParam();
    }
}