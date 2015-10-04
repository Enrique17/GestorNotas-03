package Vista;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class sw_VistaAdmin extends JFrame {

	public sw_VistaAdmin() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setTitle("Administrador");
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		menuBar.add(mnNuevo);

	}
}
