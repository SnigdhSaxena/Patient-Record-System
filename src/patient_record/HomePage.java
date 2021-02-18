package patient_record;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HomePage extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -257372077335678689L;
	public JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage  frame = new HomePage ();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public HomePage() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		JButton b1 = new JButton("Add New Patient Record");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Add_Record();
			}
		});
		b1.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-add-property-64.png"));
		b1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		b1.setBounds(29, 124, 316, 55);
		frame.getContentPane().add(b1);
		
		JButton b2 = new JButton("Add Diagnosis Information");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Add_DiagnosisInfo();
			}
		});
		b2.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-system-diagnostic-50.png"));
		b2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		b2.setBounds(29, 295, 316, 55);
		frame.getContentPane().add(b2);
		
		JButton b3 = new JButton("Full History Of The Patient");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Full_History();
			}
		});
		b3.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-activity-history-48.png"));
		b3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		b3.setBounds(29, 445, 316, 55);
		frame.getContentPane().add(b3);
		
		JButton b4 = new JButton("Update Patient Record");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Update_Record();
			}
		});
		b4.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-update-48.png"));
		b4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		b4.setBounds(29, 595, 316, 55);
		frame.getContentPane().add(b4);
		
		JButton b5 = new JButton("Hospital Information");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new About_Info();
			}
		});
		b5.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-about-50.png"));
		b5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		b5.setBounds(29, 745, 316, 55);
		frame.getContentPane().add(b5);
		
		JButton b6 = new JButton("Log Out");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=JOptionPane.showConfirmDialog(null, "Do you want to exit?","Select",JOptionPane.YES_NO_OPTION);
				if(i==0)
				{
					frame.setVisible(false);
					new Login_Frame();
				}
				
			}
		});
		b6.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-close-window-50.png"));
		b6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		b6.setBounds(29, 895, 316, 55);
		frame.getContentPane().add(b6);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setLocation(0, 0);
		lblNewLabel.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\itl.cat_hospital-wallpaper_1438028.png"));
		lblNewLabel.setSize(screenSize.width, screenSize.height);
		frame.getContentPane().add(lblNewLabel);

	}

}
