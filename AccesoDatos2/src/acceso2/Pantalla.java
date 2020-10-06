package acceso2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.Charset;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Pantalla {

	
	//defino variables
			String texto1= "";
			String texto2 = "";
			String codigo  ;
			
	private JFrame frame;
	private JTextField txtTexto2;
	private JTextField txtTexto1;

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
		
		JLabel lblTexto1 = new JLabel("Archivo1");
		lblTexto1.setBounds(44, 40, 46, 14);
		frame.getContentPane().add(lblTexto1);
		
		JLabel lblTexto2 = new JLabel("Archivo2");
		lblTexto2.setBounds(44, 65, 46, 14);
		frame.getContentPane().add(lblTexto2);
		
		JButton btnNewButton = new JButton("Copiar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//asignar valores a los nombres de los archivos
				 texto1 = txtTexto1.getText();
				 texto2 = txtTexto2.getText();
				 
				
				 
				 //comprobar que haya valores en texto1, texto2
				 if (texto1 == "")
					 System.out.println ("No has escrito un nombre de fichero origen");
				 
				 else if (texto2 =="")
					 // si no escribimos algo en el campo fichero1 o fichero2, mandamos mensaje
					 System.out.println ("No has escrito un nombre de fichero destino");
				
				 else{
					 if (UtilManejoFicheros.existeFichero(texto1)) {
						if (!UtilManejoFicheros.existeFichero(texto2)) {
							 // si no existe fichero2, lo creamos
							try {
								UtilManejoFicheros.crearFichero(texto2);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						} //si el fichero 2 ya existe no hacemos nada, pasamos directamente a la escritura
						
						// copiamos el contenido del fichero1 en el fichero2	 
						 try {
							UtilManejoFicheros.copiarFichero(texto1, texto2, codigo);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					 }
					 //else  // si el fichero1 no existe salir
						 //exit();
				 }
				
		     }
		});
		
		
		btnNewButton.setBounds(88, 152, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// poner los textos txtTexto1 y txtTexto2 vacios
				// txtTexto1 = " ";
				// txtTexto2 = " ";
				// setText(txtTexto1);
				// setText(txtTexto2);
				
				
			}
		});
		btnNewButton_1.setBounds(239, 152, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		txtTexto2 = new JTextField();
		txtTexto2.setBounds(100, 62, 241, 20);
		frame.getContentPane().add(txtTexto2);
		txtTexto2.setColumns(10);
		
		txtTexto1 = new JTextField();
		txtTexto1.setBounds(100, 37, 241, 20);
		frame.getContentPane().add(txtTexto1);
		txtTexto1.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(88, 109, 46, 14);
		frame.getContentPane().add(lblCodigo);
		
		JComboBox comboBoxCodigo = new JComboBox();
		comboBoxCodigo.setModel(new DefaultComboBoxModel(new String[] {"ISO_8859_1", "UTF_8", "US_ASCII"}));
		comboBoxCodigo.setBounds(144, 105, 155, 22);
		frame.getContentPane().add(comboBoxCodigo);
		
		codigo= (String)comboBoxCodigo.getSelectedItem();
		
		
	}
}
