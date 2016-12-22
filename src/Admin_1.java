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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Admin_1 {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public Admin_1() {
		JFrame frm=new JFrame("维护系统账号");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 460, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u8D26\u53F7\u7C7B\u578B");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(156, 10, 120, 31);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u9662\u957F");
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(38, 45, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u7BA1\u7406\u5458");
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(38, 95, 121, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u533B\u751F");
		rdbtnNewRadioButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton_2.setBounds(38, 145, 121, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\u836F\u5E08");
		rdbtnNewRadioButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton_3.setBounds(38, 195, 121, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("\u6536\u8D39\u4EBA\u5458");
		rdbtnNewRadioButton_4.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton_4.setBounds(38, 245, 121, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);
		bg.add(rdbtnNewRadioButton_4);

		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()){
					Admin_1_1 ad_1=new Admin_1_1();
				}
				if(rdbtnNewRadioButton_1.isSelected()){
					Admin_1_2 ad_2=new Admin_1_2();
				}
				if(rdbtnNewRadioButton_4.isSelected()){
					CLogin cl=new CLogin();
				}
				if(rdbtnNewRadioButton_3.isSelected()){
					MLogin ml=new MLogin();
				}
			}
		});
		btnNewButton.setBounds(46, 312, 78, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(186, 312, 78, 35);
		contentPane.add(btnNewButton_1);
	}
	

}
