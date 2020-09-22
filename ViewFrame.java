import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame{

Container c;
JButton backBtn;
TextArea taData;
JTable jt;

ViewFrame(){

c=getContentPane();
c.setLayout(new FlowLayout());


taData=new TextArea(20,90);
c.add(taData);



backBtn=new JButton("BACK");
c.add(backBtn);

String data=new Hibernate().View();

/*
String []cols={"Roll No","Name","Maths","Physics","Chemistry","CS","English"};
jt=new JTable(data,cols);
*/
taData.setText(data);

ActionListener a1 =ae->{
MainFrame m =new MainFrame();
dispose();
};
backBtn.addActionListener(a1);

setTitle("View STUDENT");
setSize(800,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}