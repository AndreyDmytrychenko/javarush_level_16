package com.lesson31.task3110.command;

import com.lesson31.task3110.ConsoleHelper;
import com.lesson31.task3110.ZipFileManager;

import java.nio.file.Paths;

public abstract class ZipCommand implements Command {
        public ZipFileManager getZipFileManager() throws Exception {

            ConsoleHelper.writeMessage("Введите путь к архиву и его имя");

        String archiveName = ConsoleHelper.readString();// запрос на ввод полного пути архива
        ZipFileManager zfm = new ZipFileManager(Paths.get(archiveName)); //получаем из String -> Path и передаем в конструктор

        return zfm;
        }
}
