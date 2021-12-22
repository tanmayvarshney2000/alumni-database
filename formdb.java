import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;

public class formdb extends Applet implements ActionListener{

String     regno="",firstname="",lastname="",batch="";

TextField t1=new TextField(10);
TextField t2=new TextField(10);
TextField t3=new TextField(10);
TextField t4=new TextField(10);
Label l1= new Label("Reg No.");
Label l2= new Label("First Name");
Label l3= new Label("Last Name");
Label l4= new Label("Batch");

Button B1=new Button("Submit");

public void init(){
add(l1);
add(t1);
add(l2);
add(t2);
add(l3);
add(t3);
add(l4);
add(t4);
add(B1);


B1.addActionListener(this);
}

public void paint(Graphics g){
g.drawString("Reg No:- "+regno,20,100);
g.drawString("FirstName:- "+firstname,20,120);
g.drawString("LastName:- "+lastname,20,160);
g.drawString("Batch:- "+batch,20,200);
}

public void actionPerformed(ActionEvent e){
regno=t1.getText();
firstname=t2.getText();
lastname=t3.getText();
batch=t4.getText();

repaint();
}





public void main (String[] args){
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=(Connection)DriverManager.getConnection("Jdbc:Odbc:tanmay");
//String sql="Select * from Students";
Statement st=con.createStatement();
String sql="insert into tanmay values('"+t1+"','"+t2+"','"+t3+"','"+t4+"');";
//String sql="Select * from Students";
ResultSet rs=st.executeQuery(sql);
System.out.println("\nRegNo \t FirstName \t LastName \t Batch");
while(rs.next()){
System.out.println("\n"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
//String n=rs.getString("t1");
}
con.close();
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}


/*<applet code="formdb.class" width=500 height=500></applet>*/ 

