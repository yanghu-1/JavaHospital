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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

 class Charge  {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	public Charge() {
		JFrame frm=new JFrame("医院账单");
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 434, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u533B\u9662\u8D26\u76EE\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(73, 10, 124, 33);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 52, 333, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 333, 193);
		panel.add(scrollPane);
		
		table = new JTable();
		SQLMessage sm=new SQLMessage();
		String[]h={"身份证","姓名","费用","医生"};
		Object[][] ob=null;
		ob=sm.getCharge();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    DefaultTableModel model=new DefaultTableModel(ob,h);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 271, 83, 42);
		contentPane.add(btnNewButton);
	}
}
