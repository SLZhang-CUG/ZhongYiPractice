package top.zhangsl.model;

import java.util.ArrayList;

public class Question {
  private int id; //题号
  private String title; //题干
  private ArrayList<String> options; //选项
  private String answer; //标准答案

  public Question() {
  }

  public Question(int id, String title, ArrayList<String> options, String answer) {
    this.id = id;
    this.title = title;
    this.options = options;
    this.answer = answer;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ArrayList<String> getOptions() {
    return options;
  }

  public void setOptions(ArrayList<String> options) {
    this.options = options;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(title).append("\n");
    for(String option:options){
      s.append(option).append("\n");
    }
    //s.append(answer);
    return s.toString();
  }
}
