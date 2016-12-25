import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.*;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

class Dispensing {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;


	/**
	 * Launch the application.
	 */

    public Dispensing() {
    	JFrame frm=new JFrame("药师窗口");
    	frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 508, 476);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 69, 417, 279);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 35, 417, 151);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u75C5\u4EBA\u8EAB\u4EFD\u8BC1");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(13, 21, 118, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(137, 0, 141, 33);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(305, 208, 93, 39);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(27, 378, 179, 43);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(146, 23, 162, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String[] h={"药品","数量","费用"};
		
		JButton btnNewButton = new JButton("\u67E5\u627E");
		btnNewButton.addActionListener(new ActionListener() {
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
				
					String sql="select * from Med where ID='"+textField.getText()+"'";
					try {
					    ResultSet rs=st.executeQuery(sql);
						if(rs.next()){
							panel.setVisible(true);
							lblNewLabel_1.setText(rs.getString("name")+"的药单");
							SQLMessage sm=new SQLMessage();
						    Object[][]ob=null;
						    ob=sm.getMed_1();
						    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						    DefaultTableModel model=new DefaultTableModel(ob,h);
							table.setModel(model);
				
						}
						else lblNewLabel_3.setText("查找不到该病人药单");
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
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(341, 18, 72, 33);
		contentPane.add(btnNewButton);
				
		JButton btnNewButton_1 = new JButton("\u53D1\u836F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()!=-1)
				{
					panel.setVisible(true);
					int row=table.getSelectedRow();
					String MName=table.getValueAt(row, 0).toString();
					int num=Integer.parseInt(table.getValueAt(row,1).toString());
					
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
		         	String sql="delete from Med where MName ='"+MName+"'";
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
					
					Connection con_2=null;
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
		         	try {
		         		 st_2=con_2.createStatement();
		         	} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		         	String sql_1="update medicine set num=num-'"+num+"' where MName='"+MName+"'";
					try {
						st_2.executeUpdate(sql_1);
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
					
					SQLMessage sm=new SQLMessage();
				    Object[][]ob=null;
				    ob=sm.getMed_1();
				    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    DefaultTableModel model=new DefaultTableModel(ob,h);
					table.setModel(model);
					
					lblNewLabel_2.setText("发药成功");
				}
				
				
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(7, 207, 83, 42);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u7ED3\u675F");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(107, 207, 83, 42);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u9000\u51FA");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_3.setBounds(321, 378, 88, 44);
		contentPane.add(btnNewButton_3);
		
		
		
	}

}
