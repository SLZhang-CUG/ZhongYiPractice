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
    getExamQuestions();
    ExamInfo examInfo = new ExamInfo();
    examInfo.setTotalNumbers(examQuestions.size());
    return examInfo;
  }

  @Override
  public ExamInfo startRandom() {
    getExamQuestions();
    ExamInfo examInfo = new ExamInfo();
    examInfo.setTotalNumbers(examQuestions.size());
    return examInfo;
  }

  @Override
  public ArrayList<QuestionInfo> getExamQuestions() {
    int index = 0;
    Random random = new Random();
    // 一次考试的所有试题
    examQuestions = new ArrayList<QuestionInfo>();
    ArrayList<Question> questions = entityContext.getAllQuestion();
    for(int i = 0 ; i < 20; i++){
      examQuestions.add(new QuestionInfo(questions.get(i)));
    }
    return examQuestions;
  }


  @Override
  public void saveUserAnswers(ArrayList<String> userAnswers) {

  }
}
