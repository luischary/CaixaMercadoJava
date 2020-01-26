
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
public class Compra {
    private int quantidade;
    private double valor;
    private List<Item> lista;
    
    public void adicionarItem(Item x)
    {
        this.quantidade++;
        this.lista.add(x);
        this.valor = this.valor + x.getPreco() * x.getQuantidade();
    }
    
    public int getQuantidade()
    {
        return this.quantidade;
    }
    
    public double getValor()
    {
        return this.valor;
    }
   
    public boolean removerItem(int i)
    {
        if(this.lista.contains(this.lista.get(i)))
        {
            this.quantidade--;
            
            this.valor = this.valor - this.lista.get(i).getPreco() * this.lista.get(i).getQuantidade();
            
            this.lista.remove(i);            
            return true;
        }
        return false;
    }
    
    public String exibirDetalhes()
    {
        String s = "";
        for(int i = 0; i < this.lista.size(); i++)
        {
            s = s + "\nItem: " + i + "\n" + this.lista.get(i).getCaracteristicas() + "\n";
        }
        
        return s;
    }
    
    public Compra()
    {
        this.quantidade = 0;
        this.valor = 0;
        this.lista = new ArrayList<Item>();
    }
}
