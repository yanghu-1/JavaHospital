import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class Med  {

	private JPanel contentPane;
	private JTable table;

	public Med() {
		JFrame frm=new JFrame();
		frm.setVisible(true);
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u836F\u54C1\u4FE1\u606F\u5E93");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(162, 10, 137, 28);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 35, 414, 216);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 414, 216);
		panel.add(scrollPane);
		
		table = new JTable();
		
		
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
		if(con!=null)
			System.out.println("连接成功");
		
			try {
				st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[] h={"科室","药品","价格","总量"};
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
				Object[][] ob=new Object[list.size()][4];
				for(int i=0;i<list.size();i++)
				{
					Message medicine=(Message)list.get(i);
					ob[i][0]=medicine.getRName();
					ob[i][1]=medicine.getMName();
				    ob[i][2]=medicine.getPrice();
					ob[i][3]=medicine.getNum();
				}
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        DefaultTableModel model=new DefaultTableModel(ob,h);
				table.setModel(model);
			
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
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton.setBounds(39, 0, 75, 28);
		contentPane.add(btnNewButton);
	}

}
