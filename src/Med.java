
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

class Med  {

	private JPanel contentPane;
	private JTable table;

	public Med() {
		JFrame frm=new JFrame();
		frm.setVisible(true);
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 762, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u836F\u54C1\u4FE1\u606F\u5E93");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(162, 10, 137, 28);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 35, 421, 321);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 419, 189);
		panel.add(scrollPane);
		
		table = new JTable();
		String[] h={"编号","药品","价格","总量"};
		
		SQLMessage sql=new SQLMessage();
	    Object[][]ob=null;
	    ob=sql.getMed();
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
		btnNewButton.setBounds(39, 0,  73, 31);
		contentPane.add(btnNewButton);
	}

}

