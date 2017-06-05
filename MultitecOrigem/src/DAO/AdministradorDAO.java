/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Joelânio
 */
public class AdministradorDAO extends ExecuteSQL {

    public AdministradorDAO(Connection con) {
        super(con);
    }
    public boolean Logar(String login, String senha){
        boolean finalResult = false;
        try{
            String consulta = "select login, senha from Administrador " 
            + "where login = '"+ login + "' and senha = '"+senha+"'";  
            PreparedStatement ps = getCon(). prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
        if(rs != null){
            while (rs.next ()){
                Administrador a = new Administrador();
                a.setLogin(rs.getString(1));
                a.setSenha(rs.getString(2));
                finalResult = true;
               
            }
        }
        }catch (SQLException ex){
          ex.getMessage();
          
        }
    return finalResult;
    }
    
    
}
