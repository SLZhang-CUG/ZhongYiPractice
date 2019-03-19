package top.zhangsl.control;

import top.zhangsl.model.ExamInfo;
import top.zhangsl.service.ExamService;
import top.zhangsl.view.MainFrame;

import javax.swing.*;

public class ClientContext {
  private MainFrame mainFrame;
  private ExamInfo examInfo;
  private ExamService examService;

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

  }


}
