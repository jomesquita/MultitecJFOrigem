/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Equipamento;
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
public class EquipamentoDAO extends ExecuteSQL{

    public EquipamentoDAO(Connection con) {
        super(con);
    }
    
 public String cadastrarEquipamento(Equipamento E){
        String sql = "INSERT INTO equipamento VALUES (0,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, E.getNome());
            ps.setString(2, E.getMarca());
            ps.setString(3, E.getModelo());
           
            
            if(ps.executeUpdate() > 0){
                return "Equipamento Cadastrado com Sucesso!";
            }else{
                return "Erro ao Cadastrar!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Equipamento> Listar_Equipamento(){
        String sql = "SELECT nome, marca, modelo FROM equipamento";
        List<Equipamento> lista = new ArrayList<Equipamento>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Equipamento E = new Equipamento();
                    E.setNome(rs.getString(1));
                    E.setMarca(rs.getString(2));
                    E.setModelo(rs.getString(3));    
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public List<Equipamento> Pesquisar_Nome_Equipamento(String nome){
        String sql = "SELECT codigo, nome, marca, modelo FROM equipamento WHERE nome LIKE '" + nome + "%'";
        List<Equipamento> lista = new ArrayList<Equipamento>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Equipamento E = new Equipamento();
                   
                    E.setNome(rs.getString(1));
                    E.setMarca(rs.getString(2));
                    E.setModelo(rs.getString(3));
                    
                    
                    lista.add(E);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Equipamento> Pesquisar_Cod_Equipamento(String nome){
        String sql = "SELECT codigo, nome, Marca, Modelo FROM equipamento WHERE nome = '" + nome+ "'" ;
        List<Equipamento> lista = new ArrayList<Equipamento>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Equipamento E = new Equipamento();
                    E.setNome(rs.getString(1));
                    E.setMarca(rs.getString(2));
                    E.setModelo(rs.getString(3));
                   
                    
                    lista.add(E);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }
    

    
    public Equipamento Consulta_Equipamento(String nome){
        
         Equipamento E = new Equipamento();
         
        try {
            
            String sql = "SELECT * FROM equipamento WHERE nome =  " + nome + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            
            if(rs != null){
                while(rs.next()){
                                      
                   
                    E.setNome(rs.getString(1));
                    E.setMarca(rs.getString(2));
                    E.setModelo(rs.getString(3));
                    
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if(E.getNome() == nome){
            JOptionPane.showMessageDialog(null, "Equipamento encontrado com sucesso!");
        }else{
        JOptionPane.showMessageDialog(null, "Equipamento Não encontrado com sucesso!");    
        }
        return E;
    }
    
    
    
    
    public void Alterar_Funcionario(Equipamento E){
        String sql = "UPDATE gerente SET nome = ?, Marca = ?, Modelo = ? "  + "WHERE nome = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, E.getNome());
            ps.setString(2,E.getMarca());
            ps.setString(3, E.getModelo());
             ps.setString(4, "" + E.getNome());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Equipamento Atualizado!");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Equipamento!");
            }
        } catch (Exception e) {
           e.getMessage();
        }
    }
    
  
      public String Excluir_Equipamento(Equipamento E){
        String sql = "DELETE FROM equipamento WHERE codigo = ?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, E.getNome());
            
            if(ps.executeUpdate() > 0){
                return "Equipamento Excluído com Sucesso!";
            }else{
                return "Erro ao Excluir!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    
    }

    public void Cadastrar_Equipamento(Equipamento E) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void CadastrarEquipamento(Equipamento E) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Inserir_Equipamento(Equipamento E) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


