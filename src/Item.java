/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Felipe
 */
public class Item {
    private int quantidade;
    private double preco;
    private String nome;
    
    public double getPreco()
    {
        return this.preco; //valor unitário
    }
    
    public int getQuantidade()
    {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }
    
    public String getCaracteristicas()
    {
        String s;
        
        s = "Nome: " + this.nome;
        s = s + "\nPreço unitário: R$" + String.format("%.2f",this.preco);
        s = s + "\nQuantidade: " + this.quantidade;
        
        return s;
    }
    
    public Item(String nome, double preco)
    {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = 1;
    }
    
    public Item(String nome, double preco, int quantidade)
    {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
