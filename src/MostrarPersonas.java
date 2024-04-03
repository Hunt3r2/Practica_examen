import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;

public class MostrarPersonas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public void mostrar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MostrarPersonas(JFrame ventanaMostrar, Persona[] personas) {
		super(ventanaMostrar);
		setTitle("Lista de Nombres");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 268, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setValueIsAdjusting(true);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(0, 0, 252, 369);
		contentPane.add(list);
		
		String[] nombres = obtenerNombres(personas);

        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (String nombre : nombres) {
            if (nombre != null) {
                modeloLista.addElement(nombre);
            }
        }

        list.setModel(modeloLista);
        
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int index = list.getSelectedIndex();
                    if (index != -1) {
                        Persona personaSeleccionada = personas[index];
                        if (personaSeleccionada != null) {
                            mostrarInformacionPersona(personaSeleccionada);
                        }
                    }
                }
            }
        });
    }
	
	

	private String[] obtenerNombres(Persona[] personas) {
	    String[] nombres = new String[personas.length];
	    for (int i = 0; i < personas.length; i++) {
	        if (personas[i] != null) {
	            nombres[i] = personas[i].getNombre();
	        }
	    }
	    return nombres;
	}
	
	private void mostrarInformacionPersona(Persona persona) {
        String mensaje = "Nombre: " + persona.getNombre() + "\n" + "Email: " + persona.getEmail() + "\n" + "Edad: " + persona.getEdad();
        JOptionPane.showMessageDialog(this, mensaje, "Información de Persona", JOptionPane.INFORMATION_MESSAGE);
    }

}
