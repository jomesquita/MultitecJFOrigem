/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Joelânio
 */
public class Equipamento {
  
  private String nome;
  private String marca;
  private String modelo;
  private String conexão;
  private String codigo;
  
private String getcodigo(){
    return codigo;
}
public void setcodigo(){
    this.codigo = codigo;
}
  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getConexão() {
        return conexão;
    }

    public void setConexão(String conexão) {
        this.conexão = conexão;
    }
  
}
