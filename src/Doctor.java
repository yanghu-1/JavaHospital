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
	private JTextField textField_4;

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
		
		JComboBox<String> comboBox = new JComboBox<String>();
		SQLMessage sq=new SQLMessage();;
		String[] str=sq.getRname();
		comboBox.setModel(new DefaultComboBoxModel(str));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"内科","皮肤科","鼻科","眼科"}));
		comboBox.setBounds(325, 52, 98, 43);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox.setEditable(true);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u79D1\u5BA4");
		lblNewLabel.setBounds(325, 10, 98, 32);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(97, 10, 127, 32);
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
		
		String[] h={"身份证","姓名","性别","年龄"};
		String[] h_1={"药品","数量","价格"};
		
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
				
				
				
				SQLMessage sm=new SQLMessage();
				Object[][] ob=null;
				String str=lblNewLabel_7.getText();
				ob=sm.getMed(str);
				table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    DefaultTableModel model=new DefaultTableModel(ob,h_1);
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
				String sql_1="delete from PM where id='"+lblNewLabel_7.getText()+"'";
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
	         	
	         	String sql="insert into Charge values('"+lblNewLabel_7.getText()+"', '"+lblNewLabel_8.getText()+"','"+Integer.parseInt(textField_3.getText())+"','"+textField_4.getText()+"')";
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
				
				lblNewLabel_1.setText(comboBox.getSelectedItem().toString());
				SQLMessage sm=new SQLMessage();
				String str=comboBox.getSelectedItem().toString();
				Object[][]ob=null;
				ob=sm.getPM(str);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    DefaultTableModel model=new DefaultTableModel(ob,h);
				table.setModel(model);
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
				lblNewLabel_1.setText(comboBox.getSelectedItem().toString());
				SQLMessage sm=new SQLMessage();
				String str=comboBox.getSelectedItem().toString();
				Object[][]ob=null;
				ob=sm.getPM(str);
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
					String id=table.getValueAt(row, 0).toString();
					String name=table.getValueAt(row, 1).toString();
					lblNewLabel_7.setText(id);
					lblNewLabel_8.setText(name);
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
		btnNewButton_4.setBounds(113, 325, 82, 43);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_11 = new JLabel("\u533B\u751F\u7B7E\u5B57");
		lblNewLabel_11.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(10, 387, 82, 39);
		contentPane.add(lblNewLabel_11);
		
		textField_4 = new JTextField();
		textField_4.setBounds(113, 390, 106, 38);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		
	
	}
}
