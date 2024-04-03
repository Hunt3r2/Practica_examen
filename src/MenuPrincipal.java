import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/Imagenes/nicolas-cage-biografia-fotos.jpg")));
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIntroducirDatos = new JButton("Introducir Datos");
		btnIntroducirDatos.setBorder(new LineBorder(new Color(51, 153, 153), 4, true));
		btnIntroducirDatos.setFocusable(false);
		btnIntroducirDatos.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnIntroducirDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarDatos datos = new InsertarDatos(null, personas);
				datos.insertar();
			}
		});
		btnIntroducirDatos.setBounds(163, 78, 153, 38);
		contentPane.add(btnIntroducirDatos);
		
		JButton btnConsultarPersonas = new JButton("Consultar Personas");
		btnConsultarPersonas.setBorder(new LineBorder(new Color(51, 153, 153), 4, true));
		btnConsultarPersonas.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnConsultarPersonas.setFocusable(false);
		btnConsultarPersonas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        MostrarPersonas mostrar = new MostrarPersonas(null, personas);
		        mostrar.mostrar();
		    }
		});
		btnConsultarPersonas.setBounds(163, 127, 153, 38);
		contentPane.add(btnConsultarPersonas);
		
		btnBorrarPersonas = new JButton("Borrar Personas");
		btnBorrarPersonas.setBorder(new LineBorder(new Color(51, 153, 153), 4, true));
		btnBorrarPersonas.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnBorrarPersonas.setFocusable(false);
		btnBorrarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrarPersonas borrar = new BorrarPersonas(null, personas);
		        borrar.mostrar();
			}
		});
		btnBorrarPersonas.setBounds(163, 176, 153, 38);
		contentPane.add(btnBorrarPersonas);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Imagenes/RpiQZf.gif")));
		lblFondo.setBounds(0, 0, 481, 303);
		contentPane.add(lblFondo);
	}
}
