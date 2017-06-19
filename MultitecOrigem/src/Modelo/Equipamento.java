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
  private int Cod;
  private String Nome;
  private String Marca;
  private String Modelo;
  
    public int getCod() {
        return Cod;
    }

   
    public void setCod(int Cod) {
        this.Cod = Cod;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = Nome;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        this.Modelo = Modelo;
    }

  
 
  
}
