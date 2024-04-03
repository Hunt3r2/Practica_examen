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
        super(ventanaBorrar);
        this.personas = personas;
        setTitle("Borrar Datos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 268, 408);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JList<String> list = new JList<>();
        list.setValueIsAdjusting(true);
        list.setModel(new DefaultListModel<>());
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 11, 232, 314);
        contentPane.add(scrollPane);

        String[] nombres = obtenerNombres(personas);

        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (String nombre : nombres) {
            if (nombre != null) {
                modeloLista.addElement(nombre);
            }
        }

        list.setModel(modeloLista);

        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    String nombreSeleccionado = list.getSelectedValue();
                    int respuesta = JOptionPane.showConfirmDialog(contentPane, "¿Seguro que quieres borrar a " + nombreSeleccionado + "?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        borrarPersona(selectedIndex);
                        dispose();
                    }
                }
            }
        });
        dispose();
        btnBorrar.setBounds(85, 336, 89, 23);
        contentPane.add(btnBorrar);

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

    private void borrarPersona(int indice) {
        personas[indice] = null;
    }

}
