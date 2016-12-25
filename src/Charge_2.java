import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

 class Charge_2  {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	public Charge_2() {
		JFrame frm=new JFrame("收费系统");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 835, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u75C5\u4EBA\u8D26\u5355");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(90, 10, 93, 30);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 266, 151);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 266, 151);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(488, 30, 321, 373);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BE6\u7EC6\u4FE1\u606F");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(123, 10, 85, 33);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8EAB\u4EFD\u8BC1");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 46, 65, 33);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u59D3\u540D");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 96, 65, 33);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u8D39\u7528");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 146, 65, 33);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(133, 46, 110, 33);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(132, 96, 110, 33);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(132, 146, 110, 33);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(167, 317, 144, 41);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\u533B\u751F");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(10, 196, 65, 33);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(132, 196, 110, 33);
		panel_1.add(lblNewLabel_10);
		
		table = new JTable();
		String[] h={"身份证","姓名","费用","医生"};
		SQLMessage sm=new SQLMessage();
	    Object[][]ob=null;
	    ob=sm.getCharge();
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    DefaultTableModel model=new DefaultTableModel(ob,h);
		table.setModel(model);

		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u9009\u62E9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1)
				{
					panel_1.setVisible(true);
					int row=table.getSelectedRow();
					String ID=table.getValueAt(row, 0).toString();
					String name=table.getValueAt(row, 1).toString();
				    String price=table.getValueAt(row, 2).toString();
				    String doctor=table.getValueAt(row, 3).toString();
				    lblNewLabel_5.setText(ID);
				    lblNewLabel_6.setText(name);
				    lblNewLabel_7.setText(price);
				    lblNewLabel_10.setText(doctor);
				    
				}

			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 227, 81, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(128, 227, 81, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u786E\u8BA4\u6536\u8D39");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
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
	         	String sql="delete from Charge where ID ='"+lblNewLabel_5.getText()+"'";
				try {
					st.executeUpdate(sql);
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
				
				Connection con_1=null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//建立数据库连接
				try {
					con_1=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			    Statement st_1=null;
	         	try {
	         		 st_1=con_1.createStatement();
	         	} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         	String sql_1="update orders set count=count+1,Tprice=Tprice+'"+Integer.parseInt( lblNewLabel_7.getText())+"' where name='"+lblNewLabel_10.getText()+"'";
				try {
					st_1.executeUpdate(sql_1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();//增删改一般用executeUpdate方法
				}
				
				try {
					st_1.close();
					con_1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lblNewLabel_8.setText("收费成功");
				SQLMessage sm_1=new SQLMessage();
			    Object[][]ob_1=null;
			    ob_1=sm_1.getCharge();
			    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    DefaultTableModel model_1=new DefaultTableModel(ob_1,h);
				table.setModel(model_1);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_2.setBounds(10, 256, 97, 42);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u7ED3\u675F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_3.setBounds(10, 316, 97, 42);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u5237\u65B0");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SQLMessage sm_1=new SQLMessage();
			    Object[][]ob_1=null;
			    ob_1=sm_1.getCharge();
			    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    DefaultTableModel model_1=new DefaultTableModel(ob_1,h);
				table.setModel(model_1);
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_4.setBounds(300, 40, 86, 37);
		contentPane.add(btnNewButton_4);
	}
}
