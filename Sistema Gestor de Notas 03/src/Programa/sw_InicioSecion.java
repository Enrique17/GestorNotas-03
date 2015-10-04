package Programa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Vista.sw_VistaAdmin;
import Vista.sw_VistaDocente;

import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Panel;

import javax.crypto.spec.PSource.PSpecified;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sw_InicioSecion {

	private JFrame frmAutentificacin;
	private JTextField txf_Usuario;
	private JPasswordField pwf_Contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sw_InicioSecion window = new sw_InicioSecion();
					window.frmAutentificacin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sw_InicioSecion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAutentificacin = new JFrame();
		frmAutentificacin.setResizable(false);
		frmAutentificacin.setFont(new Font("Adobe Garamond Pro Bold", Font.BOLD | Font.ITALIC, 12));
		frmAutentificacin.getContentPane().setBackground(Color.WHITE);
		frmAutentificacin.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Cambria", Font.BOLD, 14));
		lblUsuario.setBounds(56, 37, 71, 14);
		frmAutentificacin.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Cambria", Font.BOLD, 14));
		lblContrasea.setBounds(56, 96, 84, 14);
		frmAutentificacin.getContentPane().add(lblContrasea);
		
		txf_Usuario = new JTextField();
		txf_Usuario.setBackground(SystemColor.control);
		txf_Usuario.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		txf_Usuario.setBounds(148, 35, 140, 20);
		frmAutentificacin.getContentPane().add(txf_Usuario);
		txf_Usuario.setColumns(10);
		
		pwf_Contraseña = new JPasswordField();
		pwf_Contraseña.setBackground(SystemColor.control);
		pwf_Contraseña.setBounds(150, 94, 138, 20);
		frmAutentificacin.getContentPane().add(pwf_Contraseña);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			int contador =0;
			public void actionPerformed(ActionEvent arg0) {

				if(contador<3){
					if(Controlador.Usuario_Controlador.ExisteUsuario(txf_Usuario.getText(), pwf_Contraseña.getText())){
						if(Controlador.Usuario_Controlador.AutentificacionAdmin(txf_Usuario.getText(), pwf_Contraseña.getText())){
							sw_VistaAdmin vadmin = new sw_VistaAdmin();
							vadmin.setVisible(true);
							frmAutentificacin.setVisible(false);
							frmAutentificacin.dispose();
						}
						else{
							sw_VistaDocente vdocente = new sw_VistaDocente();
							vdocente.setVisible(true);
							frmAutentificacin.setVisible(false);
							frmAutentificacin.dispose();
						}
					}
					else{
						
						JOptionPane.showMessageDialog(null,"Usuario inexitente, intente nuevamente", "Error",JOptionPane.ERROR_MESSAGE);
						contador = contador + 1;
						
					}
				}
				else{
					frmAutentificacin.setVisible(false);
					frmAutentificacin.dispose();
					JOptionPane.showMessageDialog(null,"La aplicacion ha dejado de funcionar, intentos agotados", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAcceder.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnAcceder.setForeground(SystemColor.text);
		btnAcceder.setBackground(SystemColor.textHighlight);
		btnAcceder.setBounds(232, 153, 89, 23);
		frmAutentificacin.getContentPane().add(btnAcceder);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(sw_InicioSecion.class.getResource("/Imagenes/candado01.png")));
		lblNewLabel.setBounds(358, 11, 140, 165);
		frmAutentificacin.getContentPane().add(lblNewLabel);
		frmAutentificacin.setTitle("Autentificaci\u00F3n");
		frmAutentificacin.setBounds(100, 100, 553, 216);
		frmAutentificacin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
