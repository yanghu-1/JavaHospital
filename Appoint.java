
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class Appoint  {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
    Appoint() {
    	JFrame frm=new JFrame("网上预约");
	    frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 474, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u586B\u5199\u4E2A\u4EBA\u4FE1\u606F");
		lblNewLabel.setBounds(138, 10, 95, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8EAB\u4EFD\u8BC1");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 45, 68, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3  \u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 84, 68, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027  \u522B");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 124, 68, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5E74  \u9F84");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(10, 164, 68, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u5730  \u5740");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 204, 68, 28);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u79D1  \u5BA4");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(10, 244, 68, 28);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(102, 42, 193, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 87, 193, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 127, 193, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(102, 167, 193, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	
		textField_4 = new JTextField();
		textField_4.setBounds(102, 207,193, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(102, 247, 193, 28);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(304, 319, 121, 42);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("\u9884\u7EA6");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 319, 83, 42);
		contentPane.add(btnNewButton);
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
	         	int age=Integer.parseInt(textField_3.getText());
				String sql="insert into Appoint values ('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+age+"','"+textField_4.getText()+"','"+textField_5.getText()+"')";
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
				lblNewLabel_7.setText("信息添加成功");
				
		}
	}); 

		JButton btnNewButton_1 = new JButton("\u5173\u95ED");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frm.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(172, 319, 83, 42);
		contentPane.add(btnNewButton_1);
		
	}
}

