import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Admin  {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public Admin() {
		JFrame frm=new JFrame("药师管理系统");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 453, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u64CD\u4F5C\u7C7B\u578B");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(162, 10, 118, 33);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u589E\u5220\u6539\u7CFB\u7EDF\u8D26\u53F7");
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(38, 55, 161, 29);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u533B\u9662\u79D1\u5BA4\u4FE1\u606F");
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(38, 105, 161, 29);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u836F\u54C1\u4FE1\u606F");
		rdbtnNewRadioButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
		rdbtnNewRadioButton_2.setBounds(38, 155, 161, 29);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\u6536\u8D39\u9879\u76EE\u4FE1\u606F");
		rdbtnNewRadioButton_3.setFont(new Font("宋体", Font.PLAIN, 16));
		rdbtnNewRadioButton_3.setBounds(38, 205, 161, 29);
		contentPane.add(rdbtnNewRadioButton_3);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()){
					Admin_1 ad=new Admin_1();
				}
				if(rdbtnNewRadioButton_1.isSelected()){
					Admin_2 ad=new Admin_2();
				}
				if(rdbtnNewRadioButton_2.isSelected()){
					Admin_3 ad_3=new Admin_3();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 263, 81, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(158, 263, 81, 41);
		contentPane.add(btnNewButton_1);

		
	}

}
