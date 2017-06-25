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
    
 public String Inserir_Equipamento(Equipamento q){
        String sql = "INSERT INTO equipamento VALUES (0,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, q.getNome());
            ps.setString(2, q.getMarca());
            ps.setString(3, q.getModelo());
           
            
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
        String sql = "SELECT codigo,nome,marca,modelo FROM equipamento";
        List<Equipamento> lista = new ArrayList<Equipamento>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Equipamento q = new Equipamento();
                    q.setCod(rs.getInt(1));
                    q.setNome(rs.getString(2));
                    q.setMarca(rs.getString(3));
                    q.setModelo(rs.getString(4));
                    
                    lista.add(q);
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
        String sql = "SELECT codigo, nome, marca, modelo FROM funcionario WHERE nome LIKE '" + nome + "%'";
        List<Equipamento> lista = new ArrayList<Equipamento>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Equipamento q = new Equipamento();
                    q.setCod(rs.getInt(1));
                    q.setNome(rs.getString(2));
                    q.setMarca(rs.getString(3));
                    q.setModelo(rs.getString(4));
                    
                    lista.add(q);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Equipamento> Pesquisar_Cod_Equipamento(int cod){
        String sql = "SELECT codigo, nome, marca, modelo FROM equipamento WHERE codigo = '" + cod + "'" ;
        List<Equipamento> lista = new ArrayList<Equipamento>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Equipamento q = new Equipamento();
                    q.setCod(rs.getInt(1));
                    q.setNome(rs.getString(2));
                    q.setMarca(rs.getString(3));
                    q.setModelo(rs.getString(4));
                    
                    lista.add(q);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }
    

    
    public Equipamento Consulta_Equipamento(int cod){
        
         Equipamento q = new Equipamento();
         
        try {
            
            String sql = "SELECT * FROM equipamento WHERE codigo =  " + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            
            if(rs != null){
                while(rs.next()){
                                      
                    q.setCod(rs.getInt(1));
                    q.setNome(rs.getString(2));
                    q.setMarca(rs.getString(3));
                    q.setModelo(rs.getString(4));
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if(q.getCod() == cod){
            JOptionPane.showMessageDialog(null, "Equipamento encontrado com sucesso!");
        }else{
        JOptionPane.showMessageDialog(null, "Equipamento  encontrado!");    
        }
        return q;
    }
    
    
    
    
    public void Alterar_Equipamento(Equipamento q){
        String sql = "UPDATE equipamento SET nome = ?, marca = ?, modelo = ?"
                + "WHERE codigo = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, q.getNome());
            ps.setString(2, q.getMarca());
            ps.setString(3, q.getModelo());
            ps.setString(4, "" +q.getCod());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Equipamento Atualizado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Equipamento!");
            }
        } catch (Exception e) {
           e.getMessage();
        }
    }
    
  
    
    public String Excluir_Equipamento(Equipamento q){
        String sql = "DELETE FROM equipamento WHERE codigo = ?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, q.getCod());
            
            if(ps.executeUpdate() > 0){
                return "Funcionário Excluído com Sucesso!";
            }else{
                return "Erro ao Excluir!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    
    }
}
