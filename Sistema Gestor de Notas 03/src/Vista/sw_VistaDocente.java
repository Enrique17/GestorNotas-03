package Vista;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class sw_VistaDocente extends JFrame {

	public sw_VistaDocente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\t\t\t\t\t\t\t\tGestor de Notas");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		menuBar.add(mnNuevo);

	}

}
