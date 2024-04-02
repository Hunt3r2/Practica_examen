import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnBorrarPersonas;
	private Persona[] personas = new Persona[5];

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIntroducirDatos = new JButton("Introducir Datos");
		btnIntroducirDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarDatos datos = new InsertarDatos(null, personas);
				datos.insertar();
			}
		});
		btnIntroducirDatos.setBounds(163, 78, 153, 38);
		contentPane.add(btnIntroducirDatos);
		
		JButton btnConsultarPersonas = new JButton("Consultar Personas");
		btnConsultarPersonas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        InsertarDatos datos = new InsertarDatos(null, personas);
		        datos.insertar();
		        // La ventana InsertarDatos se cerrará automáticamente después de introducir los datos
		    }
		});
		btnConsultarPersonas.setBounds(163, 127, 153, 38);
		contentPane.add(btnConsultarPersonas);
		
		btnBorrarPersonas = new JButton("Borrar Personas");
		btnBorrarPersonas.setBounds(163, 176, 153, 38);
		contentPane.add(btnBorrarPersonas);
	}

}
