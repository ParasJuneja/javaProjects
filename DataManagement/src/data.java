import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class data implements ActionListener
{
String url,sql,n,c,d,t,d1,a;
int r,response;
JButton b1,b2,b3;
JTextField t1,t2;
JLabel l1,l2;
Connection conn;
Statement stmt;
ResultSet rs;

JFrame f1;
JPanel loginpanel;
JPanel studentpanel,modifypanel,deletepanel,searchpanel,buttonpanel;
JButton blogin;
JButton b1exit;

JButton baddr;

JButton bmodifyr;
JButton bsearchr;
JButton bdeleter;
JButton bexit2;

JButton badd,bsave,bsexit;

JButton bmodify;
JButton bupdate;
JButton bexitm;

JButton bsearch;

JButton bexits;

JButton bdelete;
JButton bconfirm;
JButton bexitd;




JTextField tid,tsid,tsname,tcourse,tdur,tfee,tjoin,tadd;
JTextField tidm,tsidm,tsnamem,tcoursem,tdurm,tfeem,tjoinm,taddm;
JTextField tidd,tsidd,tsnamed,tcoursed,tdurd,tfeed,tjoind,taddd;
JTextField tids,tsids,tsnames,tcourses,tdurs,tfees,tjoins,tadds;

JLabel lid,lpwd,lsid,lspwd,lsname,lcourse,ldur,lfee,ljoin,ljo,ladd;
JLabel lidm,lpwdm,lsidm,lspwdm,lsnamem,lcoursem,ldurm,lfeem,ljoinm,ljom,laddm;
JLabel lidd,lpwdd,lsidd,lspwdd,lsnamed,lcoursed,ldurd,lfeed,ljoind,ljod,laddd;
JLabel lids,lpwds,lsids,lspwds,lsnames,lcourses,ldurs,lfees,ljoins,ladds;
JPasswordField tpwd,tspwd;
data()
{
connection();
f1=new JFrame("Computer Center Data Management");
f1.setVisible(true);
f1.setSize(600,500);
Font e3=new Font("Arial",Font.BOLD,20);

Color z=new Color(252,177,220);

lid=new JLabel("Login ID");
lpwd=new JLabel("Password");


tid = new JTextField(25);
tpwd = new JPasswordField(25);

blogin = new JButton("Login");
b1exit = new JButton("Exit");


loginpanel = new JPanel();
loginpanel.setBackground(Color.red);
loginpanel.setLayout(null);

lid.setBounds(130,20,80,30);
lid.setForeground(Color.black);
loginpanel.add(lid);

tid.setBounds(250,30,200,20);
tid.setForeground(Color.black);
tid.setBackground(Color.cyan);
loginpanel.add(tid);

lpwd.setBounds(130,80,80,30);
lpwd.setForeground(Color.black);
loginpanel.add(lpwd);

tpwd.setBounds(250,90,200,20);
tpwd.setForeground(Color.black);
tpwd.setBackground(Color.cyan);
loginpanel.add(tpwd);


blogin.setBounds(250,150,100,20);
blogin.setMnemonic('l');
blogin.setToolTipText("Click here to login");
loginpanel.add(blogin);

b1exit.setBounds(370,150,100,20);
b1exit.setMnemonic('x');
b1exit.setToolTipText("Click here to exit");
loginpanel.add(b1exit);
f1.getContentPane().add(loginpanel);
blogin.addActionListener(this);
b1exit.addActionListener(this);
////////////////////////////////////


lsid=new JLabel("Student ID");
tsid=new JTextField("");
lsname=new JLabel("Name");
tsname=new JTextField("");
lcourse=new JLabel("Course");

tcourse=new JTextField("");

ldur=new JLabel("Duration of course");

tdur=new JTextField("");
lfee=new JLabel("Total fees");

tfee=new JTextField("");
ljoin=new JLabel("Date of joining");

tjoin=new JTextField("");
ljo=new JLabel("DD-MM-YYYY");

ladd=new JLabel("Address of student");
tadd=new JTextField("");





badd = new JButton("Add");
bsave = new JButton("Save");
bsexit = new JButton("Exit to main menu");

studentpanel=new JPanel();
studentpanel.setBackground(Color.green);
studentpanel.setLayout(null);

lsid.setBounds(130,40,220,30);
lsid.setForeground(Color.black);
studentpanel.add(lsid);

tsid.setBounds(250,40,220,30);
tsid.setForeground(Color.black);
studentpanel.add(tsid);

lsname.setBounds(130,80,220,30);
lsname.setForeground(Color.black);
studentpanel.add(lsname);

tsname.setBounds(250,80,220,30);
tsname.setForeground(Color.black);
studentpanel.add(tsname);

lcourse.setBounds(130,120,220,30);
lcourse.setForeground(Color.black);
studentpanel.add(lcourse);

tcourse.setBounds(250,120,220,30);
tcourse.setForeground(Color.black);
studentpanel.add(tcourse);

ldur.setBounds(130,160,220,30);
ldur.setForeground(Color.black);
studentpanel.add(ldur);

tdur.setBounds(250,160,220,30);
tdur.setForeground(Color.black);
studentpanel.add(tdur);

lfee.setBounds(130,200,220,30);
lfee.setForeground(Color.black);
studentpanel.add(lfee);

tfee.setBounds(250,200,220,30);
tfee.setForeground(Color.black);
studentpanel.add(tfee);

ljoin.setBounds(130,240,220,30);
ljoin.setForeground(Color.black);
studentpanel.add(ljoin);

tjoin.setBounds(250,240,220,30);
tjoin.setForeground(Color.black);
studentpanel.add(tjoin);

ljo.setBounds(480,240,220,30);
ljo.setForeground(Color.black);
studentpanel.add(ljo);

ladd.setBounds(130,280,220,30);
ladd.setForeground(Color.black);
studentpanel.add(ladd);

tadd.setBounds(250,280,220,30);
tadd.setForeground(Color.black);
studentpanel.add(tadd);




badd.setBounds(150,350,140,20);
badd.setMnemonic('s');
badd.setToolTipText("Click here to add");
badd.addActionListener(this);
studentpanel.add(badd);

bsave.setBounds(320,350,140,20);
bsave.setMnemonic('s');
bsave.setToolTipText("Click here to save");
bsave.addActionListener(this);
studentpanel.add(bsave);

bsexit.setBounds(490,350,140,20);
bsexit.setMnemonic('E');
bsexit.addActionListener(this);
bsexit.setToolTipText("Click here to exit");
studentpanel.add(bsexit);
/////////////////////////////////////////////

/*modifypanel starts*/

lsidm=new JLabel("Student ID");
tsidm=new JTextField(" ");
lsnamem=new JLabel("Name");
tsnamem=new JTextField(" ");
lcoursem=new JLabel("Course");

tcoursem=new JTextField(" ");

ldurm=new JLabel("Duration of course");

tdurm=new JTextField(" ");
lfeem=new JLabel("Total fees");

tfeem=new JTextField(" ");
ljoinm=new JLabel("Date of joining");

tjoinm=new JTextField(" ");
ljom=new JLabel("DD-MM-YYYY");

laddm=new JLabel("Address of student");
taddm=new JTextField(" ");





bmodify = new JButton("Modify");
bupdate = new JButton("Update");
bexitm = new JButton("Exit to main menu");

modifypanel=new JPanel();
modifypanel.setBackground(Color.pink);
modifypanel.setLayout(null);

lsidm.setBounds(130,40,220,30);
lsidm.setForeground(Color.black);
modifypanel.add(lsidm);

tsidm.setBounds(250,40,220,30);
tsidm.setForeground(Color.black);
modifypanel.add(tsidm);

lsnamem.setBounds(130,80,220,30);
lsnamem.setForeground(Color.black);
modifypanel.add(lsnamem);

tsnamem.setBounds(250,80,220,30);
tsnamem.setForeground(Color.black);
modifypanel.add(tsnamem);

lcoursem.setBounds(130,120,220,30);
lcoursem.setForeground(Color.black);
modifypanel.add(lcoursem);

tcoursem.setBounds(250,120,220,30);
tcoursem.setForeground(Color.black);
modifypanel.add(tcoursem);

ldurm.setBounds(130,160,220,30);
ldurm.setForeground(Color.black);
modifypanel.add(ldurm);

tdurm.setBounds(250,160,220,30);
tdurm.setForeground(Color.black);
modifypanel.add(tdurm);

lfeem.setBounds(130,200,220,30);
lfeem.setForeground(Color.black);
modifypanel.add(lfeem);

tfeem.setBounds(250,200,220,30);
tfeem.setForeground(Color.black);
modifypanel.add(tfeem);

ljoinm.setBounds(130,240,220,30);
ljoinm.setForeground(Color.black);
modifypanel.add(ljoinm);

tjoinm.setBounds(250,240,220,30);
tjoinm.setForeground(Color.black);
modifypanel.add(tjoinm);

ljom.setBounds(480,240,220,30);
ljom.setForeground(Color.black);
modifypanel.add(ljom);

laddm.setBounds(130,280,220,30);
laddm.setForeground(Color.black);
modifypanel.add(laddm);

taddm.setBounds(250,280,220,30);
taddm.setForeground(Color.black);
modifypanel.add(taddm);

bmodify.setBounds(150,350,140,20);
bmodify.setMnemonic('m');
bmodify.addActionListener(this);
bmodify.setToolTipText("Click here to modify");
modifypanel.add(bmodify);

bupdate.setBounds(320,350,140,20);
bupdate.setMnemonic('u');
bupdate.addActionListener(this);
bupdate.setToolTipText("Click here to update");
modifypanel.add(bupdate);

bexitm.setBounds(490,350,140,20);
bexitm.setMnemonic('E');
bexitm.setToolTipText("Click here to exit");
bexitm.addActionListener(this);
modifypanel.add(bexitm);

//////////////////////////////////////


/*deletepanel starts*/

lsidd=new JLabel("Student ID");
tsidd=new JTextField(" ");
lsnamed=new JLabel("Name");
tsnamed=new JTextField(" ");
lcoursed=new JLabel("Course");

tcoursed=new JTextField(" ");

ldurd=new JLabel("Duration of course");

tdurd=new JTextField(" ");
lfeed=new JLabel("Total fees");

tfeed=new JTextField(" ");
ljoind=new JLabel("Date of joining");

tjoind=new JTextField(" ");
ljod=new JLabel("DD-MM-YYYY");

laddd=new JLabel("Address of student");
taddd=new JTextField(" ");





bdelete = new JButton("Delete");
bconfirm = new JButton("Confirm");
bexitd = new JButton("Exit to main menu");

deletepanel=new JPanel();
deletepanel.setBackground(Color.pink);
deletepanel.setLayout(null);

lsidd.setBounds(130,40,220,30);
lsidd.setForeground(Color.black);
deletepanel.add(lsidd);

tsidd.setBounds(250,40,220,30);
tsidd.setForeground(Color.black);
deletepanel.add(tsidd);

lsnamed.setBounds(130,80,220,30);
lsnamed.setForeground(Color.black);
deletepanel.add(lsnamed);

tsnamed.setBounds(250,80,220,30);
tsnamed.setForeground(Color.black);
deletepanel.add(tsnamed);

lcoursed.setBounds(130,120,220,30);
lcoursed.setForeground(Color.black);
deletepanel.add(lcoursed);

tcoursed.setBounds(250,120,220,30);
tcoursed.setForeground(Color.black);
deletepanel.add(tcoursed);

ldurd.setBounds(130,160,220,30);
ldurd.setForeground(Color.black);
deletepanel.add(ldurd);

tdurd.setBounds(250,160,220,30);
tdurd.setForeground(Color.black);
deletepanel.add(tdurd);

lfeed.setBounds(130,200,220,30);
lfeed.setForeground(Color.black);
deletepanel.add(lfeed);

tfeed.setBounds(250,200,220,30);
tfeed.setForeground(Color.black);
deletepanel.add(tfeed);

ljoind.setBounds(130,240,220,30);
ljoind.setForeground(Color.black);
deletepanel.add(ljoind);

tjoind.setBounds(250,240,220,30);
tjoind.setForeground(Color.black);
deletepanel.add(tjoind);

ljod.setBounds(480,240,220,30);
ljod.setForeground(Color.black);
deletepanel.add(ljod);

laddd.setBounds(130,280,220,30);
laddd.setForeground(Color.black);
deletepanel.add(laddd);

taddd.setBounds(250,280,220,30);
taddd.setForeground(Color.black);
deletepanel.add(taddd);

bdelete.setBounds(150,350,140,20);
bdelete.setMnemonic('d');
bdelete.addActionListener(this);
bdelete.setToolTipText("Click here to delete");
deletepanel.add(bdelete);

bconfirm.setBounds(320,350,140,20);
bconfirm.setMnemonic('c');
bconfirm.addActionListener(this); 
bconfirm.setToolTipText("Click here to confirm");
deletepanel.add(bconfirm);

bexitd.setBounds(490,350,140,20);
bexitd.setMnemonic('E');
bexitd.addActionListener(this);
bexitd.setToolTipText("Click here to exit");
deletepanel.add(bexitd);
/////////////////////////////////////////////

/*searchpanel starts*/

lsids=new JLabel("Student ID");
tsids=new JTextField(" ");
lsnames=new JLabel("Name");
tsnames=new JTextField(" ");
lcourses=new JLabel("Course");

tcourses=new JTextField(" ");

ldurs=new JLabel("Duration of course");

tdurs=new JTextField(" ");
lfees=new JLabel("Total fees");

tfees=new JTextField(" ");
ljoins=new JLabel("Date of joining");

tjoins=new JTextField(" ");


ladds=new JLabel("Address of student");
tadds=new JTextField(" ");


bexits = new JButton("Exit to main menu");
bsearch = new JButton("Search");

searchpanel=new JPanel();
searchpanel.setBackground(Color.pink);
searchpanel.setLayout(null);

lsids.setBounds(130,40,220,30);
lsids.setForeground(Color.black);
searchpanel.add(lsids);

tsids.setBounds(250,40,220,30);
tsids.setForeground(Color.black);
searchpanel.add(tsids);

lsnames.setBounds(130,80,220,30);
lsnames.setForeground(Color.black);
searchpanel.add(lsnames);

tsnames.setBounds(250,80,220,30);
tsnames.setForeground(Color.black);
searchpanel.add(tsnames);

lcourses.setBounds(130,120,220,30);
lcourses.setForeground(Color.black);
searchpanel.add(lcourses);

tcourses.setBounds(250,120,220,30);
tcourses.setForeground(Color.black);
searchpanel.add(tcourses);

ldurs.setBounds(130,160,220,30);
ldurs.setForeground(Color.black);
searchpanel.add(ldurs);

tdurs.setBounds(250,160,220,30);
tdurs.setForeground(Color.black);
searchpanel.add(tdurs);

lfees.setBounds(130,200,220,30);
lfees.setForeground(Color.black);
searchpanel.add(lfees);

tfees.setBounds(250,200,220,30);
tfees.setForeground(Color.black);
searchpanel.add(tfees);

ljoins.setBounds(130,240,220,30);
ljoins.setForeground(Color.black);
searchpanel.add(ljoins);

tjoins.setBounds(250,240,220,30);
tjoins.setForeground(Color.black);
searchpanel.add(tjoins);


ladds.setBounds(130,280,220,30);
ladds.setForeground(Color.black);
searchpanel.add(ladds);

tadds.setBounds(250,280,220,30);
tadds.setForeground(Color.black);
searchpanel.add(tadds);



bexits.setBounds(320,350,140,20);
bexits.setMnemonic('E');
bexits.addActionListener(this);
bexits.setToolTipText("Click here to exit");
searchpanel.add(bexits);

bsearch.setBounds(490,45,130,20);
bsearch.setMnemonic('s');
bsearch.addActionListener(this);
bsearch.setToolTipText("Click here to search");
searchpanel.add(bsearch);

///////////////////////////////////////////

/*buttonpanel starts*/











baddr = new JButton("Add record");
bmodifyr = new JButton("Modify record");
bsearchr = new JButton("Search record");
bdeleter = new JButton("Delete record");
bexit2 = new JButton("Exit");


buttonpanel=new JPanel();
buttonpanel.setBackground(Color.pink);
buttonpanel.setLayout(null);


baddr.setBounds(330,45,130,20);
baddr.setMnemonic('a');
baddr.addActionListener(this);
baddr.setToolTipText("Click here to add");
buttonpanel.add(baddr);

bmodifyr.setBounds(330,95,130,20);
bmodifyr.setMnemonic('m');
bmodifyr.addActionListener(this);
bmodifyr.setToolTipText("Click here to modify");
buttonpanel.add(bmodifyr);

bsearchr.setBounds(330,145,130,20);
bsearchr.setMnemonic('s');
bsearchr.addActionListener(this);
bsearchr.setToolTipText("Click here to search");
buttonpanel.add(bsearchr);

bdeleter.setBounds(330,195,130,20);
bdeleter.setMnemonic('d');
bdeleter.addActionListener(this);
bdeleter.setToolTipText("Click here to delete");
buttonpanel.add(bdeleter);

bexit2.setBounds(330,245,130,20);
bexit2.setMnemonic('E');
bexit2.addActionListener(this);
bexit2.setToolTipText("Click here to exit");
buttonpanel.add(bexit2);





//////////////////////////////////////////
}
public void actionPerformed(ActionEvent e)
{
String u,p;

if(e.getSource()==blogin)
{
 u=tid.getText();
 p=tpwd.getText();
  if(u.equals("Prabal") && p.equals("9813493900"))
  {
  tid.setText("");
  tpwd.setText("");
  tid.requestFocus();
  JOptionPane.showMessageDialog(null,"Welcome to Software","Welcome",0);

  loginpanel.setVisible(false);
  modifypanel.setVisible(false);
  deletepanel.setVisible(false);
  searchpanel.setVisible(false);
  studentpanel.setVisible(false);

  f1.getContentPane().add(buttonpanel);  
  buttonpanel.setVisible(true);


  

  tid.setText("");
  tpwd.setText("");
  tid.requestFocus();
  }
  else
  {
  JOptionPane.showMessageDialog(null,"Wrong Username/Password","Error",0);
  tid.setText("");
  tpwd.setText("");
  tid.requestFocus();
 }
}
else if(e.getSource()==baddr)
{

  loginpanel.setVisible(false);
  modifypanel.setVisible(false);
  deletepanel.setVisible(false);
  searchpanel.setVisible(false);
  buttonpanel.setVisible(false);
  f1.getContentPane().add(studentpanel);  
  studentpanel.setVisible(true);


}
else if(e.getSource()==bmodifyr)
{
  loginpanel.setVisible(false);
  modifypanel.setVisible(false);
  deletepanel.setVisible(false);
  searchpanel.setVisible(false);
  buttonpanel.setVisible(false);
  f1.getContentPane().add(modifypanel);  
  modifypanel.setVisible(true);
}

else if(e.getSource()==bsearchr)
{
  loginpanel.setVisible(false);
  modifypanel.setVisible(false);
  deletepanel.setVisible(false);
  searchpanel.setVisible(false);
  buttonpanel.setVisible(false);
  f1.getContentPane().add(searchpanel);  
  searchpanel.setVisible(true);


}

else if(e.getSource()==bdeleter)
{

  loginpanel.setVisible(false);
  modifypanel.setVisible(false);
  deletepanel.setVisible(false);
  searchpanel.setVisible(false);
  buttonpanel.setVisible(false);
 f1.getContentPane().add(deletepanel);  
 deletepanel.setVisible(true);
}

else if(e.getSource()==bexit2)
{
System.exit(0);
}


else if(e.getSource()==b1exit)
{
System.exit(0);
}

else if(e.getSource()==bsexit)
{
loginpanel.setVisible(false);
modifypanel.setVisible(false);
deletepanel.setVisible(false);
searchpanel.setVisible(false);
studentpanel.setVisible(false);

f1.getContentPane().add(buttonpanel);  
buttonpanel.setVisible(true);
}

else if(e.getSource()==bexitm)
{

loginpanel.setVisible(false);
modifypanel.setVisible(false);
deletepanel.setVisible(false);
searchpanel.setVisible(false);
studentpanel.setVisible(false);

f1.getContentPane().add(buttonpanel);  
buttonpanel.setVisible(true);

}

else if(e.getSource()==bexits)
{

loginpanel.setVisible(false);
modifypanel.setVisible(false);
deletepanel.setVisible(false);
searchpanel.setVisible(false);
studentpanel.setVisible(false);

f1.getContentPane().add(buttonpanel);  
buttonpanel.setVisible(true);

}

else if(e.getSource()==bexitd)
{

loginpanel.setVisible(false);
modifypanel.setVisible(false);
deletepanel.setVisible(false);
searchpanel.setVisible(false);
studentpanel.setVisible(false);

f1.getContentPane().add(buttonpanel);  
buttonpanel.setVisible(true);


}

else if(e.getSource()==badd)
{

addRcrd();


}
else if(e.getSource()==bsave)
{

applyRcrd();

}

else if(e.getSource()==bdelete)
{ 

deleteRcrd();

}
else if(e.getSource()==bconfirm)
{

confirm();

}


else if(e.getSource()==bsearch)
{

searchRcrd();

}

else if(e.getSource()==bmodify)
{
modifyRcrd();
}

else if(e.getSource()==bupdate)
{

updateRcrd();

}
}


public void addRcrd()
{
try
{
r=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Student Id"));
sql="select studentid from student1 where studentid="+r;
try
{
rs=stmt.executeQuery(sql);
while(rs.next())
{
JOptionPane.showMessageDialog(null,"This student id already exists","Note",2);
return;
}
tsid.setText(String.valueOf(r));
tsname.requestFocus();
}catch(SQLException es){System.out.println("Error="+es);}
}
catch(NullPointerException en){System.out.println("Error="+en);}
}
/////////////////////////////////////////////////////////

public void deleteRcrd()
{
r=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter studentid whose record you want to delete"));
try
{

ResultSet rs=stmt.executeQuery("select * from student1 where studentid="+r);
if(rs.next())
{
tsidd.setText(String.valueOf(rs.getInt("studentid")));
tsnamed.setText(rs.getString("name"));
tcoursed.setText(rs.getString("course"));
tdurd.setText(rs.getString("Duration"));
tjoind.setText(rs.getString("joindate"));
tfeed.setText(rs.getString("Totalfees"));
taddd.setText(rs.getString("address"));
}



else
{
JOptionPane.showMessageDialog(null,"No Such record exists");
}

}catch(SQLException e){System.out.println("Error"+e);}
}
////////////////////////////////////////////

public void modifyRcrd()
{
r=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter studentid whose record you want to modify"));
try
{

ResultSet rs=stmt.executeQuery("select * from student1 where studentid="+r);
if(rs.next())
{
tsidm.setText(String.valueOf(rs.getInt("studentid")));
tsnamem.setText(rs.getString("name"));
tcoursem.setText(rs.getString("course"));
tdurm.setText(rs.getString("Duration"));
tjoinm.setText(rs.getString("joindate"));
tfeem.setText(rs.getString("Totalfees"));
taddm.setText(rs.getString("address"));
}



else
{
JOptionPane.showMessageDialog(null,"No Such record exists");
}

}catch(SQLException e){System.out.println("Error"+e);}
}

public void updateRcrd()
{
r=Integer.parseInt(tsidm.getText());
n=tsnamem.getText();
c=tcoursem.getText();
d=tdurm.getText();
d1=tjoinm.getText();
t=tfeem.getText();
a=taddm.getText();
try
{
stmt.executeUpdate("update student1 set name='"+n+"',Course='"+c+"',Duration='"+d+"',joindate='"+d1+"',Totalfees='"+t+"',address='"+a+"' where studentid="+r); 
JOptionPane.showMessageDialog(null,"Record modified sucessfully");
tsidm.setText("");
tsnamem.setText("");
tcoursem.setText("");
tdurm.setText("");
tjoinm.setText("");
tfeem.setText("");
taddm.setText("");
}catch(SQLException e){System.out.println("Error"+e);}
}
///////////////////////////////////////////////////////////////

public void searchRcrd()
{
r=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter studentid whose record you want to search"));
try
{

ResultSet rs=stmt.executeQuery("select * from student1 where studentid="+r);
if(rs.next())
{
tsids.setText(String.valueOf(rs.getInt("studentid")));
tsnames.setText(rs.getString("name"));
tcourses.setText(rs.getString("course"));
tdurs.setText(rs.getString("Duration"));
tjoins.setText(rs.getString("joindate"));
tfees.setText(rs.getString("Totalfees"));
tadds.setText(rs.getString("address"));
}



else
{
JOptionPane.showMessageDialog(null,"No Such record exists");
}

}catch(SQLException e){System.out.println("Error"+e);}
}
void confirm()
{
try
{
int choice=JOptionPane.showConfirmDialog(null,"Do you want to delete this record","Information",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
if(choice==0)
{
r=Integer.parseInt(tsidd.getText());
stmt.executeUpdate("delete from student1 where studentid="+r);
JOptionPane.showMessageDialog(null,"Record deleted sucessfully");
}
else
JOptionPane.showMessageDialog(null,"Record not deleted");

}catch(SQLException e){System.out.println("Error"+e);
}

tsidd.setText("");
tsnamed.setText("");
tcoursed.setText("");
tdurd.setText("");
tjoind.setText("");
tfeed.setText("");
taddd.setText("");

}
public void applyRcrd()
{
r=Integer.parseInt(tsid.getText());
n=tsname.getText();
c=tcourse.getText();
d=tdur.getText();
d1=tjoin.getText();
t=tfee.getText();
a=tadd.getText();
try
{
stmt.executeUpdate("insert into student1 values("+r+",'"+n+"','"+c+"','"+d+"','"+t+"','"+d1+"','"+a+"')");
JOptionPane.showMessageDialog(null,"Record inserted sucessfully");
tsid.setText("");
tsname.setText("");
tcourse.setText("");
tdur.setText("");
tjoin.setText("");
tfee.setText("");
tadd.setText("");
}catch(SQLException e){System.out.println("Error"+e);}
}
public void connection()
{
try
{
Class.forName("com.mysql.jdbc.Driver");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cetpa","root","12345");
stmt=conn.createStatement();
System.out.println("Successfully connected..!");
}catch(SQLException e){System.out.println("Error="+e);}
catch(Exception err){System.out.println("Error="+err);}
}


public static void main(String args[])
{
new data();
}



}