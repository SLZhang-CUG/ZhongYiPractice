package top.zhangsl.view;


import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

  public static void main(String[] args){
    new MainFrame();
  }
  public MainFrame() {

    this.setJMenuBar(createMenuBar());
    this.setTitle("选择题练习系统");
    this.setSize(1024,720);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    return scoreMenu;
  }

  private JMenu createExamMenu() {
    JMenu examMenu = new JMenu("测试");

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
