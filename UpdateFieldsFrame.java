import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFieldsFrame extends JFrame{

Container c;
JButton updateBtn , cancelBtn;
JTextField rollTxt,nameTxt,mathTxt,chemTxt,phyTxt,csTxt,engTxt;
JLabel rollLbl,nameLbl,mathLbl,chemLbl,phyLbl,csLbl,engLbl;

UpdateFieldsFrame(Student s,int rollNo){
System.out.println(rollNo);
c=getContentPane();
c.setLayout(new FlowLayout());

rollLbl=new JLabel("Enter roll Number: ");
rollTxt=new JTextField(Integer.toString(s.getRno()),35);
c.add(rollLbl);
c.add(rollTxt);

nameLbl=new JLabel("Enter Name: ");
nameTxt=new JTextField(s.getName(),35);
c.add(nameLbl);
c.add(nameTxt);

mathLbl=new JLabel("Enter marks in Maths: ");
mathTxt=new JTextField(Integer.toString(s.getMath()),35);
c.add(mathLbl);
c.add(mathTxt);

phyLbl=new JLabel("Enter marks in Physics: ");
phyTxt=new JTextField(Integer.toString(s.getPhysics()),35);
c.add(phyLbl);
c.add(phyTxt);

chemLbl=new JLabel("Enter marks in Chemistry: ");
chemTxt=new JTextField(Integer.toString(s.getChemistry()),35);
c.add(chemLbl);
c.add(chemTxt);

csLbl=new JLabel("Enter marks in CS: ");
csTxt=new JTextField(Integer.toString(s.getCS()),35);
c.add(csLbl);
c.add(csTxt);

engLbl=new JLabel("Enter marks in English: ");
engTxt=new JTextField(Integer.toString(s.getEnglish()),35);
c.add(engLbl);
c.add(engTxt);

updateBtn=new JButton("UPDATE");
cancelBtn=new JButton("CANCEL");
c.add(updateBtn);
c.add(cancelBtn);

ActionListener a1 =ae->{
MainFrame m =new MainFrame();
dispose();
};
cancelBtn.addActionListener(a1);

ActionListener a2=ae->{

int flag=0;

try{
int rno =Integer.parseInt(rollTxt.getText());

String name=nameTxt.getText();
if(name.length()<=1){
	JOptionPane.showMessageDialog(c,"Enter valid name");
}

char [] charName=name.toCharArray();
for(int i:charName){
	if(Character.isDigit(i)){
		flag=1;
		break;
	}
}

int phy=Integer.parseInt(phyTxt.getText());
int chem=Integer.parseInt(chemTxt.getText());
int math=Integer.parseInt(mathTxt.getText());
int cs=Integer.parseInt(csTxt.getText());
int eng=Integer.parseInt(engTxt.getText());

if(math<0 || math >100|| phy<0|| phy >100|| cs<0|| cs>100 || chem<0 || chem >100||eng<0 || eng >100){
	JOptionPane.showMessageDialog(new JDialog(),"Marks should be between 0 & 100 !!!");
}else if(name.length() <= 1 || flag==1){
	JOptionPane.showMessageDialog(new JDialog(),"Enter valid Name of student !!!");
}else if(name.length()<=1){
	JOptionPane.showMessageDialog(c,"Enter valid name");
}else if(flag==1){
	JOptionPane.showMessageDialog(c,"Name cannot contain Integers!!!");
}else{
Hibernate hb =new Hibernate();
hb.Update(rno,name,math,phy,chem,cs,eng);
MainFrame mf = new MainFrame();
dispose();
}
}catch(NumberFormatException nfe){
	JOptionPane.showMessageDialog(c,"Enter valid marks...Marks must be Integers !!! ");
}

};
updateBtn.addActionListener(a2);

setTitle("Update Records");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}