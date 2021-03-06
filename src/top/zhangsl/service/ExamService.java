package top.zhangsl.service;

import top.zhangsl.model.ExamInfo;
import top.zhangsl.model.QuestionInfo;

import java.util.ArrayList;

public interface ExamService {
  ExamInfo start();  //开始完整考试
  ExamInfo startRandom(); //开始随机题目考试
  ArrayList<QuestionInfo> getExamQuestions(int category); //获取考试题目
  void saveUserAnswers(ArrayList<String> userAnswers); //保存用户答案
  void setFilePath(String filePath);
}
