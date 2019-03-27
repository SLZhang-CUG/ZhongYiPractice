package top.zhangsl.view;

import top.zhangsl.control.ClientContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AboutFrame extends JFrame {

  private ClientContext clientContext;

  public AboutFrame() throws HeadlessException {
    this.setTitle("关于");
    this.add(new JLabel("版本：0.0.1",JLabel.CENTER));
    this.setSize(300,200);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent windowEvent) {
        clientContext.aboutExit();
      }
    });
  }

  public void setClientContext(ClientContext clientContext) {
    this.clientContext = clientContext;
    this.clientContext.setAboutFrame(this);
  }
}
