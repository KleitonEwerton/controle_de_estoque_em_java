/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.views;

import com.kleitonewerton.controledeestoque.TableProduto;
import com.kleitonewerton.controle.AdicionarProduto;
import com.kleitonewerton.controle.MudarValor;
import com.kleitonewerton.controle.RemoveProduto;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author KleitonEwerton
 */
public class Tela extends JFrame{
    
    private JPanel panelPrincipal;
    private JPanel panelDireita;
    private JPanel panelEsquerda;
    private final int altura = 400;
    private final int largura = 1200;
    
    private TableProduto model;
    private JTable table;
    
    private JTextField nomeInput;
    private JTextField valorInput;
    private JTextField quantidadeInput;
    private JTextField descricaoInput;
    
    /**
    * @brief construtor da classe Tela 
    */
    public Tela(){
        super("Controle de Estoque");
        
    }
    
    /**
     * @brief       Método que desenha a tela principal
    */
    public void draw(){
        
        this.panelPrincipal = new JPanel();
        this.panelPrincipal.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.largura,this.altura);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        
        drawLeftPanel();
        drawRightPanel();
        
        GridLayout grid = new GridLayout(0,2,0,5);
        
        this.panelPrincipal.setLayout(grid);
        
        this.panelPrincipal.add(this.panelEsquerda);
        this.panelPrincipal.add(this.panelDireita);
        this.add(this.panelPrincipal,BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
    /**
     * @brief       Método que desenha o painel da direita
    */
    private void drawRightPanel(){
        
        this.panelDireita = new JPanel();
        
        this.panelDireita.setLayout(new BorderLayout());
        
        //!!! OBS: Referências do construtor do table model:    https://www.devmedia.com.br/ordenando-e-filtrando-tabelas-com-o-java-se-6-0/1668
        //                                                      https://www.devmedia.com.br/implementando-seu-proprio-tablemodel/31865
        //                                                      https://www.devmedia.com.br/modificando-o-nome-de-uma-coluna-em-um-jtable/2087
        
        this.model = new TableProduto();
        
        table = new JTable(model);
        table.setVisible(true);
       
        this.table.getSelectionModel().addListSelectionListener(new MudarValor(this));
        
        this.panelDireita.add(new JScrollPane(table));
        
    }
    
    /**
     * @brief       Método que desenha o painel da esquerda
    */
    private void drawLeftPanel(){
        
        this.panelEsquerda = new JPanel();
        this.panelEsquerda.setBorder(BorderFactory.createTitledBorder("Produto"));
        this.panelEsquerda.setLayout(new GridLayout(2,0,20, 0));
        
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        
        painel1.setLayout(new GridLayout(0,2,20,10));
        
        JLabel nome = new JLabel("NOME: ");
        this.nomeInput = new JTextField(50);
        
        JLabel valor = new JLabel("VALOR: ");
        this.valorInput = new JTextField(50);
        
        JLabel quantidade = new JLabel("QUANTIDADE: ");
        this.quantidadeInput = new JTextField(50);
        
        JLabel descricao = new JLabel("DESCRIÇÃO (OPCIONAL): ");
        this.descricaoInput = new JTextField(50);
        
        JButton btnAdicionar = new JButton("ADICIONAR");
        btnAdicionar.addActionListener(new AdicionarProduto(this));
        
        JButton btnRemover = new JButton("REMOVER");
        btnRemover.addActionListener(new RemoveProduto(this));
        
        painel1.add(nome);
        painel1.add(nomeInput);
        
        painel1.add(valor);
        painel1.add(valorInput);
        
        painel1.add(quantidade);
        painel1.add(quantidadeInput);
         
        painel1.add(descricao);
        painel1.add(descricaoInput);
        
        painel2.add(btnAdicionar);
        painel2.add(btnRemover);
        
        this.panelEsquerda.add(painel1);
        this.panelEsquerda.add(painel2);
        
    }

    /**
    *  @brief   Retorna o model da tabela
    *  @return  Model da tabela
    */
    public TableProduto getModel() {
        return model;
    }

    /**
    *  @brief   Retorna a tabela
    *  @return  Tabela (JTable)
    */
    public JTable getTable() {
        return table;
    }
    
    /**
    *  @brief   Retorna o nome do campo Input
    *  @return  Nome do campo input
    */
    public JTextField getNomeInput() {
        return nomeInput;
    }

    /**
    *  @brief   Retorna o valor do campo Input
    *  @return  Valor do campo input
    */
    public JTextField getValorInput() {
        return valorInput;
    }

    /**
    *  @brief   Retorna o Quantidade do campo Input
    *  @return  Quantidade do campo input
    */
    public JTextField getQuantidadeInput() {
        return quantidadeInput;
    }

    /**
    *  @brief   Retorna o descrição do campo Input
    *  @return  Descrição do campo input
    */
    public JTextField getDescricaoInput() {
        return descricaoInput;
    }
    
    
    
}


