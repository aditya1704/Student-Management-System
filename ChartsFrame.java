import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.List;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

class ChartsFrame extends JFrame{

ChartsFrame(){
DefaultCategoryDataset d1=new DefaultCategoryDataset();
Hibernate hb = new Hibernate();
List<Student> slist = hb.Charts();

	for(Student s:slist){
		String name= s.getName();
		int math=s.getMath();
		int phy=s.getPhysics();
		int chem =s.getChemistry();
		int eng= s.getEnglish();
		int cs= s.getCS();
		d1.addValue(math,name,"Maths");
		d1.addValue(phy,name,"Physics");
		d1.addValue(chem,name,"Chemistry");
		d1.addValue(eng,name,"English");
		d1.addValue(cs,name,"CS");

	}

	JFreeChart chart =ChartFactory.createBarChart("Student's Performance","Subjects","Marks",d1,PlotOrientation.VERTICAL,true,false,false);
	ChartPanel panel=new ChartPanel(chart);
	setContentPane(panel);
	


JButton saveBtn =new JButton("save");
/*
c.add(saveBtn);
backBtn=new JButton("back");
c.add(backBtn);

ActionListener a1= ae->{
MainFrame mf =new MainFrame();
dispose();
};

backBtn.addActionListener(a1);
*/


setTitle("Charts");
setSize(500,500);
setLocationRelativeTo(null);
//setDefaultCloseOperation();
setVisible(true);

}
}
