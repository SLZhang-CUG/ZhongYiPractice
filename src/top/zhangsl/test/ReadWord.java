package top.zhangsl.test;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import top.zhangsl.model.Question;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReadWord {
  public static void main(String[] args) throws IOException {

    XWPFDocument docx = new XWPFDocument(new FileInputStream("ceshi.docx"));
    XWPFWordExtractor we = new XWPFWordExtractor(docx);
    String[] examQuestion = we.getText().split("答案");
    String[] questionList = examQuestion[0].split("\n");
    String[] answerList = examQuestion[1].split("\n");
    ArrayList<Question> allQuestion = new ArrayList<Question>();

    for(String answer:answerList){
      String[] answers = answer.split(".");
      for(String answer1 : answers){
        System.out.print(answer1 + "," );
      }
      System.out.println();
    }


    for(int i = 0 ; i < questionList.length; ){
      Question question = new Question();
      String title = questionList[i];
      ArrayList<String> options = new ArrayList<String>();
      options.add(questionList[i+1]);
      options.add(questionList[i+2]);
      options.add(questionList[i+3]);
      options.add(questionList[i+4]);
      String answer = answerList[i/5+1];

      question.setTitle(title);
      question.setOptions(options);
      question.setAnswer(answer);

      allQuestion.add(question);
      i+=5;
    }

//    for(Question oneQuestion: allQuestion){
//      System.out.println(oneQuestion);
//    }

  }
}
