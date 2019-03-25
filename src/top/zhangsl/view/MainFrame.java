package top.zhangsl.view;


import top.zhangsl.control.ClientContext;
import top.zhangsl.model.ExamInfo;
import top.zhangsl.model.QuestionInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame {



  private ClientContext clientContext;
  private JPanel jPanel;
  private JTextArea jta;

  private int length;

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
    randomExamMenu.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        clientContext.randomStart();
      }
    });
    JMenuItem completeExamMenu = new JMenuItem("完整题目测试");
    completeExamMenu.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        clientContext.Start();
      }
    });
    examMenu.add(randomExamMenu);
    examMenu.add(completeExamMenu);
    return examMenu;
  }

  private JMenu createFileMenu() {
    JMenu fileMenu = new JMenu("文件");
    JMenuItem importFileMenu = new JMenuItem("导入文件");
    importFileMenu.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        clientContext.importFile();
      }
    });
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
    jPanel = new JPanel(new BorderLayout());
    jPanel.add(BorderLayout.CENTER,createQuestionInfoPanel());

    return jPanel;
  }

  private JPanel createButtonPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(length,1));
    for(int i = 0 ; i < length; i++){
      JPanel tempPanel = new JPanel(new FlowLayout());
      JLabel jLabel = new JLabel((i+1)+".");
      Option box1 = new Option("A", "A");
      Option box2 = new Option("B", "B");
      Option box3 = new Option("C", "C");
      Option box4 = new Option("D", "D");
      tempPanel.add(jLabel);
      tempPanel.add(box1);
      tempPanel.add(box2);
      tempPanel.add(box3);
      tempPanel.add(box4);
      panel.add(tempPanel);

    }
    return panel;
  }

  private class Option extends JCheckBox{
    private String value;
    public Option(String name,String value){
      super(name);
      this.value = value;
    }
    public String getValue() {
      return value;
    }
  }

  private JScrollPane createQuestionInfoPanel() {
    JScrollPane panel = new JScrollPane();
    jta = new JTextArea();
    //jta.setText("A\n\nB\n\n");
    jta.setLineWrap(true);
    jta.setFocusable(false);
    panel.getViewport().add(jta);
    return panel;
  }

  public void updateView(ExamInfo examInfo, ArrayList<QuestionInfo> questionInfos){
    jta.setText(examInfo.toString()+"\n");
    length = examInfo.getTotalNumbers();
    int i = 0;
    for(QuestionInfo questionInfo:questionInfos) {
      jta.append(++i +"."+questionInfo.toString());
    }
    jPanel.add(BorderLayout.EAST,createButtonPanel());
  }


}
