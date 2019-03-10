package top.zhangsl.test;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWord {
  public static void main(String[] args) throws IOException {

    XWPFDocument docx = new XWPFDocument(
            new FileInputStream("ceshi.docx"));
    //using XWPFWordExtractor Class
    XWPFWordExtractor we = new XWPFWordExtractor(docx);
    //System.out.println(we.getText());
    String[] strings = we.getText().split("\n");
    for(String s : strings){
      System.out.println(s);
    }

//    //Blank Document
//    XWPFDocument document = new XWPFDocument();
//    //Write the Document in file system
//    FileOutputStream out = new FileOutputStream(
//            new File("createdocument.docx"));
//    document.write(out);
//    out.close();
//    System.out.println("createdocument.docx written successully");
  }
}
