package com.lesson31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path rootPath;
    private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        fileList = new ArrayList<>();
        collectFileList(this.rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException {
        if (Files.isRegularFile(path)) {
            fileList.add(rootPath.relativize(path));

        } else if (Files.isDirectory(path)) {
          try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {

              ds.forEach( element -> {

                  try {
                      collectFileList(element);
                  } catch (IOException e) {
                      e.printStackTrace();
                  }

              });
          } catch (Exception e) {
              e.printStackTrace();
          }
        }
    }
}
