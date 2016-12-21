import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.*;

 class CChose  {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public CChose() {
		JFrame frm=new JFrame("欢迎登陆门诊系统");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(156, 0, 64, 31);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u6302\u53F7");
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(6, 37, 82, 36);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u6536\u8D39");
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(6, 105, 87, 36);
		contentPane.add(rdbtnNewRadioButton_1);
		

		ButtonGroup bg=new ButtonGroup();
		bg.add( rdbtnNewRadioButton);
		bg.add( rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNewRadioButton.isSelected()){
					Charge_1 c=new Charge_1();
				}
				if(rdbtnNewRadioButton_1.isSelected()){
					Charge_2 cc=new Charge_2();
				}
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(6, 187, 82, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frm.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(157, 185, 87, 46);
		contentPane.add(btnNewButton_1);
	}
}
