package top.zhangsl.model;

public class ExamInfo {
  private String title;
  private int totalNumbers;//考试题目数量

  public int getTotalNumbers() {
    return totalNumbers;
  }

  public void setTotalNumbers(int totalNumbers) {
    this.totalNumbers = totalNumbers;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
