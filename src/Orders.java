
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 class Orders {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	public Orders() {
		JFrame frm=new JFrame();
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(92, 61, 266, 190);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		String[] h={"科室","医生","病人数量","总费用"};
		SQLMessage sql=new SQLMessage();
	    Object[][]ob=null;
	    ob=sql.getOrders();
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    DefaultTableModel model=new DefaultTableModel(ob,h);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u533B\u9662\u6536\u5165\u8BB0\u5F55");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(153, 10, 96, 41);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm.setVisible(false);
			}
		});
		btnNewButton.setBounds(0, 10, 73, 35);
		contentPane.add(btnNewButton);
	}
}

