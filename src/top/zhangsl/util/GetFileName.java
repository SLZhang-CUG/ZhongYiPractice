package top.zhangsl.util;

public class GetFileName {

  public static String parseFilePath(String filePath){
    filePath = filePath.trim();
    return filePath.substring(filePath.lastIndexOf("/")+1);
  }
}
