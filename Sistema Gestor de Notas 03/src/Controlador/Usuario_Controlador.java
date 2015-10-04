package Controlador;

import Modelo.Usuario;

public class Usuario_Controlador {
	
	public static boolean ExisteUsuario(String non, String usu){
		Usuario usuario = new Usuario();
		if(usuario.Existe(non, usu)){
			return true;
		}
		return false;
	}
	
	public static boolean AutentificacionAdmin(String us, String cont){
		if(Usuario.AutentificacionAdmin(us, cont)){
			return true;
		}
		
		return false;
	}

}
