import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class InsertarDatos extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JLabel lblEmail;
	private JTextField textFieldEmail;
	private JLabel lblEdad;
	private JTextField textFieldEdad;
	private JButton btnIntroducir;
	private Persona[] personas;


	/**
	 * Launch the application.
	 */
	public void insertar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarDatos frame = new InsertarDatos(null, personas);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertarDatos(JFrame VentanaDatos, Persona[] personas) {
		super(VentanaDatos);
		this.personas = personas;
		
		setTitle("Insertar Datos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Arial", Font.ITALIC, 15));
		lblNombre.setBounds(61, 72, 82, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(172, 65, 153, 29);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial", Font.ITALIC, 15));
		lblEmail.setBounds(61, 116, 82, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(172, 105, 153, 29);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		lblEdad = new JLabel("Edad: ");
		lblEdad.setFont(new Font("Arial", Font.ITALIC, 15));
		lblEdad.setBounds(61, 160, 82, 14);
		contentPane.add(lblEdad);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setBounds(172, 153, 153, 29);
		contentPane.add(textFieldEdad);
		textFieldEdad.setColumns(10);
		
		btnIntroducir = new JButton("Introducir");
		btnIntroducir.setBackground(new Color(51, 255, 255));
		btnIntroducir.setBorder(new LineBorder(new Color(51, 0, 153), 2, true));
		btnIntroducir.setFont(new Font("Papyrus", Font.PLAIN, 19));
		btnIntroducir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int indice = encontrarIndiceDisponible();
		        if (indice != -1) {
		            String nombre = textFieldNombre.getText();
		            String email = textFieldEmail.getText();
		            int edad = Integer.parseInt(textFieldEdad.getText());
		            personas[indice] = new Persona(nombre, email, edad);
		            if (edad <= 0) {
		                JOptionPane.showMessageDialog(contentPane, "Por favor, pon una edad válida (>=1)", "Edad errónea", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(contentPane, "No hay espacio disponible para más personas", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        dispose();
		    }
		});
		btnIntroducir.setBounds(134, 219, 112, 45);
		contentPane.add(btnIntroducir);
	}
	
	private int encontrarIndiceDisponible() {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                return i;
            }
        }
        return -1;
    }
	
	

}
