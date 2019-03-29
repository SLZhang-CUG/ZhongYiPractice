package top.zhangsl.service;

import top.zhangsl.dao.EntityContext;
import top.zhangsl.model.ExamInfo;
import top.zhangsl.model.Question;
import top.zhangsl.model.QuestionInfo;
import top.zhangsl.util.GetFileName;

import java.util.ArrayList;
import java.util.Random;

public class ExamServiceImpl implements ExamService{

  private EntityContext entityContext;
  private ArrayList<QuestionInfo> examQuestions;//考试的题目信息
  private String filePath;

  public void setEntityContext(EntityContext entityContext) {
    this.entityContext = entityContext;
  }

  @Override
  public ExamInfo start() {
    getExamQuestions(1);
    ExamInfo examInfo = new ExamInfo();
    String filename = filePath.split("/")[filePath.split("/").length-1].split("\\.")[0];
    examInfo.setTitle(filename);
    examInfo.setTotalNumbers(examQuestions.size());
    return examInfo;
  }

  @Override
  public ExamInfo startRandom() {
    getExamQuestions(2);
    ExamInfo examInfo = new ExamInfo();
    String filename = GetFileName.parseFilePath(filePath);
    //String filename = filePath.split("/")[filePath.split("/").length-1].split("\\.")[0];
    examInfo.setTitle(filename.split("\\.")[0]);
    examInfo.setTotalNumbers(examQuestions.size());
    return examInfo;
  }




  @Override
  public ArrayList<QuestionInfo> getExamQuestions(int category) {
    int index = 0;
    Random random = new Random();
    // 一次考试的所有试题
    examQuestions = new ArrayList<QuestionInfo>();
    entityContext.setFilePath(filePath);
    ArrayList<Question> questions =  entityContext.getAllQuestion();
    if(category == 1) {
      for (int i = 0; i < 20; i++) {
        examQuestions.add(new QuestionInfo(questions.get(i)));
      }
    } else if (category == 2) {
      for (int i = 0; i < 20; i++) {
        examQuestions.add(new QuestionInfo(questions.get(i)));
      }
    }
    return examQuestions;
  }


  @Override
  public void saveUserAnswers(ArrayList<String> userAnswers) {

  }

  public String getFilePath() {
    return filePath;
  }

  @Override
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }
}
