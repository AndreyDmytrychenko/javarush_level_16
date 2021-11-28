package com.lesson31.task3110;

import com.lesson31.task3110.exception.WrongZipFileException;

import java.io.IOException;
import java.util.Arrays;

public class Archiver {

    public static void main(String[] args) throws Exception {



        while (true) {
            Operation operation = null;
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);

            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
            if (operation == Operation.EXIT) break;
        }
    }

    public static Operation askOperation() throws Exception {
        ConsoleHelper.writeMessage("Выберите операцию:");

        Arrays.stream(Operation.values()).forEach( element -> {
            ConsoleHelper.writeMessage(String.format("%d - %s", element.ordinal(), element));
        });

        int number = 0;
        try {
            number = ConsoleHelper.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Operation operation = Operation.values()[number];

        return operation;
    }
}
//d:\java\архив\test.zip
//d:\java\text.txt
//d:\java\распаковка
