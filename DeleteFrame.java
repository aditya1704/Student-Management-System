import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame{

Container c;
JButton deleteBtn , cancelBtn;
JTextField rollTxt;
JLabel rollLbl;

DeleteFrame(){

c=getContentPane();
c.setLayout(new FlowLayout());

rollLbl=new JLabel("Enter roll Number of the record to be deleted : ");
rollTxt=new JTextField(35);
c.add(rollLbl);
c.add(rollTxt);

deleteBtn=new JButton("DELETE");
cancelBtn=new JButton("CANCEL");
c.add(deleteBtn);
c.add(cancelBtn);

ActionListener a1 =ae->{
MainFrame m =new MainFrame();
dispose();
};
cancelBtn.addActionListener(a1);

ActionListener a2=ae->{
try{
	int rno=Integer.parseInt(rollTxt.getText());
	Hibernate hb =new Hibernate();
	hb.Delete(rno);
	MainFrame m =new MainFrame();
	dispose();	
}catch(NumberFormatException nfe){
	JOptionPane.showMessageDialog(new JDialog(),"Enter valid roll number... Roll Number must be Integer!!!");
}
}; 

deleteBtn.addActionListener(a2);

setTitle("DELETE STUDENT");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}