import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrarPersonas extends JDialog {

    private JPanel contentPane;
    private Persona[] personas;
    private DefaultListModel modeloLista;

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

    public BorrarPersonas(JFrame ventanaBorrar, Persona[] personas) {
        super(ventanaBorrar, true);
        this.personas = personas;
        setTitle("Borrar Datos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 268, 408);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JList list = new JList();
        list.setValueIsAdjusting(true);
        list.setModel(new DefaultListModel());
        //Utilizo el scroll pane, y dentro meto la lista
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 11, 232, 314);
        contentPane.add(scrollPane);
        //Reutilizo el codigo de mostrar personas para la lista de borrar
        String[] nombres = obtenerNombres(personas);

        DefaultListModel modeloLista = new DefaultListModel();
        for (String nombre : nombres) {
            if (nombre != null) {
                modeloLista.addElement(nombre);
            }
        }

        list.setModel(modeloLista);
        
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                	int indiceSeleccionado = list.getSelectedIndex();
                    if (indiceSeleccionado != -1) {
                    	//creo el objeto persona personaSeleccionada en el que meto la persona que se a seleccionado 
                        Persona personaSeleccionada = personas[indiceSeleccionado];
                        if (personaSeleccionada != null) {
                        	String nombreSeleccionado = (String) list.getSelectedValue();
                            int respuesta = JOptionPane.showConfirmDialog(contentPane, "¿Seguro que quieres borrar a " + nombreSeleccionado + "?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
                            if (respuesta == JOptionPane.YES_OPTION) {
                                borrarPersona(indiceSeleccionado);
                                dispose();
                            }
                        }
                    }
                }
            }
        });
        actualizarLista();
        dispose();
        
    }
    
    private void actualizarLista() {
        modeloLista.removeAllElements();
        String[] nombres = obtenerNombres(personas);
        for (String nombre : nombres) {
            if (nombre != null) {
                modeloLista.addElement(nombre);
            }
        }
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
    

    private void borrarPersona(int indice) {
        personas[indice] = null;
        actualizarLista();
    }

}
