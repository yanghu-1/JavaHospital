import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;

public class PLogin {
	public PLogin(){
		Connection con=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement st=null;
		if(con!=null)
			System.out.println("连接成功");
		
			try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		String sql="select * from medicine";
		
		JFrame frm=new JFrame("院长登录");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel top=new JPanel();
		frm.getContentPane().add(top, BorderLayout.NORTH);
		JLabel label=new JLabel("药房储存信息");
		top.add(label);
		
		JPanel center=new JPanel();
		frm.getContentPane().add(center, BorderLayout.CENTER);
		JTextArea area=new JTextArea();
		
		
		
		try {
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//增删改一般用executeUpdate方法
		}
		
		System.out.println(area.getText());
		
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frm.setBounds(400,200,400,200);
		frm.setVisible(true);
		
	}
	

}
