import java.sql.*;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

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
		if(con!=null)
			System.out.println("连接成功");
		
			try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//String[] h={"科室","药品","价格","总量"};
			String sql="select * from medicine";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setRName(rs.getString("RName"));
					me.setMName(rs.getString("MName"));
					me.setPrice(rs.getInt("price"));
					me.setNum(rs.getInt("num"));
					list.add(me);
					}
				ob=new Object[list.size()][4];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getRName();
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
	public Object[][] getOders(){
		
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
			
			//String[] h={"科室","药品","价格","总量"};
			String sql="select * from orders";
			ArrayList<Message> list=new ArrayList<Message>();
			try {
				ResultSet rs=st.executeQuery(sql);
				while (rs.next()){
					me=new Message();
					me.setRName(rs.getString("RName"));
					me.setDoctor(rs.getString("doctor"));
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
}

			
	


	
