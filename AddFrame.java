import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddFrame extends JFrame{

Container c;
JButton saveBtn , cancelBtn;
JTextField rollTxt,nameTxt,mathTxt,chemTxt,phyTxt,csTxt,engTxt;
JLabel rollLbl,nameLbl,mathLbl,chemLbl,phyLbl,csLbl,engLbl;

AddFrame(){

c=getContentPane();
c.setLayout(new FlowLayout());

rollLbl=new JLabel("Enter roll Number: ");
rollTxt=new JTextField(35);
c.add(rollLbl);
c.add(rollTxt);

nameLbl=new JLabel("Enter Name: ");
nameTxt=new JTextField(35);
c.add(nameLbl);
c.add(nameTxt);

mathLbl=new JLabel("Enter marks in Maths: ");
mathTxt=new JTextField(35);
c.add(mathLbl);
c.add(mathTxt);

phyLbl=new JLabel("Enter marks in Physics: ");
phyTxt=new JTextField(35);
c.add(phyLbl);
c.add(phyTxt);

chemLbl=new JLabel("Enter marks in Chemistry: ");
chemTxt=new JTextField(35);
c.add(chemLbl);
c.add(chemTxt);

csLbl=new JLabel("Enter marks in CS: ");
csTxt=new JTextField(35);
c.add(csLbl);
c.add(csTxt);

engLbl=new JLabel("Enter marks in English: ");
engTxt=new JTextField(35);
c.add(engLbl);
c.add(engTxt);

saveBtn=new JButton("SAVE");
cancelBtn=new JButton("CANCEL");
c.add(saveBtn);
c.add(cancelBtn);


ActionListener a1 =ae->{
MainFrame m =new MainFrame();
dispose();
};
cancelBtn.addActionListener(a1);

ActionListener a2 =ae ->{
int flag=0;


try{
String name =nameTxt.getText();

char [] checker = name.toCharArray();
for(char i:checker){
	if(Character.isDigit(i)){
		flag=1;
		break;
	}
}
int rno =Integer.parseInt(rollTxt.getText());
int phy=Integer.parseInt(phyTxt.getText());
int chem=Integer.parseInt(chemTxt.getText());
int math=Integer.parseInt(mathTxt.getText());
int cs=Integer.parseInt(csTxt.getText());
int eng=Integer.parseInt(engTxt.getText());

if(math<0 || math >100|| phy<0|| phy >100|| cs<0|| cs>100 || chem<0 || chem >100||eng<0 || eng >100){
	JOptionPane.showMessageDialog(new JDialog(),"Marks should be between 0 & 100 !!!");
}else if(rno<0){
	JOptionPane.showMessageDialog(new JDialog(),"Enter valid Roll No. !!!");
}else if(name.length() <= 1 || flag==1){
	JOptionPane.showMessageDialog(new JDialog(),"Enter valid Name of student !!!");
}
else{
Hibernate hb =new Hibernate();
hb.Add(rno,name,math,phy,chem,cs,eng);
}
}catch(NumberFormatException nfe){
	JOptionPane.showMessageDialog(new JDialog(),"Enter Marks & Roll Number in Integer!!!");
}
};
saveBtn.addActionListener(a2);

setTitle("ADD STUDENT");
setSize(400,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}