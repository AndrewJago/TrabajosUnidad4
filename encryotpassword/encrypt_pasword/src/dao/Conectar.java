package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import entities.Account;

public class Conectar {
	
	Connection conn = null;
	
	
	public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "root");
            System.out.println("---Conectado---");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
    }
	
	public void obtenCampos(Account account) throws SQLException {
		connect();
		
		PreparedStatement preS = conn.prepareStatement("INSERT INTO datos (correo, nombrecompleto, password, usuario) VALUES (?, ?, ?, ?)");

		
		try {
			preS.setString(1, account.getCorreo());
			preS.setString(2, account.getNomCompleto());
			preS.setString(3, account.getPassword());
			preS.setString(4, account.getUsuario());

			preS.executeUpdate();
			preS.close();
		
			
			
			

			JOptionPane.showMessageDialog(null, "Registro exitoso ");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	
		
	}

}
