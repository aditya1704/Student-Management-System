import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFrame extends JFrame{

Container c;
JButton checkBtn , cancelBtn;
JTextField rollTxt;
JLabel rollLbl;

UpdateFrame(){

c=getContentPane();
c.setLayout(new FlowLayout());

rollLbl=new JLabel("Enter roll Number of the record to be updated : ");
rollTxt=new JTextField(35);
c.add(rollLbl);
c.add(rollTxt);

checkBtn=new JButton("CHECK");
cancelBtn=new JButton("CANCEL");
c.add(checkBtn);
c.add(cancelBtn);

ActionListener a1 =ae->{
MainFrame m =new MainFrame();
dispose();
};
cancelBtn.addActionListener(a1);

ActionListener a2 = ae ->{
try{
	int rno=Integer.parseInt(rollTxt.getText());
	Hibernate hb =new Hibernate();
	Student s=hb.rnoCheck(rno);
	if(s !=null){
		UpdateFieldsFrame uff =new UpdateFieldsFrame(s,rno);
		dispose();
	}
}catch(NumberFormatException nfe){
	JOptionPane.showMessageDialog(new JDialog(),"Invalid Roll Number... Please Enter Integer values!!!");
}
};
checkBtn.addActionListener(a2);



setTitle("UPDATE STUDENT");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}