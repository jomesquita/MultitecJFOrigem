/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Joelânio
 */
public class ClienteDAO extends ExecuteSQL {

    public ClienteDAO(Connection con) {
        super(con);
    }
    
 public String Inserir_Cliente(Cliente c){
        String sql = "INSERT INTO cliente VALUES (0,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, c.getNome());
         
            if(ps.executeUpdate() > 0){
                return "Cliente Cadastrado com Sucesso!";
            }else{
                return "Erro ao Cadastrar!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
