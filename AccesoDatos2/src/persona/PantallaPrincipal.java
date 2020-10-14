package persona;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PantallaPrincipal {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
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
	public PantallaPrincipal() {
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
		
		JLabel lblNombre = new JLabel("New label");
		lblNombre.setBounds(51, 52, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("New label");
		lblApellidos.setBounds(51, 95, 46, 14);
		frame.getContentPane().add(lblApellidos);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(51, 134, 46, 14);
		frame.getContentPane().add(lblFecha);
		
		textField = new JTextField();
		textField.setBounds(113, 49, 59, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 92, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(113, 131, 59, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(82, 203, 89, 23);
		frame.getContentPane().add(btnGuardar);
	}
}
