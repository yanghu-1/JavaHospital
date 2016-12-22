import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

 class Admin_1_5  {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	public Admin_1_5() {
		JFrame frm=new JFrame("收费人员账号维护系统");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 824, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6536\u8D39\u4EBA\u5458\u8D26\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(140, 10, 134, 28);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 35, 352, 306);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 353, 196);
		panel.add(scrollPane);
		
		table = new JTable();
		String[] h={"账号","密码","用户"};
		SQLLogin sql=new SQLLogin();
	    Object[][]ob=null;
	    ob=sql.getCLogin();
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    DefaultTableModel model=new DefaultTableModel(ob,h);
		table.setModel(model);

		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(447, 35, 301, 298);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(126, 0, 41, 24);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(0, 34, 54, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(0, 84, 54, 24);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(0, 134, 76, 24);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(181, 216, 110, 35);
		panel_1.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(75, 34, 66, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBounds(75, 87, 66, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(75, 137, 66, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		JButton btnNewButton_2 = new JButton("\u66F4\u6539");
		JButton btnNewButton_3 = new JButton("\u589E\u52A0");
		JButton btnNewButton_4 = new JButton("");
		JButton btnNewButton_5 = new JButton("\u53D6\u6D88");
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				btnNewButton_4.setText("确认增加");
				lblNewLabel.setText("增加");
				textField.setEditable(true);
				textField_1.setEditable(true);
				textField_2.setEditable(true);
			}
		});
		
		
		btnNewButton_1.setBounds(116, 231, 73, 31);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()!=-1)
				{
					panel_1.setVisible(true);
					btnNewButton_4.setText("确认删除");
					int row=table.getSelectedRow();
					String account=table.getValueAt(row, 0).toString();
					String pwd=table.getValueAt(row, 1).toString();
					String name=table.getValueAt(row, 2).toString();
					lblNewLabel.setText("删除");
					textField.setText(account);
					textField_1.setText(pwd);
					textField_1.setText(name);
					textField.setEditable(false);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					
				}
			}
		});
		panel.add(btnNewButton_1);
	
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
			}
		});
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_5.setBounds(181, 139,  110, 35);
		panel_1.add(btnNewButton_5);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lblNewLabel.getText().equals("更改")){
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
		         	String sql="update Clogin set pid='"+textField.getText()+"', pwd='"+textField_1.getText()+"' where name='"+textField_2.getText()+"'";
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
					lblNewLabel_6.setText("修改成功");
					SQLLogin sql_1=new SQLLogin();
					Object[][]ob_1=null;
					ob_1=sql_1.getCLogin();
				    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    DefaultTableModel model=new DefaultTableModel(ob_1,h);
					table.setModel(model);
         		}		
				
				if(lblNewLabel.getText().equals("删除")){
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
					String sql="delete from CLogin where pid='"+textField.getText()+"'";
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
					lblNewLabel_6.setText("删除成功");
					SQLLogin sql_2=new SQLLogin();
					Object[][]ob_2=null;
					ob_2=sql_2.getCLogin();
				    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    DefaultTableModel model=new DefaultTableModel(ob_2,h);
					table.setModel(model);
				}
		        	
				if(lblNewLabel.getText().equals("增加")){
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
		         	String sql_1="select * from CLogin where Pid='"+textField.getText()+"'";
		         	try {
		         		ResultSet rs=st.executeQuery(sql_1);
		         		if(rs.next()){
		         			lblNewLabel_6.setText("账号已存在");
		         			try {
								st.close();
								con.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		         		}
		         		else{
		         			try {
								st.close();
								con.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		         			Connection co=null;
							try {
								Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							//建立数据库连接
							try {
								co=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						    Statement s=null;
				         	try {
				         		 s=co.createStatement();
				         	} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				         	String sql="insert into CLogin values('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"')";
							try {
								s.executeUpdate(sql);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();//增删改一般用executeUpdate方法
							}
							
							try {
								s.close();
								co.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							lblNewLabel_6.setText("增加成功");
							SQLLogin sql_3=new SQLLogin();
							Object[][]ob_3=null;
							ob_3=sql_3.getCLogin();
						    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						    DefaultTableModel model=new DefaultTableModel(ob_3,h);
							table.setModel(model);
		         		}   
		         	} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
				}
			}
				
		});
	
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()!=-1)
				{
					panel_1.setVisible(true);
					btnNewButton_4.setText("确认修改");
					int row=table.getSelectedRow();
					String account=table.getValueAt(row, 0).toString();
					String pwd=table.getValueAt(row, 1).toString();
					String name=table.getValueAt(row, 2).toString();
					
					lblNewLabel.setText("更改");
					textField.setText(account);
					textField.setEditable(false);
					textField_1.setText(pwd);
					textField_2.setText(name);
					textField_1.setEditable(true);
					textField_2.setEditable(false);
					
				}
			}
		});
		

		btnNewButton_2.setBounds(0, 231, 73, 31);
		panel.add(btnNewButton_2);
		
		btnNewButton_3.setBounds(235, 231, 73, 31);
		panel.add(btnNewButton_3);
		
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_4.setBounds(181, 30, 110, 35);
		panel_1.add(btnNewButton_4);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton.setBounds(20, 367,  73, 31);
		contentPane.add(btnNewButton);
	}

}
