
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Felipe
 */
public class Janela extends Caixa implements ActionListener { 
    private JFrame frame; //janela
    private JPanel painelPrincipal;
    
    private JTextField textoNome; 
    private JTextField textoQuantidade;
    private JTextField textoValor;
    
    private JButton botaoNovoItem;
    private JButton botaoFinalizarCompra;
    private JButton botaoCancelarCompra;
    private JButton botaoRemoverItem;
    private JButton botaoAbrirFechar;
    private JTextArea memo;
    
    private JLabel labelTotal;
    private JLabel labelNome;
    private JLabel labelQuantidade;
    private JLabel labelValor;
    
    private JScrollPane scroll;
    
    private Compra compraAtual;
    
    private GridBagConstraints gbc;
    public Janela(int id)
    {
        super(id); //configura o id do caixa atual
        gbc = new GridBagConstraints(); //usado para configurar o layout
        frame = new JFrame("Caixa de Supermercado - " + id);
        painelPrincipal = new JPanel(new GridBagLayout());
        textoNome = new JTextField();
        textoQuantidade = new JTextField();
        textoValor = new JTextField();
        botaoNovoItem = new JButton("Inserir item");
        botaoFinalizarCompra = new JButton("Finalizar compra");
        botaoCancelarCompra = new JButton("Cancelar compra");
        botaoRemoverItem = new JButton("Remover item");
        botaoAbrirFechar = new JButton("Abrir caixa");
        memo = new JTextArea();
        labelTotal = new JLabel("Total da compra:");
        labelNome = new JLabel("Nome:");
        labelQuantidade = new JLabel("Quantidade:");
        labelValor = new JLabel("Valor unitário:");
        compraAtual = new Compra(); //inicializa variável de compra
        
        this.travaTudo();// caixa fechado
        
        memo.setEditable(false); //trava entradas no campo de texto
        scroll = new JScrollPane(memo); //scroll usado no textArea para nao limitar a visao
        //scroll.setViewportView(memo);
        //frame.add(scroll);
        //painel4.add(scroll, BorderLayout.CENTER);
        
        //CONFIGURAÇÕES DE TEXTO (FONTE)
        memo.setFont(new Font("Arial", Font.BOLD, 14));
        labelTotal.setFont(new Font("Arial", Font.BOLD, 16));
        labelNome.setFont(labelTotal.getFont());
        labelQuantidade.setFont(labelNome.getFont());
        labelValor.setFont(labelNome.getFont());
        botaoNovoItem.setFont(labelValor.getFont());
        botaoFinalizarCompra.setFont(botaoNovoItem.getFont());
        botaoCancelarCompra.setFont(botaoNovoItem.getFont());
        botaoRemoverItem.setFont(botaoNovoItem.getFont());
        botaoAbrirFechar.setFont(botaoNovoItem.getFont());
        
        textoNome.setFont(new Font("Arial", Font.PLAIN, 14));
        textoQuantidade.setFont(textoNome.getFont());
        textoValor.setFont(textoNome.getFont());
        ////////////////////////////////////////////////
        //CORES
        painelPrincipal.setBackground(new Color(240, 240, 240));
        ////////////////////////////////
        
        //CONFIGURAÇÕES DA JANELA
        frame.getContentPane().add(painelPrincipal);
        
        frame.setSize(400, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(700, 200);
        frame.setVisible(true);
        /////////////////////////
        
        //associa o action listener aos botoes 
        this.botaoNovoItem.addActionListener(this);
        this.botaoFinalizarCompra.addActionListener(this);
        this.botaoAbrirFechar.addActionListener(this);
        this.botaoCancelarCompra.addActionListener(this);
        this.botaoRemoverItem.addActionListener(this);
        //LAYOUT!!
        //gbc.gridx = 0; //"POSICIONA" OBJETO NO PAINEL
        //gbc.gridy = 0;
        //gbc.weightx = 0.5; //DEFINE UMA PRIORIDADE DE TAMANHO
        //gbc.fill = GridBagConstraints.HORIZONTAL; //DIZ QUE O OBJETO PREENCHERÁ TODO ESPAÇO HORIZONTAL QUE FOI ESTABELECIDO PARA ELE
        //gbc.insets = new Insets(0, 10, 0, 0);
        //painelPrincipal.add(botaoAberto, gbc); //ADICIONA O OBJETO AO PAINEL CONSIDERANDO OS PARÂMETROS CONFIGURADOS ANTERIORMENTE
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelPrincipal.add(botaoAbrirFechar, gbc);
        
        //gbc.insets = new Insets(10, 20, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelPrincipal.add(labelNome, gbc);
        
        gbc.gridx = 1;
        gbc.ipady = 5;
        gbc.insets = new Insets(0,0,0,0);
        painelPrincipal.add(textoNome, gbc);
        
        gbc.ipady = 0;
        gbc.gridy = 2;
        gbc.gridx = 0;
        //gbc.insets = new Insets(10, 20, 0, 0);
        painelPrincipal.add(labelQuantidade, gbc);
        
        gbc.gridx = 1;
        gbc.ipady = 5;
        gbc.insets = new Insets(0,0,0,0);
        painelPrincipal.add(textoQuantidade, gbc);
        
        gbc.ipady = 0;
        gbc.gridy = 3;
        gbc.gridx = 0;
        //gbc.insets = new Insets(10,20,0,0);
        painelPrincipal.add(labelValor, gbc);
        
        gbc.gridx = 1;
        gbc.ipady = 5;
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelPrincipal.add(textoValor, gbc);
        
        gbc.ipady = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.insets = new Insets(10,0,0,0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelPrincipal.add(botaoNovoItem, gbc);
        
        gbc.gridheight = 4; //DEFINE UM ESPAÇO MAIOR (VERTICAL)
        gbc.gridy = 5;
        gbc.weighty = 0.6;
        gbc.fill = GridBagConstraints.BOTH; //PREENCHE OS ESPAÇOS VERTICAIS E HORIZONTAIS (POSSIVEIS)
        painelPrincipal.add(scroll, gbc); //ADICIONO O SCROLL E NAO O TEXTAREA
        
        gbc.gridy = 9;
        gbc.gridheight = 1;
        gbc.weighty = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painelPrincipal.add(labelTotal, gbc);
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        painelPrincipal.add(botaoRemoverItem, gbc);
        
        gbc.insets = new Insets(0,5,0,0);
        gbc.gridx = 1;
        painelPrincipal.add(botaoCancelarCompra, gbc);
        
        gbc.insets = new Insets(10,0,0,0);
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        painelPrincipal.add(botaoFinalizarCompra, gbc);
    }
    @Override
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getSource() == botaoNovoItem)
        {
            try{
                this.compraAtual.adicionarItem(this.pegaNovoItem());} //UTILIZA FUNÇÃO QUE CONVERTE OS VALORES DOS CAMPOS EM UM NOVO ITEM E O ARMAZENA NA VARIAVEL DE COMPRA ATUAL
            catch(NumberFormatException e) //CASO O USUÁRIO INSIRA ALGUM FORMATO INVÁLIDO NOS CAMPOS QUE DEVEM TER NÚMEROS
            {
                JOptionPane.showMessageDialog(null ,"Número de formato inválido!");
                return;
            }
            this.zeraCampos(); //APAGA OS CAMPOS DE PREENCHIMENTO
            this.memo.setText(this.compraAtual.exibirDetalhes()); //ATUALIZA A "LISTA" DE ITENS COMPRADOS
            this.labelTotal.setText(String.format("Valor da compra: R$%.2f", this.compraAtual.getValor())); //ATUALIZA O VALOR TOTAL DA COMPRA ATUAL (MOSTRANDO NO LABEL)
        }
        if(evento.getSource() == botaoFinalizarCompra)
        {
            this.novaCompra(compraAtual); //ADICIONA A COMPRA ATUAL NA LISTA DE COMPRAS DO CAIXA
            compraAtual = new Compra(); //REINICIA A VARIAVEL DE COMPRA ATUAL (ZERA)
            this.zeraCampos(); //APAGA TODOS OS CAMPOS
            this.memo.setText(""); // APAGA OS VALORES NA "LISTA" DE ITENS COMPRADOS
            this.labelTotal.setText("Valor da compra: R$0,00"); 
            JOptionPane.showMessageDialog(null, String.format("Total do caixa: R$%.2f", this.getTotalCaixa())); //MOSTRA O TOTAL ARRECADADO PELO CAIXA ATÉ O MOMENTO
        }
        if(evento.getSource() == botaoAbrirFechar)
        {
            if(botaoAbrirFechar.getText() == "Abrir caixa"){ //ABRE O CAIXA
                this.destravaTudo(); // LIBERA OS CAMPOS PARA SEREM PREENCHIDOS E BOTOES PARA SEREM CLICADOS
                this.abrirCaixa(); //"ABRE" O CAIXA
                this.botaoAbrirFechar.setText("Fechar caixa");
            }
            else{
                this.travaTudo(); //TRAVA CAMPOS E BOTOES
                this.fecharCaixa(); //"FECHA" O CAIXA
                this.botaoAbrirFechar.setText("Abrir caixa");
                JOptionPane.showMessageDialog(null, String.format("Total do caixa: R$%.2f", this.getTotalCaixa())); //MOSTRA O TOTAL ARRECADADO PELO CAIXA ATÉ O MOMENTO
            }
        }
        if(evento.getSource() == botaoRemoverItem){
            int numero = -1;
            while(numero <0){
                try{
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do item a ser removido"));
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Formato de número incorreto!");
                }
            }
            
            this.compraAtual.removerItem(numero);
            this.memo.setText(this.compraAtual.exibirDetalhes());
            this.labelTotal.setText(String.format("Valor da compra: R$%.2f", this.compraAtual.getValor()));
            
        }
        if(evento.getSource() == botaoCancelarCompra){
            this.compraAtual = new Compra();
            this.zeraCampos();
            this.memo.setText("");
            this.labelTotal.setText(String.format("Valor da compra: R$%.2f", this.compraAtual.getValor()));
        }
    }
    private void travaTudo() //TRAVA CAMPOS E BOTOES
    {
       this.botaoNovoItem.setEnabled(false);
       this.botaoFinalizarCompra.setEnabled(false);
       this.textoNome.setEnabled(false);
       this.textoQuantidade.setEnabled(false);
       this.textoValor.setEnabled(false);
       this.botaoCancelarCompra.setEnabled(false);
       this.botaoRemoverItem.setEnabled(false);
    }
    private void destravaTudo() //LIBERA CAMPOS E BOTOES
    {
        this.botaoNovoItem.setEnabled(true);
       this.botaoFinalizarCompra.setEnabled(true);
       this.textoNome.setEnabled(true);
       this.textoQuantidade.setEnabled(true);
       this.textoValor.setEnabled(true);
       this.botaoCancelarCompra.setEnabled(true);
       this.botaoRemoverItem.setEnabled(true);
    }
    private Item pegaNovoItem() //COLHE OS VALORES NOS CAMPOS DE TEXTO E OS UTILIZA PARA CARACTERIZAR UM NOVO ITEM
    {
        String nome = textoNome.getText();
        int quantidade = Integer.parseInt(textoQuantidade.getText());
        double valor = Double.parseDouble(textoValor.getText());
        
        Item i = new Item(nome, valor, quantidade);
        
        return i;
    }
    private void zeraCampos() //LIMPA CAMPOS
    {
        this.textoNome.setText("");
        this.textoQuantidade.setText("");
        this.textoValor.setText("");
    }
}
