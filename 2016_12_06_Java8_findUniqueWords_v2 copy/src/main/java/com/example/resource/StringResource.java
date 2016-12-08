package com.example.resource;

/**
 * Класс, описывающий строковые ресурсы. Объекты создаются через FarmResource.
 * @see Resource
 * @see FarmResource
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
