
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;

public class SQLMessage {
	
	public Object[][] getMed(){
		
		Connection con=null;
		Message me=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//建立数据库连接
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement st=null;
		Object[][] ob=null;
			try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sql="select * from medicine order by iden";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setIden(rs.getInt("iden"));
					me.setMName(rs.getString("MName"));
					me.setPrice(rs.getInt("price"));
					me.setNum(rs.getInt("num"));
					list.add(me);
					}
				ob=new Object[list.size()][4];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getIden();
					ob[i][1]=medicine.getMName();
				    ob[i][2]=medicine.getPrice();
					ob[i][3]=medicine.getNum();
				}
				
				/*table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        DefaultTableModel model=new DefaultTableModel(ob,h);
				table.setModel(model);*/
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//增删改一般用executeUpdate方法
			}
			
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ob;
	}
	
	public Object[][] getMed_1(){
		Connection con=null;
		Message me=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//建立数据库连接
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement st=null;
		Object[][] ob=null;
			try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sql="select * from Med ";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setMName(rs.getString("MName"));
					me.setNum(rs.getInt("num"));
					me.setPrice(rs.getInt("price"));
					list.add(me);
					}
				ob=new Object[list.size()][3];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getMName();
					ob[i][2]=medicine.getNum();
				    ob[i][1]=medicine.getPrice();
					
				}
				
				/*table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        DefaultTableModel model=new DefaultTableModel(ob,h);
				table.setModel(model);*/
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//增删改一般用executeUpdate方法
			}
			
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ob;
	}
	
	public Object[][] getOrders(){
		Connection con=null;
		Message me=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//建立数据库连接
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement st=null;
		Object[][] ob=null;
		if(con!=null)
		
			try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sql="select * from orders order by Tprice";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setRName(rs.getString("RName"));
					me.setDoctor(rs.getString("name"));
					me.setCount(rs.getInt("count"));
					me.setTPrice(rs.getInt("Tprice"));
					list.add(me);
					}
				ob=new Object[list.size()][4];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getRName();
					ob[i][1]=medicine.getDoctor();
				    ob[i][2]=medicine.getCount();
					ob[i][3]=medicine.getTPrice();
				}
				
				/*table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        DefaultTableModel model=new DefaultTableModel(ob,h);
				table.setModel(model);*/
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//增删改一般用executeUpdate方法
			}
			
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ob;
	}
	public Object[][] getCharge(){
		Connection con=null;
		Message me=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//建立数据库连接
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement st=null;
		Object[][] ob=null;
			try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sql="select * from Charge order by Fprice";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setID(rs.getString("ID"));
					me.setName(rs.getString("name"));
					me.setPrice(rs.getInt("Fprice"));
					list.add(me);
					}
				ob=new Object[list.size()][3];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getID();
					ob[i][1]=medicine.getName();
					ob[i][2]=medicine.getPrice();
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//增删改一般用executeUpdate方法
			}
			
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ob;
	}
	
	public String[] getRname(){
		Connection con=null;
		Message me=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//建立数据库连接
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement st=null;
			try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sql="select * from orders ";
			String[] str=null;
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setRName(rs.getString("RName"));
					list.add(me);
					}
				str=new String[list.size()];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					str[i]=medicine.getRName();
					
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//增删改一般用executeUpdate方法
			}
			
			
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return str;
	}
	
	public Object[][] getAppoint(String str){
		Connection con=null;
		Message me=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//建立数据库连接
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement st=null;
		Object[][] ob=null;
		
			try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sql="select * from Oppoint where Rname='"+str+"'";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setID(rs.getString("ID"));
					me.setName(rs.getString("name"));
					me.setSex(rs.getString("sex"));
					me.setAge(rs.getInt("age"));
					me.setAddress(rs.getString("adr"));
					list.add(me);
					}
				ob=new Object[list.size()][5];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getID();
				    ob[i][1]=medicine.getName();
					ob[i][2]=medicine.getSex();
					ob[i][3]=medicine.getAge();
					ob[i][4]=medicine.getAddress();
					
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//增删改一般用executeUpdate方法
			}
			
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ob;
	
	}
	
	public Object[][] getPM(String str){
		Connection con=null;
		Message me=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//建立数据库连接
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement st=null;
		Object[][] ob=null;
		
			try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sql="select * from PM where RName='"+str+"'";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setID(rs.getString("ID"));
					me.setName(rs.getString("name"));
					me.setSex(rs.getString("sex"));
					me.setAge(rs.getInt("age"));
					//me.setAddress(rs.getString("adr"));
					list.add(me);
					}
				ob=new Object[list.size()][4];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getID();
				    ob[i][1]=medicine.getName();
					ob[i][2]=medicine.getSex();
					ob[i][3]=medicine.getAge();
					
				}
				
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//增删改一般用executeUpdate方法
			}
			
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ob;
	}
	public Object[][] getMed(String str){
		Connection con_2=null;
		Message me=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//建立数据库连接
		try {
			con_2=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement st_2=null;
		Object[][] ob=null;
		
			try {
				st_2=con_2.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sl="select * from Med where ID='"+str+"'";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet sr=st_2.executeQuery(sl);
				while (sr.next()){
					me=new Message();
					me.setID(sr.getString("ID"));
					me.setName(sr.getString("name"));
					me.setMName(sr.getString("MName"));
					me.setNum(sr.getInt("num"));
					me.setPrice(sr.getInt("price"));
					list.add(me);
					}
				ob=new Object[list.size()][5];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getID();
					ob[i][1]=medicine.getName();
				    ob[i][2]=medicine.getMName();
					ob[i][3]=medicine.getNum();
					ob[i][4]=medicine.getPrice();
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//增删改一般用executeUpdate方法
			}
			
			try {
				st_2.close();
				con_2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ob;
		
	}
	public Object[][] getPM_1(String str){
		Connection con=null;
		Message me=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//建立数据库连接
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement st=null;
		Object[][] ob=null;
		
			try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String sql="select * from PM where RName='"+str+"'";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setName(rs.getString("name"));
					me.setSex(rs.getString("sex"));
					me.setAge(rs.getInt("age"));
					//me.setAddress(rs.getString("adr"));
					list.add(me);
					}
				ob=new Object[list.size()][3];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);;
				    ob[i][0]=medicine.getName();
					ob[i][1]=medicine.getSex();
					ob[i][2]=medicine.getAge();	
				}
				
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//增删改一般用executeUpdate方法
			}
			
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ob;
	}


}


			

