import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Begin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Begin frame = new Begin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Begin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u767B\u9646");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(146, 0, 102, 35);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u9662\u957F");
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(38, 45, 90, 35);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u7BA1\u7406\u5458");
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(38, 92, 90, 35);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u533B\u751F");
		rdbtnNewRadioButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton_2.setBounds(38, 141, 121, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\u836F\u5E08");
		rdbtnNewRadioButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton_3.setBounds(38, 184, 121, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("\u6536\u8D39\u4EBA\u5458");
		rdbtnNewRadioButton_4.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton_4.setBounds(38, 234, 121, 23);
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
					PLogin pl=new PLogin();
				}
				if(rdbtnNewRadioButton_1.isSelected()){
					ALogin al=new ALogin();
				}
				if(rdbtnNewRadioButton_2.isSelected()){
					DLogin dl=new DLogin();
				}
				if(rdbtnNewRadioButton_4.isSelected()){
					CLogin cl=new CLogin();
				}
				if(rdbtnNewRadioButton_3.isSelected()){
					MLogin ml=new MLogin();
				}
			}
		});
		btnNewButton.setBounds(38, 289, 90, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5F00\u542F\u5927\u5385");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hall hall=new Hall();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(146, 289, 111, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u7F51\u4E0A\u9884\u7EA6");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Appoint app=new Appoint();
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(293, 289, 121, 41);
		contentPane.add(btnNewButton_2);
	}
}
