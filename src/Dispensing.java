import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.*;

import java.awt.event.ActionEvent;

class Dispensing {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */

    public Dispensing() {
    	JFrame frm=new JFrame("药师窗口");
    	frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 530, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(145, 13, 172, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u75C5\u4EBA\u8EAB\u4EFD\u8BC1");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 13, 113, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(345, 379, 159, 45);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
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
				String sql="select*from Charge where ID='"+textField.getText()+"'";
				try {
					ResultSet rs=st.executeQuery(sql);
					if (rs.next()){
						String age=String.valueOf(rs.getInt("Age"));
						String num=String.valueOf(rs.getInt("num"));
						textField_1.setText(rs.getString("Name"));
						textField_2.setText(rs.getString("sex"));
						textField_3.setText(age);
						textField_4.setText(rs.getString("RName"));
						textField_5.setText(rs.getString("MName"));
						textField_6.setText(num);
					}
					else lblNewLabel_7.setText("查找不到该病人信息");
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
				
			}
			
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(345, 10, 79, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 74, 54, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 124, 54, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74\u9F84");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 174, 54, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u79D1\u5BA4");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 224, 54, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u836F\u54C1\r\n");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 274,  54, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u6570\u91CF\r\n");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(10, 324, 54, 31);
		contentPane.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 74, 183, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 124, 183, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 174, 183, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 224, 183, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(100, 274, 183, 28);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(100, 324, 183, 28);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u53D1\u836F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_1.getText().length()>0){
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
					Statement sm=null;
					try {
		         		 sm=con.createStatement();
		         	} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				
					String s="delete from Charge where ID='"+textField.getText()+"' and name='"+textField_1.getText()+"'";
					try {
						sm.executeUpdate(s);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();//增删改一般用executeUpdate方法
					}
					
					try {
						sm.close();
						//con.close();
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
			         	
			        	int n=Integer.parseInt(textField_6.getText());
						String sq="update medicine set num=num-'"+n+"' where MName='"+textField_5.getText()+"'";
						try {
							st.executeUpdate(sq);
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
					
					lblNewLabel_7.setText("发药成功");
				}
				else lblNewLabel_7.setText("发药失败");
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(10, 379, 79, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(146, 379, 79, 45);
		contentPane.add(btnNewButton_2);
		
		
	}

}
