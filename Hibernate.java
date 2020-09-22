import org.hibernate.*;
import org.hibernate.cfg.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

class Hibernate{

public static void Add(int rno,String name,int math,int physics,int chemistry,int CS,int english){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;

Transaction t=null;
try{
	session = sfact.openSession();
	System.out.println("Connected");

	t=session.beginTransaction();
	
	Student s=new Student(rno,name,math,physics,chemistry,CS,english);
	session.save(s);
	t.commit();
	
	String msg="Records Added: "+rno+" "+name;
	JOptionPane.showMessageDialog(new JDialog(),msg);
}catch(org.hibernate.exception.ConstraintViolationException cve){
	JOptionPane.showMessageDialog(new JDialog(),"Entered Roll Number already exists... Please Enter unique Roll number!!!");
	t.rollback();
}
catch(Exception e){
	System.out.println("issue: "+e);
	t.rollback();
}finally{
	if(session != null){
		session.close();
		System.out.println("disconnected");
	}
}//end of finally

}//end of Add


public static String View(){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
String data="";
try{
	session=sfact.openSession();
	System.out.println("connected");

	List<Student>studentlist = new ArrayList<>();
	studentlist=session.createQuery("from Student").list();
	for(Student s:studentlist)
		data=data+"Roll Number: "+s.getRno()+"\t Name: "+s.getName()+"\t Maths: "+s.getMath()+"\t Physics: "+s.getPhysics()+"\t Chemistry: "+s.getChemistry()+"\t CS: "+s.getCS()+"\t English: "+s.getEnglish()+"\n\n";
}catch(Exception e){
	System.out.println("issue: "+e);
}finally{
	if(session != null){
		session.close();
		System.out.println("disconnected");
	}

}//end of finally

return data;

}//end of View


public static Student rnoCheck(int rollNo){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
Transaction t= null;
Student s=null;
try{
	
	session= sfact.openSession();
	System.out.println("connected");

	t=session.beginTransaction();


	s=(Student)session.get(Student.class,rollNo);
	if(s == null){
		JOptionPane.showMessageDialog(new JDialog(),"Roll Number does not exit !!!");
	}
	return s;

}catch(NumberFormatException nfe){
	System.out.println(nfe);
	t.rollback();
	return s;
}finally{
	if(session != null){
		session.close();
		System.out.println("disconnected");
		
	}
	
}//end of finally


}//end of rnoCheck


public static void Update(int rollNo,String name,int math,int physics,int chemistry,int CS,int english){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
Transaction t= null;

try{
	session= sfact.openSession();
	System.out.println("connected");

	t=session.beginTransaction();
	Student s=(Student)session.get(Student.class,rollNo);
	s.setRno(rollNo);
	s.setName(name);
	s.setMath(math);
	s.setPhysics(physics);
	s.setChemistry(chemistry);
	s.setCS(CS);
	s.setEnglish(english);

	session.save(s);
	t.commit();
	JOptionPane.showMessageDialog(new JDialog(),"Record updated successfully.");


}catch(Exception e){
	System.out.println("issue:"+e);
}finally{
	if(session != null){
		session.close();
		System.out.println("disconnected");
		
	}
	
}//end of finally

}//end of Update



public static void Delete(int rollNo){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
Transaction t= null;

try{
	session =sfact.openSession();
	System.out.println("Connected");

	t=session.beginTransaction();

	Student s=(Student)session.get(Student.class,rollNo);
	if(s == null){
		JOptionPane.showMessageDialog(new JDialog(),"Roll Number does not exit !!!");
	}
	else{
		session.delete(s);
		t.commit();
		JOptionPane.showMessageDialog(new JDialog(),"Record Deleted Successfully  !!!");
	}
}catch(Exception e){
	System.out.println("issue: "+e);
	t.rollback();
}finally{
	if(session !=null){
		session.close();
		System.out.println("disconnected");
	}
}//end of finally
	
}//end of delete


public static List<Student> Charts(){

Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=null;
List<Student>studentlist = new ArrayList<Student>();
try{
	session=sfact.openSession();
	System.out.println("connected");
	studentlist=session.createQuery("from Student").list();
	return studentlist;

}catch(Exception e){
	System.out.println("issue: "+e);
	return studentlist;
}finally{
	if(session != null){
		session.close();
		System.out.println("disconnected");
		
	}

}//end of finally

}//end of Charts 

}//end of class