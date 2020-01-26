
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Felipe
 */
public class Caixa {
    private List<Compra> vendas; //lista com as compras efetuadas no caixa
    private double totalCaixa; //valor total arrecadado pelo caixa
    private int id; //identificação do caixa
    private boolean aberto; //variável que sinaliza o estado do caixa, aberto = true /fechado = false
    
    public double getTotalCaixa()
    {
        return this.totalCaixa;
    }
    
    public void abrirCaixa()
    {
        this.aberto = true;
    }
    
    public void fecharCaixa()
    {
        this.aberto = false;
    }
    
    public void novaCompra(Compra c) //adiciona uma nova compra a lista de compras do caixa e atualiza o valor total do caixa
    {
        if(this.aberto){
            totalCaixa = totalCaixa + c.getValor();
            this.vendas.add(c);
        }
    }
    
    //sobrecarga de construtores
    public Caixa(int id, double total, boolean aberto)
    {
        this.id = id;
        this.totalCaixa = total;
        this.aberto = aberto;
        this.vendas = new ArrayList<Compra>();
    }
    
    public Caixa(int id)
    {
        this.id = id;
        this.totalCaixa = 0;
        this.aberto = false;
        this.vendas = new ArrayList<Compra>();
    }
    
    public Caixa(int id, double total)
    {
        this.aberto = false;
        this.id = id;
        this.totalCaixa = total;
        this.vendas = new ArrayList<Compra>();
    }
}
