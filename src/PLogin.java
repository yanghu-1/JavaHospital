
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



class PLogin  {

	private JPanel contentPane;
	private  JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		
		
	/**
	 * Create the frame.
	 */
	public PLogin() {
			
	    JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u9662\u957F\u767B\u9646");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(155, 10, 95, 33);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(10, 50, 61, 33);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("\u5BC6  \u7801\r\n");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 123, 61, 33);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(99, 53, 187, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(99, 125, 187, 33);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(241, 196, 183, 42);
		
		JButton button = new JButton("登陆");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				Statement st=null;
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//建立数据库连接
				try {
					con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
					st=con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					String pwd= String.valueOf(passwordField.getPassword());
					String sql="select * from PLogin where Pid='"+textField.getText()+"'and pwd='"+pwd+"'";
					try {
					    ResultSet rs=st.executeQuery(sql);
						if(rs.next()){
							label_2.setText("登陆成功");
							PChose pc=new PChose();
						}
						else label_2.setText("登陆失败");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();//增删改一般用executeUpdate方法
					}
					
					try {
						//rs.close();
						st.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
					
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(10, 198, 69, 40);
		contentPane.add(button);
		
		contentPane.add(label_2);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(123, 198, 74, 40);
		contentPane.add(btnNewButton);
		
	
		contentPane.add(passwordField);
		
	}
}
