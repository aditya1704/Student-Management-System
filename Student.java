class Student{

private int rno;
private String name;
private int math;
private int physics;
private int chemistry;
private int CS;
private int english;

public Student(){ }
public Student(int rno,String name,int math,int physics,int chemistry,int CS,int english){
this.rno=rno;
this.name=name;
this.math=math;
this.physics=physics;
this.chemistry=chemistry;
this.CS=CS;
this.english=english;
}

public void setRno(int rno){
this.rno=rno;
}

public void  setName(String name){
this.name=name;
}

public void  setMath(int math){
this.math=math;
}

public void  setPhysics(int physics){
this.physics=physics;
}

public void  setChemistry(int chemistry){
this.chemistry=chemistry;
}

public void  setCS(int CS){
this.CS=CS;
}

public void  setEnglish(int english){
this.english=english;
}

public int getRno(){
return rno;
}

public String getName(){
return name;
}

public int getMath(){
return math;
}

public int getPhysics(){
return physics;
}

public int getChemistry(){
return chemistry;
}

public int getCS(){
return CS;
}

public int getEnglish(){
return english;
}


}