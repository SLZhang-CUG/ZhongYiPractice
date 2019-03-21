package top.zhangsl.control;

import top.zhangsl.model.ExamInfo;
import top.zhangsl.model.QuestionInfo;
import top.zhangsl.service.ExamService;
import top.zhangsl.view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

public class ClientContext {
  private MainFrame mainFrame;
  private ExamInfo examInfo;
  private ExamService examService;
  private ArrayList<QuestionInfo> questionInfos;

  public void setExamService(ExamService examService) {
    this.examService = examService;
  }

  public void setMainFrame(MainFrame mainFrame) {
    this.mainFrame = mainFrame;
  }

  public void exit() {
    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
            "确定要退出吗?")) {
      System.exit(0);
    }
  }

  public void randomStart(){
    examInfo = examService.startRandom();
    questionInfos = examService.getExamQuestions(2);
    mainFrame.updateView(examInfo,questionInfos);

  }

  public void Start(){
    examInfo = examService.startRandom();
    questionInfos = examService.getExamQuestions(1);
    mainFrame.updateView(examInfo,questionInfos);
  }


}
