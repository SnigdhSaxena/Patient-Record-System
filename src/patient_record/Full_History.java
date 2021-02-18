package patient_record;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
public class Full_History extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8803134066972295595L;
	private JFrame frame;
	private PreparedStatement ps;
	private Connection con; 
	private JTable table;
	
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Full_History window = new Full_History();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Full_History() {
		
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 200, 780, 500);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JButton b1 = new JButton("Close");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		b1.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-close-window-48.png"));
		b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b1.setBounds(538, 391, 147, 42);
		frame.getContentPane().add(b1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 39, 715, 314);
		frame.getContentPane().add(scrollPane);
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		btnNewButton = new JButton("Load Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con=DBUtil.getDBConnection();
				try {
					ps=con.prepareStatement("select * from record full outer join report on record.ID=report.ID");
					ResultSet rs=ps.executeQuery();
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
			
		});
		btnNewButton.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\login.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(113, 391, 147, 42);
		frame.getContentPane().add(btnNewButton);
		
		
		
		lblNewLabel = new JLabel("New label");
		ImageIcon icon=new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\texture.jpg");
		Image img=icon.getImage().getScaledInstance(780, 500, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 780, 500);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}
}
