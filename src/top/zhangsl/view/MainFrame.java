package top.zhangsl.view;


import top.zhangsl.control.ClientContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {



  private ClientContext clientContext;

  public void setClientContext(ClientContext clientContext) {
    this.clientContext = clientContext;
    this.clientContext.setMainFrame(this);
  }

  public MainFrame() {

    this.setJMenuBar(createMenuBar());
    this.setTitle("选择题练习系统");
    this.setSize(1024,720);
    //this.setVisible(true);
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent windowEvent) {
        clientContext.exit();
      }
    });
    this.setContentPane(createContentPanel());
  }

  private JMenuBar createMenuBar() {
    JMenuBar menu = new JMenuBar();

    menu.add(createFileMenu());
    menu.add(createExamMenu());
    menu.add(createScoreMenu());
    menu.add(createHelpMenu());

    return menu;
  }

  private JMenu createHelpMenu() {
    JMenu helpMenu = new JMenu("帮助");
    JMenuItem aboutMenu = new JMenuItem("关于");
    helpMenu.add(aboutMenu);
    return helpMenu;
  }

  private JMenu createScoreMenu() {
    JMenu scoreMenu = new JMenu("成绩");
    JMenuItem currentScoreMenu = new JMenuItem("本次练习成绩");
    JMenuItem historyScoreMenu = new JMenuItem("历史练习成绩");
    scoreMenu.add(currentScoreMenu);
    scoreMenu.add(historyScoreMenu);
    return scoreMenu;
  }

  private JMenu createExamMenu() {
    JMenu examMenu = new JMenu("测试");
    JMenuItem randomExamMenu = new JMenuItem("随机选题测试");
    JMenuItem completeExamMenu = new JMenuItem("完整题目测试");
    examMenu.add(randomExamMenu);
    examMenu.add(completeExamMenu);
    return examMenu;
  }

  private JMenu createFileMenu() {
    JMenu fileMenu = new JMenu("文件");
    JMenuItem importFileMenu = new JMenuItem("导入文件");
    JMenuItem importQuestionBank = new JMenuItem("导入题库");
    JMenuItem exportQuestionBank = new JMenuItem("导出题库");
    JMenuItem exit = new JMenuItem("退出");
    fileMenu.add(importFileMenu);
    fileMenu.add(importQuestionBank);
    fileMenu.add(exportQuestionBank);
    fileMenu.addSeparator();
    fileMenu.add(exit);
    return fileMenu;
  }

  private JPanel createContentPanel() {
    JPanel jPanel = new JPanel(new BorderLayout());
    return jPanel;
  }


}
