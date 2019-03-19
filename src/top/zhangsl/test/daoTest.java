package top.zhangsl.test;

import top.zhangsl.dao.EntityContext;
import top.zhangsl.model.Question;

import java.util.ArrayList;

public class daoTest {

  public static void main(String[] args){
    EntityContext entityContext = new EntityContext();
    entityContext.setFilePath("ceshi.docx");
    ArrayList<Question> questions =  entityContext.getAllQuestion();
    for(Question question:questions){
      System.out.println(question.toString());
    }

  }
}
