package patient_record;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Add_DiagnosisInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6611036899573600788L;
	private JFrame frame;
	private JTextField t1;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton b2;
	private JButton b3;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JLabel l7;
	private JLabel l5;
	private JLabel l6;
	private PreparedStatement ps;
	private Connection con;
	private int flag=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_DiagnosisInfo window = new Add_DiagnosisInfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Add_DiagnosisInfo() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 200, 780, 600);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		con=DBUtil.getDBConnection();
		
		JLabel l1 = new JLabel("Patient ID");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1.setBounds(85, 33, 114, 29);
		frame.getContentPane().add(l1);
		
		t1 = new JTextField();
		t1.setBounds(304, 33, 219, 26);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JButton b1 = new JButton("Search");
		ImageIcon icon=new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-search-48.png");
		Image img=icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		b1.setIcon(new ImageIcon(img));
		
		b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b1.setBounds(543, 33, 157, 28);
		frame.getContentPane().add(b1);
		
		b2 = new JButton("Save");
		
		b2.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-save-48.png"));
		b2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b2.setBounds(66, 515, 157, 42);
		frame.getContentPane().add(b2);
		
		b3 = new JButton("Close");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do yo want to close?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					frame.dispose();
					
				}
			}
		});
		b3.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-close-window-48.png"));
		b3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b3.setBounds(516, 515, 151, 42);
		frame.getContentPane().add(b3);
		
		l2 = new JLabel("Symptoms");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l2.setBounds(27, 261, 98, 26);
		frame.getContentPane().add(l2);
		
		l3 = new JLabel("Diagnosis");
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l3.setBounds(27, 340, 98, 26);
		frame.getContentPane().add(l3);
		
		l4 = new JLabel("Medicine");
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l4.setBounds(27, 420, 98, 26);
		frame.getContentPane().add(l4);
		
		t2 = new JTextField();
		t2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t2.setBounds(228, 261, 165, 26);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t3.setColumns(10);
		t3.setBounds(228, 344, 165, 26);
		frame.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t4.setColumns(10);
		t4.setBounds(228, 424, 165, 26);
		frame.getContentPane().add(t4);
		
		l7 = new JLabel("Patient ID does not exist !");
		l7.setForeground(Color.RED);
		l7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l7.setBounds(274, 69, 282, 26);
		l7.setVisible(false);
		frame.getContentPane().add(l7);
		
		l5 = new JLabel("Ward Required?");
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l5.setBounds(431, 308, 151, 26);
		frame.getContentPane().add(l5);
		
		l6 = new JLabel("Type of Ward");
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l6.setBounds(431, 386, 151, 26);
		l6.setVisible(false);
		frame.getContentPane().add(l6);
		
		String[] wards= {"General","Deluxe","Super Deluxe"};
		JComboBox cb1 = new JComboBox(wards);
		cb1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cb1.setBounds(607, 391, 126, 21);
		cb1.setVisible(false);
		cb1.setSelectedIndex(-1);
		frame.getContentPane().add(cb1);
		
		JCheckBox c1 = new JCheckBox("YES");
		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c1.isSelected())
				{
					l6.setVisible(true);
					cb1.setVisible(true);
				}
				else {
					l6.setVisible(false);
					cb1.setVisible(false);
				}
			}
		});
		c1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		c1.setBounds(607, 313, 59, 21);
		frame.getContentPane().add(c1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 105, 723, 129);
		frame.getContentPane().add(scrollPane_1);
		
		 
		 String[][] data={{" "," "," "," "," "," "," "," "}};
		 String column[]={"ID","NAME","AGE","CONTACT_NO","GENDER","BLOOD_GROUP","EARLIER_DISEASE","ADDRESS"}; 
		table = new JTable(data,column);
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		ImageIcon icon1=new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\texture.jpg");
		Image img1=icon1.getImage().getScaledInstance(780,600, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(0, 0, 780, 600);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					ps=con.prepareStatement("select * from record where ID=?");
					ps.setInt(1, Integer.parseInt(t1.getText()));
					ResultSet rs=ps.executeQuery();
					
					
					if(rs!=null)
					{
						l7.setVisible(false);
						t1.setEditable(false);
						table.setModel(DbUtils.resultSetToTableModel(rs));
					
						flag=1;
						
					
					}
					ps=con.prepareStatement("select * from record where ID=?");
					ps.setInt(1, Integer.parseInt(t1.getText()));
					ResultSet rs2=ps.executeQuery();
					
					if(rs2.next()==false) {
						l7.setVisible(true);
						flag=0;
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(flag==1)
					{
						ps=con.prepareStatement("insert into report values(?,?,?,?,?,?)");
						ps.setObject(1, t1.getText());
						ps.setObject(2, t3.getText());
						ps.setObject(3, t2.getText());
						ps.setObject(4, t4.getText());
						if(c1.isSelected())
						{
							ps.setObject(5, "YES");
							ps.setObject(6, cb1.getSelectedItem());
						}
						else
						{
							ps.setObject(5, "NO");
							ps.setObject(6, "");
						}
						
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Data saved");
						frame.dispose();
						new Add_DiagnosisInfo();

					}
					else
						JOptionPane.showMessageDialog(null,"PatientID is required");
					
				}
				catch(Exception ae) {
					ae.printStackTrace();
				}
			}
		});
		
		
		
	}
}
