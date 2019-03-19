package top.zhangsl.model;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionInfo implements Serializable {
  private Question question; //当前考试题目
  private ArrayList<String> userAnswer = new ArrayList<String>(); //用户选择答案

  public QuestionInfo() {
  }

  public QuestionInfo(Question question) {
    this.question = question;
  }

  public QuestionInfo(ArrayList<String> userAnswer, Question question) {
    super();
    this.userAnswer = userAnswer;
    this.question = question;
  }

  public ArrayList<String> getUserAnswer() {
    return userAnswer;
  }

  public void setUserAnswer(ArrayList<String> userAnswer) {
    this.userAnswer = userAnswer;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  @Override
  public String toString() {
    return question.toString();
  }
}
