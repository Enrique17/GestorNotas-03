package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion_Singleton {
	public Connection conn;
    public static Conexion_Singleton instancia;
    private String consulta;
    private ResultSet listaResultado;
    
    
    private Conexion_Singleton() {
        String dbhost= "localhost";
        String dbName = "gestornotas_db";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        //SDfsdfsdfsdfsd
        
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection("jdbc:mysql://"+dbhost+"/"+dbName,userName,password);
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException sqle) {
        }
    }
    
    public static synchronized Conexion_Singleton getConexion() {
        if ( instancia == null ) {
            System.out.println("Creando la instancia!");
            instancia = new Conexion_Singleton();
        }
        else System.out.println("Instancia ya esta creada!");
        return instancia;
 
    }
    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public ResultSet getListaResultado() {
        return listaResultado;
    }
    
    
    public void consultar(){
        Statement statement;
        try {
            statement = (Statement) instancia.conn.createStatement();
            this.listaResultado = statement.executeQuery(this.consulta);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion_Singleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void ejecutar() {
        Statement statement;
        try {
            statement = (Statement) instancia.conn.createStatement();
            statement.execute(this.consulta);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion_Singleton.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
