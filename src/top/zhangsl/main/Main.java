package top.zhangsl.main;

import top.zhangsl.control.ClientContext;
import top.zhangsl.dao.EntityContext;
import top.zhangsl.view.MainFrame;

public class Main {
  public static void main(String[] args) {
    MainFrame mainFrame = new MainFrame(); //主界面
    ClientContext clientContext = new ClientContext();
    mainFrame.setClientContext(clientContext);

    //创建数据层
    EntityContext entityContext = new EntityContext();
    //创建业务层

    mainFrame.setVisible(true);


  }
}
