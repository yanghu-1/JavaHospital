
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 class PChose {

	public JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PChose() {
		JFrame frame=new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u9009\u62E9\u64CD\u4F5C");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(162, 0, 72, 44);
		contentPane.add(label);
		
		JRadioButton radioButton = new JRadioButton("\u67E5\u8BE2\u836F\u54C1\u4FE1\u606F");
		radioButton.setFont(new Font("宋体", Font.PLAIN, 18));
		radioButton.setBounds(20, 47, 148, 44);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u67E5\u8BE2\u79D1\u5BA4\u4FE1\u606F");
		radioButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		radioButton_1.setBounds(24, 126, 144, 38);
		contentPane.add(radioButton_1);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add( radioButton);
		bg.add( radioButton_1);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioButton.isSelected()){
					Med med=new Med();
				}
				if(radioButton_1.isSelected()){
					Oders od=new Oders();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(24, 205, 101, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(238, 205, 101, 38);
		contentPane.add(btnNewButton_1);
	}
}
