import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;


class Admin_2 {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	public Admin_2() {
		JFrame frm=new JFrame("医院科室信息管理");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 769, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("\u79D1\u5BA4\u8D26\u76EE\u4FE1\u606F");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(132, 10, 137, 28);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 35, 352, 306);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 353, 196);
		panel.add(scrollPane);
		
		table = new JTable();
		String[] h={"科室","医生","看病人数","总价"};
		SQLMessage sql=new SQLMessage();
	    Object[][]ob=null;
	    ob=sql.getOrders();
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    DefaultTableModel model=new DefaultTableModel(ob,h);
		table.setModel(model);

		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(447, 35, 301, 297);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(126, 0, 41, 24);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u79D1\u5BA4");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(0, 34, 54, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u533B\u751F");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(0, 84, 54, 24);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u770B\u75C5\u4EBA\u6570");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(0, 134, 76, 24);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u603B\u4EF7");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(0, 181, 54, 15);
		panel_1.add(lblNewLabel_4);
		
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
		
		textField_3 = new JTextField();
		textField_3.setBounds(75, 179, 66, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
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
				textField_3.setEditable(true);
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
					String RName=table.getValueAt(row, 0).toString();
					String name=table.getValueAt(row, 1).toString();
					int count=Integer.parseInt(table.getValueAt(row, 2).toString());
					int Tprice=Integer.parseInt(table.getValueAt(row, 3).toString());
					lblNewLabel.setText("删除");
					textField.setText(RName);
					textField_1.setText(name);
					textField_2.setText(String.valueOf(count));
					textField_3.setText(String.valueOf(Tprice));
					textField.setEditable(false);
					textField_1.setEditable(false);
					textField_2.setEditable(false);
					textField_3.setEditable(false);
					
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
					String sql="update orders set name='"+textField_1.getText()+"', count='"+Integer.parseInt(textField_2.getText())+"', Tprice='"+Integer.parseInt(textField_3.getText())+"'where RName='"+textField.getText()+"'";
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
					SQLMessage sql_1=new SQLMessage();
					Object[][]ob_1=null;
					ob_1=sql_1.getOrders();
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
					String sql="delete from orders where RName='"+textField.getText()+"'";
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
					SQLMessage sql_2=new SQLMessage();
					Object[][]ob_2=null;
					ob_2=sql_2.getOrders();
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
		         	String sql_1="select * from orders where RName='"+textField.getText()+"'";
		         	try {
		         		ResultSet rs=st.executeQuery(sql_1);
		         		if(rs.next()){
		         			lblNewLabel_6.setText("科室已存在");
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
				         	String sql="insert into orders values('"+textField.getText()+"','"+textField_1.getText()+"','"+Integer.parseInt(textField_2.getText())+"','"+Integer.parseInt(textField_3.getText())+"')";
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
							SQLMessage sql_3=new SQLMessage();
							Object[][]ob_3=null;
							ob_3=sql_3.getOrders();
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
					String RName=table.getValueAt(row, 0).toString();
					String name=table.getValueAt(row, 1).toString();
					int count=Integer.parseInt(table.getValueAt(row, 2).toString());
					int Tprice=Integer.parseInt(table.getValueAt(row, 3).toString());
					
					lblNewLabel.setText("更改");
					textField.setText(RName);
					textField.setEditable(false);
					textField_1.setText(name);
					textField_2.setText(String.valueOf(count));
					textField_3.setText(String.valueOf(Tprice));
					textField_1.setEditable(true);
					textField_2.setEditable(true);
					textField_3.setEditable(true);
					
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
