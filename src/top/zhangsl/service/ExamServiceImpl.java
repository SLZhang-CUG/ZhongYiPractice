package top.zhangsl.service;

import top.zhangsl.dao.EntityContext;
import top.zhangsl.model.ExamInfo;
import top.zhangsl.model.Question;
import top.zhangsl.model.QuestionInfo;

import java.util.ArrayList;
import java.util.Random;

public class ExamServiceImpl implements ExamService{

  private EntityContext entityContext;
  private ArrayList<QuestionInfo> examQuestions;//考试的题目信息

  public void setEntityContext(EntityContext entityContext) {
    this.entityContext = entityContext;
  }

  @Override
  public ExamInfo start() {
    getExamQuestions(1);
    ExamInfo examInfo = new ExamInfo();
    examInfo.setTitle("测试");
    examInfo.setTotalNumbers(examQuestions.size());
    return examInfo;
  }

  @Override
  public ExamInfo startRandom() {
    getExamQuestions(2);
    ExamInfo examInfo = new ExamInfo();
    examInfo.setTitle("测试");
    examInfo.setTotalNumbers(examQuestions.size());
    return examInfo;
  }


  @Override
  public ArrayList<QuestionInfo> getExamQuestions(int category) {
    int index = 0;
    Random random = new Random();
    // 一次考试的所有试题
    examQuestions = new ArrayList<QuestionInfo>();
    entityContext.setFilePath("ceshi.docx");
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
}
