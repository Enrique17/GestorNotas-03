package Modelo;

import java.sql.SQLException;
import Controlador.Conexion_Singleton;

public class Usuario {
	private int id;
	private String usuario;
	private String contrasenia;
	
	public Usuario(String usuario,String contrasenia){
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int GetId(){
		return this.id;
	}
	
	public String GetUsuario(){
		return this.usuario;
	}
	
	public String GetContrasenia(){
		return this.contrasenia;
	}
	
	public void SetUsuario(String usuario){
		this.usuario = usuario;
	}
	
	public void SetContrasenia(String contrasenia){
		this.contrasenia = contrasenia;
	}
	
	public boolean Existe(String n,String p){
		Conexion_Singleton con = Conexion_Singleton.getConexion();
		String consulta = "SELECT * FROM `usuario` WHERE nombreU = '"+n+"'AND contraceniaU = '"+p+"'";
		con.setConsulta(consulta);
		con.consultar();
		try {
			if(con.getListaResultado().next()){
				System.err.println("entro");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean AutentificacionAdmin(String us, String cont){
		Conexion_Singleton con = Conexion_Singleton.getConexion();
		String consulta = "SELECT * FROM `usuario` WHERE nombreU = '"+us+"'AND contraceniaU = '"+cont+"' AND TipoUsuario_idTipoUsuario = '1'";
		con.setConsulta(consulta);
		con.consultar();
		try {
			if(con.getListaResultado().next()){
				System.err.println("entro");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
