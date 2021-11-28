package com.lesson31.task3110.command;

import com.lesson31.task3110.ConsoleHelper;
import com.lesson31.task3110.FileProperties;
import com.lesson31.task3110.ZipFileManager;

import java.util.List;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        List<FileProperties> filePropertiesList = zipFileManager.getFilesList();
        filePropertiesList.forEach( z -> {
            ConsoleHelper.writeMessage(z.toString());
        });

        ConsoleHelper.writeMessage("Содержимое архива прочитано.");

    }
}
