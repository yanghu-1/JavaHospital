import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

class Doctor {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	
	public Doctor() {
		JFrame frm=new JFrame("医生看病窗口");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 911, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 52, 305, 236);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 305, 199);
		panel.add(scrollPane);
		
		table = new JTable();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(325, 52, 98, 43);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"内科","鼻科","皮肤科","眼科"}));
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u79D1\u5BA4");
		lblNewLabel.setBounds(325, 10, 98, 32);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u75C5\u4EBA\u4FE1\u606F");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(106, 9, 82, 32);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(451, 10, 422, 416);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("\u836F\u5355");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(150, 0, 48, 30);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 37, 353, 111);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 353, 111);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u8EAB\u4EFD\u8BC1");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 170, 70, 30);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u59D3\u540D");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 220, 70, 30);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u836F\u54C1\r\n");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 270, 70, 30);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u6570\u91CF");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(10, 320, 70, 30);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(112, 170,94,30);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(112, 220, 100,30);
		panel_1.add(lblNewLabel_8);
		
		
		textField = new JTextField();
		textField.setBounds(112, 270, 100, 30);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 320, 100, 30);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u6DFB\u52A0");
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
	         	int num=Integer.parseInt(textField_1.getText());
	         	int Tprice=0;
	         	String sq="select * from medicine where MName='"+textField.getText()+"'";
	         	ResultSet rs=null;
	         	try{
	         		rs=st.executeQuery(sq);
	         		while(rs.next()){
	         			int price=rs.getInt("price");
	         			Tprice=price*num;
	         		}
	         	}catch (SQLException e) {
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
	         	String sql="insert into Med values('"+lblNewLabel_7.getText()+"', '"+lblNewLabel_8.getText()+"','"+textField.getText()+"','"+num+"','"+Tprice+"')";
				try {
					st_1.executeUpdate(sql);
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
				

		      	String[] h={"身份证","姓名","药品","数量","价格"};
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
					
					String sl="select * from Med where ID='"+lblNewLabel_7.getText()+"'";
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
					table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    DefaultTableModel model=new DefaultTableModel(ob,h);
					table_1.setModel(model);
					scrollPane.setViewportView(table);
				
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(10, 363, 84, 43);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u9000\u51FA");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_3.setBounds(122, 363, 84, 43);
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_9 = new JLabel("\u8BCA\u65AD\u8D39\u7528");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(249, 220, 84, 25);
		panel_1.add(lblNewLabel_9);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setBounds(249, 177, 84, 33);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(249, 277, 84, 33);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u603B\u8D39\u7528");
		lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(249, 320, 84, 30);
		panel_1.add(lblNewLabel_10);
		
		JButton btnNewButton_5 = new JButton("\u63D0\u4EA4");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con_3=null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//建立数据库连接
				try {
					con_3=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			    Statement st_3=null;
	         	try {
	         		 st_3=con_3.createStatement();
	         	} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         	
	         	String sql_3="insert into Charge values('"+lblNewLabel_7.getText()+"', '"+lblNewLabel_8.getText()+"','"+Integer.parseInt(textField_3.getText())+"')";
				try {
					st_3.executeUpdate(sql_3);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();//增删改一般用executeUpdate方法
				}
				
				try {
					st_3.close();
					con_3.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Connection con_4=null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//建立数据库连接
				try {
					con_4=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			    Statement st_4=null;
	         	try {
	         		 st_4=con_4.createStatement();
	         	} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      
	         	String sq_4="delete from PM where id='"+lblNewLabel_7.getText()+"'";
				try {
					st_4.executeUpdate(sq_4);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();//增删改一般用executeUpdate方法
				}
				
				try {
					st_4.close();
					con_4.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Connection con_5=null;
				Message me_5=null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//建立数据库连接
				try {
					con_5=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Statement st_5=null;
				Object[][] ob_5=null;
					try {
						st_5=con_5.createStatement();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			      	String[] h_5={"科室","身份证","姓名","性别","年龄"};
					String sql_5="select * from PM where RName='"+comboBox.getSelectedItem()+"'";
					ArrayList<Message> list_5=new ArrayList<Message>();
					try {
						ResultSet rs_5=st_5.executeQuery(sql_5);
						while (rs_5.next()){
							me_5=new Message();
							me_5.setRName(rs_5.getString("Rname"));
							me_5.setID(rs_5.getString("ID"));
							me_5.setName(rs_5.getString("name"));
							me_5.setSex(rs_5.getString("sex"));
							me_5.setAge(rs_5.getInt("age"));
							//me.setAddress(rs.getString("adr"));
							list_5.add(me_5);
							}
						ob_5=new Object[list_5.size()][5];
						for(int i=0;i<list_5.size();i++)
						{
							Message medicine_5=(Message)list_5.get(i);
							ob_5[i][0]=medicine_5.getRName();
							ob_5[i][1]=medicine_5.getID();
							ob_5[i][2]=medicine_5.getName();
							ob_5[i][3]=medicine_5.getSex();
							ob_5[i][4]=medicine_5.getAge();
							
						}
						
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();//增删改一般用executeUpdate方法
					}
					
					try {
						st_5.close();
						con_5.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    DefaultTableModel model_5=new DefaultTableModel(ob_5,h_5);
					table.setModel(model_5);
					scrollPane.setViewportView(table);
					
					panel_1.setVisible(false);
					Warning wa=new Warning();
			}
				
		});
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_5.setBounds(249, 362, 78, 44);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton = new JButton("\u67E5\u627E");
		btnNewButton.setBounds(325, 117, 82, 43);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
					
			      	String[] h={"科室","身份证","姓名","性别","年龄"};
					String sql="select * from PM where RName='"+comboBox.getSelectedItem()+"'";
					ArrayList<Message> list=new ArrayList<Message>();
					try {
						ResultSet rs=st.executeQuery(sql);
						while (rs.next()){
							me=new Message();
							me.setRName(rs.getString("Rname"));
							me.setID(rs.getString("ID"));
							me.setName(rs.getString("name"));
							me.setSex(rs.getString("sex"));
							me.setAge(rs.getInt("age"));
							//me.setAddress(rs.getString("adr"));
							list.add(me);
							}
						ob=new Object[list.size()][5];
						for(int i=0;i<list.size();i++)
						{
							Message medicine=(Message)list.get(i);
							ob[i][0]=medicine.getRName();
							ob[i][1]=medicine.getID();
						    ob[i][2]=medicine.getName();
							ob[i][3]=medicine.getSex();
							ob[i][4]=medicine.getAge();
							
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
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    DefaultTableModel model=new DefaultTableModel(ob,h);
					table.setModel(model);
					scrollPane.setViewportView(table);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8BCA\u65AD");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()!=-1)
				{
					panel_1.setVisible(true);
					int row=table.getSelectedRow();
					String id=table.getValueAt(row, 1).toString();
					String name=table.getValueAt(row, 2).toString();
					
					lblNewLabel_7.setText(id);
					lblNewLabel_8.setText(name);
					
					String[] h_6={"身份证","姓名","药品","数量","价格"};
					Connection con_6=null;
					Message me=null;
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//建立数据库连接
					try {
						con_6=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Statement st_6=null;
					Object[][] ob_6=null;
					
						try {
							st_6=con_6.createStatement();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						String sql_6="select * from Med where ID='"+lblNewLabel_7.getText()+"'";
						ArrayList<Message> list_6=new ArrayList<Message>();
						try {
							ResultSet rs_6=st_6.executeQuery(sql_6);
							while (rs_6.next()){
								me=new Message();
								me.setID(rs_6.getString("ID"));
								me.setName(rs_6.getString("name"));
								me.setMName(rs_6.getString("MName"));
								me.setNum(rs_6.getInt("num"));
								me.setPrice(rs_6.getInt("price"));
								list_6.add(me);
								}
							ob_6=new Object[list_6.size()][5];
							for(int i=0;i<list_6.size();i++)
							{
								Message medicine=(Message)list_6.get(i);
								ob_6[i][0]=medicine.getID();
								ob_6[i][1]=medicine.getName();
							    ob_6[i][2]=medicine.getMName();
								ob_6[i][3]=medicine.getNum();
								ob_6[i][4]=medicine.getPrice();
								
							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();//增删改一般用executeUpdate方法
						}
						
						try {
							st_6.close();
							con_6.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					    DefaultTableModel model_6=new DefaultTableModel(ob_6,h_6);
						table_1.setModel(model_6);
						scrollPane.setViewportView(table);
					
					
				}
			}
		});
		btnNewButton_1.setBounds(10, 325, 82, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("\u9000\u51FA");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_4.setBounds(151, 325, 82, 43);
		contentPane.add(btnNewButton_4);
		
		
		
	
	}
}
