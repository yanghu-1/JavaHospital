
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

 class Charge_2  {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */

	public Charge_2() {
		JFrame frm=new JFrame("欢迎登陆收费系统");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 450, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(129, 10, 192, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u75C5\u4EBA\u8EAB\u4EFD\u8BC1\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 10, 109, 29);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 64, 173, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(88, 104, 173, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(88, 144, 173, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(88, 184, 173, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(88, 224, 173, 28);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(264, 332, 160, 43);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("\u67E5\u627E");
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
						String Fprice=String.valueOf(rs.getInt("Fprice"));
						textField_1.setText(rs.getString("Name"));
						textField_2.setText(rs.getString("sex"));
						textField_3.setText(age);
						textField_4.setText(rs.getString("RName"));
						textField_6.setText(Fprice);
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
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(345, 5, 68, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 64, 68, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 104, 68, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74\u9F84");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 144,  68, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u79D1\u5BA4");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 184,  68, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("\u603B\u4EF7\r\n");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(10, 224, 68, 28);
		contentPane.add(lblNewLabel_6);

		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u6536\u8D39");
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
					
				    Statement st=null;
		         	try {
		         		 st=con.createStatement();
		         	} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}   
		         	int price=Integer.parseInt(textField_6.getText());
					String sq="update orders set count=count+1 ,Tprice=Tprice+'"+price+"' where RName='"+textField_4.getText()+"'";
					try {
						st.executeUpdate(sq);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();//增删改一般用executeUpdate方法
					}
					
					try {
						st.close();
						//con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
					/*Statement sm=null;
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
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					lblNewLabel_7.setText("收费成功");
		
			}*/
				
			else lblNewLabel_7.setText("收费失败");
			}
				
	}); 
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 332, 98, 43);
		contentPane.add(btnNewButton_1);
		
	
		JButton btnNewButton_2 = new JButton("\u5173\u95ED");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton_2.setBounds(137, 332, 98, 43);
		contentPane.add(btnNewButton_2);
		
	}

}

