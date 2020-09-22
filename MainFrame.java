import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame{

Container c;
JButton addBtn,viewBtn,updateBtn,deleteBtn,chartBtn;

MainFrame(){

c=getContentPane();
c.setLayout(new FlowLayout());

addBtn=new JButton("ADD");
viewBtn=new JButton("VIEW");
deleteBtn=new JButton("DELETE");
updateBtn=new JButton("UPDATE");
chartBtn=new JButton("CHART");
c.add(addBtn);
c.add(viewBtn);
c.add(deleteBtn);
c.add(updateBtn);
c.add(chartBtn);

ActionListener a1 =ae->{
AddFrame af =new AddFrame();
dispose();
};
addBtn.addActionListener(a1);

ActionListener a2 = ae ->{
ViewFrame vf = new ViewFrame();
dispose();
};
viewBtn.addActionListener(a2);

ActionListener a3 = ae->{
UpdateFrame uf = new UpdateFrame();
dispose();
};
updateBtn.addActionListener(a3);

ActionListener a4 =ae->{
DeleteFrame df = new DeleteFrame();
dispose();
};
deleteBtn.addActionListener(a4);

ActionListener a5 =ae->{
ChartsFrame cf =new ChartsFrame();
};
chartBtn.addActionListener(a5);

setTitle("Student Management System");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}