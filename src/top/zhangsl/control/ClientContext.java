package top.zhangsl.control;

import top.zhangsl.view.MainFrame;

import javax.swing.*;

public class ClientContext {
  private MainFrame mainFrame;

  public void setMainFrame(MainFrame mainFrame) {
    this.mainFrame = mainFrame;
  }

  public void exit() {
    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
            "确定要退出吗?")) {
      System.exit(0);
    }
  }
}
