package ru.innopolis.resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Класс описывающий ресурсы в виде txt файлов. Объекты создаются через ResourceFactory.
 * @see ru.innopolis.resources.Resource
 * @see ru.innopolis.resources.ResourceFactory
 */
class TxtFileResource extends Resource{

    /**
     * Конструктор ресурса текстового файла.
     * @param inputParam Путь к файлу.
     */
    TxtFileResource(String inputParam){
        super(inputParam);
    }

    /**
     * Считыватся файл, путь к которому передаётся в параметре конструктора.
     * Содержимое файла записывается в StringBuilder и возвращается в качестве текста.
     * @return Текст, полученный из файла.
     * @throws IOException при ошибках ввода-вывода.
     */
    @Override
    String retrieveText() throws IOException{
        try(FileReader fileReader = new FileReader(getInputParam());
            BufferedReader reader = new BufferedReader(fileReader)){

            StringBuilder stringBuilder = new StringBuilder();

            while (reader.ready()){
                stringBuilder.append(reader.readLine());
                stringBuilder.append("\n");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            return stringBuilder.toString();
        }
    }
}
