package ru.innopolis.resources;

/**
 * Класс, описывающий строковые ресурсы. Объекты создаются через ResourceFactory.
 * @see ru.innopolis.resources.Resource
 * @see ru.innopolis.resources.ResourceFactory
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
