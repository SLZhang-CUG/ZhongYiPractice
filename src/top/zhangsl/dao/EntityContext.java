package top.zhangsl.dao;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import top.zhangsl.model.Question;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EntityContext {

  private ArrayList<Question> allQuestion;
  private String filePath;

  public EntityContext() {
  }

  private void loadQuestion() {

    XWPFDocument docx = null;
    try {
      docx = new XWPFDocument(new FileInputStream(filePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
    XWPFWordExtractor we = new XWPFWordExtractor(docx);
    String[] examQuestion = we.getText().split("答案");
    String[] questionList = examQuestion[0].split("\n");
    String[] answerList = examQuestion[1].split("\n");
    allQuestion = new ArrayList<Question>();

    for (int i = 0; i < questionList.length; ) {
      Question question = new Question();
      String title = questionList[i].split("\\.")[1];
      ArrayList<String> options = new ArrayList<String>();
      options.add(questionList[i + 1]);
      options.add(questionList[i + 2]);
      options.add(questionList[i + 3]);
      options.add(questionList[i + 4]);
      String answer = answerList[i / 5 + 1].split("\\.")[1];

      question.setTitle(title);
      question.setOptions(options);
      question.setAnswer(answer);

      allQuestion.add(question);
      i += 5;
    }
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public ArrayList<Question> getAllQuestion() {
    loadQuestion();
    return allQuestion;
  }
}
