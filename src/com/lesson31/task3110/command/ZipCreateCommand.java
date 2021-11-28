package com.lesson31.task3110.command;

import com.lesson31.task3110.ConsoleHelper;
import com.lesson31.task3110.ZipFileManager;
import com.lesson31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");
            ZipFileManager zfm = getZipFileManager();
            ConsoleHelper.writeMessage("Введите путь к файлу и его имя");
            String fileName = ConsoleHelper.readString();// запрос на ввод файла для архивации


                    zfm.createZip(Paths.get(fileName));

            ConsoleHelper.writeMessage("Архив создан");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }

    }
}
