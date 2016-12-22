
import java.sql.*;
import java.util.ArrayList;

public class SQLLogin {
	
	public Object[][] getALogin(){
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
			
			String sql="select * from ALogin";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setAccount(rs.getString("pid"));
					me.setPwd(rs.getString("pwd"));
					me.setName(rs.getString("name"));
					list.add(me);
					}
				ob=new Object[list.size()][3];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getAccount();
					ob[i][1]=medicine.getPwd();
				    ob[i][2]=medicine.getName();
				
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
	
	public Object[][] getPLogin(){
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
			
			String sql="select * from PLogin";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setAccount(rs.getString("pid"));
					me.setPwd(rs.getString("pwd"));
					me.setName(rs.getString("name"));
					list.add(me);
					}
				ob=new Object[list.size()][3];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getAccount();
					ob[i][1]=medicine.getPwd();
				    ob[i][2]=medicine.getName();
				
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
	public Object[][] getDLogin(){
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
			
			String sql="select * from DLogin";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setAccount(rs.getString("Did"));
					me.setPwd(rs.getString("Dpwd"));
					me.setName(rs.getString("name"));
					list.add(me);
					}
				ob=new Object[list.size()][3];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getAccount();
					ob[i][1]=medicine.getPwd();
				    ob[i][2]=medicine.getName();
				
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
	public Object[][] getMLogin(){
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
			
			String sql="select * from MLogin";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setAccount(rs.getString("Mid"));
					me.setPwd(rs.getString("Mpwd"));
					me.setName(rs.getString("name"));
					list.add(me);
					}
				ob=new Object[list.size()][3];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getAccount();
					ob[i][1]=medicine.getPwd();
				    ob[i][2]=medicine.getName();
				
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
	public Object[][] getCLogin(){
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
			
			String sql="select * from CLogin";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setAccount(rs.getString("pid"));
					me.setPwd(rs.getString("pwd"));
					me.setName(rs.getString("name"));
					list.add(me);
					}
				ob=new Object[list.size()][3];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getAccount();
					ob[i][1]=medicine.getPwd();
				    ob[i][2]=medicine.getName();
				
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


}
