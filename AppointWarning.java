import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

 class AppointWarning {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public AppointWarning() {
		JFrame frm=new JFrame("挂号提示");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 362, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6302\u53F7\u6210\u529F\uFF01");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(98, 10, 117, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u5173\u95ED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(97, 73, 101, 42);
		contentPane.add(btnNewButton);
	}

}
