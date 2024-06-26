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
import javax.swing.JScrollPane;

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
		super(ventanaMostrar, true);
	    setTitle("Lista de Nombres");
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 268, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] nombres = obtenerNombres(personas);
		//Para poner los nombres en la lista
        DefaultListModel modeloLista = new DefaultListModel();
        for (String nombre : nombres) {
            if (nombre != null) {
                modeloLista.addElement(nombre);
            }
        }
        //Utilizo el scroll pane, y dentro meto la lista
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 232, 314);
        contentPane.add(scrollPane);
        
        JList list = new JList();
        scrollPane.setViewportView(list);
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
        
        String[] nuevosNombres = obtenerNombres(personas);
        DefaultListModel nuevoModeloLista = new DefaultListModel();
        for (String nombre : nuevosNombres) {
            if (nombre != null) {
                nuevoModeloLista.addElement(nombre);
            }
        }
        list.setModel(nuevoModeloLista);
        
                list.setModel(modeloLista);
        //Para que cuando selecciono un nombre, me salga la info. El metodo valueChanged está en la página de Java en Oracle
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int index = list.getSelectedIndex();
                    if (index != -1) {
                    	//creo el objeto persona personaSeleccionada en el que meto la persona que se a seleccionado 
                        Persona personaSeleccionada = personas[index];
                        if (personaSeleccionada != null) {
                            mostrarInformacionPersona(personaSeleccionada);
                        }
                    }
                }
            }
        });
    }
	
	
	 //metodo para meter los nombres en la lista
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
