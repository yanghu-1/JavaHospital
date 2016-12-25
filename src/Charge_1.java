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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

 class Charge_1  {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */

	public Charge_1() {
		JFrame frm=new JFrame("挂号窗口");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 836, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 398, 262);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(120, 0, 142, 30);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 28, 398, 234);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(526, 10, 284, 407);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(79, 0, 121, 29);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u8EAB\u4EFD\u8BC1");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 40, 72, 29);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u59D3\u540D");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 90, 72, 29);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u6027\u522B");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 140, 72, 29);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u5E74\u9F84");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(10, 189, 72, 30);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u5730\u5740");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(10, 240, 72, 29);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u79D1\u5BA4");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(10, 290, 72, 29);
		panel_1.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(120, 40, 120, 30);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 90, 120, 30);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(120, 140, 120, 30);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(120, 190, 120, 30);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(120, 240, 120, 30);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(120, 290, 120, 30);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u62E9\u79D1\u5BA4");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(418, 10, 83, 34);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		SQLMessage sq=new SQLMessage();;
		String[] str=sq.getRname();
		comboBox.setModel(new DefaultComboBoxModel(str));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.setBounds(418, 51, 83, 34);
		contentPane.add(comboBox);
		String[] h={"身份证","姓名","性别","年龄","地址"};
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText((comboBox.getSelectedItem()).toString()+"病人预约表");
				String str=(comboBox.getSelectedItem()).toString();
				Object[][] ob=null;
				SQLMessage sm=new SQLMessage();
				ob=sm.getAppoint(str);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    DefaultTableModel model=new DefaultTableModel(ob,h);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}			
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(418, 105, 83, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6302\u53F7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()!=-1)
				{
					int row=table.getSelectedRow();
					String id=table.getValueAt(row, 0).toString();
					String name=table.getValueAt(row, 1).toString();
					String sex=table.getValueAt(row, 2).toString();
					int age=Integer.parseInt(table.getValueAt(row, 3).toString());
					String adr=table.getValueAt(row, 4).toString();
					String Rname=comboBox.getSelectedItem().toString();
					
					Connection con_2=null;
					Statement st_2=null;
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
					try {
						st_2=con_2.createStatement();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					String sql_2="insert into PM values('"+id+"','"+name+"','"+sex+"','"+age+"','"+adr+"','"+Rname+"')";
					try {
						st_2.executeUpdate(sql_2);
					
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
					String sql="delete from Appoint where id='"+id+"'";
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
					
					String str=(comboBox.getSelectedItem()).toString();
					Object[][] ob=null;
					SQLMessage sm=new SQLMessage();
					ob=sm.getAppoint(str);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    DefaultTableModel model=new DefaultTableModel(ob,h);
					table.setModel(model);
					scrollPane.setViewportView(table);
					
					AppointWarning aw=new AppointWarning();
				}
				
			}
		});
		
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(10, 307, 83, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				int row=table.getSelectedRow();
				String id=table.getValueAt(row, 0).toString();
				String name=table.getValueAt(row, 1).toString();
				String sex=table.getValueAt(row, 2).toString();
				String age=table.getValueAt(row, 3).toString();
				String adr=table.getValueAt(row, 4).toString();
				String Rname=comboBox.getSelectedItem().toString();
				textField.setText(id);
				textField_1.setText(name);
				textField_2.setText(sex);
				textField_3.setText(age);
				textField_4.setText(adr);
				textField_5.setText(Rname);
				textField.setEditable(false);
				textField_1.setEditable(false);
				textField_2.setEditable(false);
	
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(134, 307, 83, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u9000\u51FA");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_3.setBounds(10, 378, 83, 39);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u6302\u53F7");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con_2=null;
				Statement st_2=null;
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
				try {
					st_2=con_2.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String sql_2="insert into PM values('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+Integer.parseInt(textField_3.getText())+"','"+textField_4.getText()+"','"+textField_5.getText()+"')";
				try {
					st_2.executeUpdate(sql_2);
				
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
				String sql="delete from Appoint where id='"+textField.getText()+"'";
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
				String str=(comboBox.getSelectedItem()).toString();
				Object[][] ob=null;
				SQLMessage sm=new SQLMessage();
				ob=sm.getAppoint(str);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    DefaultTableModel model=new DefaultTableModel(ob,h);
				table.setModel(model);
				scrollPane.setViewportView(table);
				
				AppointWarning aw=new AppointWarning();
				
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_4.setBounds(10, 348, 93, 38);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u53D6\u6D88");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
			}
		});
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_5.setBounds(158, 348, 93, 38);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u5220\u9664");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()!=-1)
				{
					int row=table.getSelectedRow();
					String id=table.getValueAt(row, 0).toString();
					
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
					String sql="delete from Oppoint where id='"+id+"'";
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
					
					String str=(comboBox.getSelectedItem()).toString();
					Object[][] ob=null;
					SQLMessage sm=new SQLMessage();
					ob=sm.getAppoint(str);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    DefaultTableModel model=new DefaultTableModel(ob,h);
					table.setModel(model);
					scrollPane.setViewportView(table);
					
				}
			}
		});
		btnNewButton_6.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_6.setBounds(269, 307, 93, 39);
		contentPane.add(btnNewButton_6);
	}

}
