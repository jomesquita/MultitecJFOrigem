
package DAO;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {
    public static Connection AbrirConexao(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/multitec";
            con = DriverManager.getConnection(url,"root", "");
                   
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na Conexão com o Banco","Multitec", JOptionPane.ERROR_MESSAGE );
        }
        return con;
    }
    
    public static void FecharConexao(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        
    }

}