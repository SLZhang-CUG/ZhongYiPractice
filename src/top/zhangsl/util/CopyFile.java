package top.zhangsl.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFile{

  public static void copyFile(String sourceFile,String targetFile) throws IOException {
    Files.copy(Paths.get(sourceFile), Paths.get(targetFile), StandardCopyOption.REPLACE_EXISTING);
  }
}
