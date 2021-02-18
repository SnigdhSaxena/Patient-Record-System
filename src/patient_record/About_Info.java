package patient_record;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class About_Info extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About_Info window = new About_Info();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public About_Info() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(600, 200, 780, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		
		JLabel l1 = new JLabel("");
		ImageIcon icon=new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\Hospital-Management-System.png");
		Image img=icon.getImage().getScaledInstance(637, 258, Image.SCALE_DEFAULT);
		getContentPane().setLayout(null);
		l1.setIcon(new ImageIcon(img));
		l1.setBounds(67, 57, 637,258);
		frame.getContentPane().add(l1);
		
		String str=" In this fast world, it's nearly not possible to manage the operations of a\n super-speciality hospital. "
				+ "However fortunately, the task has been created\n easier with the utilization of a Patient Recording System."
				+" A Patient\n Recording System will be delineated as a JAVA-based GUI System or system\n that is employed to manage "
				+ "the records of patients. This software system\n will be used for any medical set-up as well as clinics and "
				+ "medical centre’s.\n";
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 366, 700, 175);
		
		frame.getContentPane().add(scrollPane);
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(175, 238, 238));
		textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea.setText(str);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton b1 = new JButton("Close");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		b1.setIcon(new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\icons8-close-window-48.png"));
		b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		b1.setBounds(607, 583, 130, 37);
		frame.getContentPane().add(b1);
		
		JLabel lblNewLabel = new JLabel("New label");
		ImageIcon icon1=new ImageIcon("C:\Patient-Record-System-master\Patient-Record-System-master\img\texture.jpg");
		Image img1=icon1.getImage().getScaledInstance(780,630, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(0, 0, 780, 630);
		frame.getContentPane().add(lblNewLabel);
	}
}
