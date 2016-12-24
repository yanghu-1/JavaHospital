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
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

 class Hall  {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	public Hall() {
		JFrame frm=new JFrame("大厅");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 587, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 304, 272);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(110, 0, 83, 30);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, 303, 159);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	
		SQLMessage sm=new SQLMessage();
		String[]str=sm.getRname();
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(str));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox.setBounds(338, 46, 82, 37);
		contentPane.add(comboBox);
		
		String[] h={"姓名","性别","年龄"};
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(0, 224, 83, 38);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5237\u65B0");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=comboBox.getSelectedItem().toString();
				lblNewLabel.setText(str);
				SQLMessage sm=new SQLMessage();
				Object[][] ob=null;
				ob=sm.getPM_1(str);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    DefaultTableModel model=new DefaultTableModel(ob,h);
				table.setModel(model);
				scrollPane.setViewportView(table);
			
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(150, 224, 83, 38);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u62E9\u79D1\u5BA4");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(338, 10, 82, 37);
		contentPane.add(lblNewLabel_1);
		
	
		JButton btnNewButton = new JButton("\u67E5\u627E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
				String str=comboBox.getSelectedItem().toString();
				lblNewLabel.setText(str);
				SQLMessage sm=new SQLMessage();
				Object[][] ob=null;
				ob=sm.getPM_1(str);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    DefaultTableModel model=new DefaultTableModel(ob,h);
				table.setModel(model);
				scrollPane.setViewportView(table);
	
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(338, 102, 82, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("\u5173\u95ED");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_3.setBounds(10, 317, 93, 43);
		contentPane.add(btnNewButton_3);
	}
}
