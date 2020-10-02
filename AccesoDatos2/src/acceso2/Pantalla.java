package acceso2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla {

	private JFrame frame;
	private JTextField txt_texto2;
	private JTextField txt_texto1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
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
	public Pantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbltexto1 = new JLabel("Archivo1");
		lbltexto1.setBounds(44, 40, 46, 14);
		frame.getContentPane().add(lbltexto1);
		
		JLabel lbltexto2 = new JLabel("Archivo2");
		lbltexto2.setBounds(44, 65, 46, 14);
		frame.getContentPane().add(lbltexto2);
		
		JButton btnNewButton = new JButton("Copiar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 // texto1 = txt_texto1.getText();
				//comprobar que haya valores en texto1, texto2
				
				//utilcopiarficheros o existefichero
				
				
				
			}
		});
		
		
		btnNewButton.setBounds(89, 144, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// txtTexto1 ="";
				
				
			}
		});
		btnNewButton_1.setBounds(232, 144, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		txt_texto2 = new JTextField();
		txt_texto2.setBounds(100, 62, 241, 20);
		frame.getContentPane().add(txt_texto2);
		txt_texto2.setColumns(10);
		
		txt_texto1 = new JTextField();
		txt_texto1.setBounds(100, 37, 241, 20);
		frame.getContentPane().add(txt_texto1);
		txt_texto1.setColumns(10);
	}
}
