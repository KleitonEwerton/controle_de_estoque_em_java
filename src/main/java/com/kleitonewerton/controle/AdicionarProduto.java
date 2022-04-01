/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.controle;

import com.kleitonewerton.controledeestoque.Produto;
import com.kleitonewerton.views.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author KleitonEwerton
 * 
 * @brief Classe usada para adicionar um novo produto 
 */
public class AdicionarProduto implements ActionListener{

    private final Tela tela;

    public AdicionarProduto(Tela tela) {
        this.tela = tela;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String nome = tela.getNomeInput().getText();
        String descricao = tela.getDescricaoInput().getText(); 
        double valor;
        int quantidade;
        
        //Condição do nome
        if(nome.equals("" )){
            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR\nNOME OBRIGATÓRIO", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Try do valor
        try{
            
            valor = Double.parseDouble(tela.getValorInput().getText());
           
            
        }catch(NumberFormatException ex){
            
            JOptionPane.showMessageDialog(null, "Valor Inválido", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Try da quantidade
        try{
            
            quantidade = Integer.parseInt(tela.getQuantidadeInput().getText());
           
        }catch(NumberFormatException ex){
            
            JOptionPane.showMessageDialog(null, "Quantidade Inválida", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Modifica quantidades < 0 para o valor minímo (0)
        if(quantidade < 0)quantidade = 0;
        tela.getQuantidadeInput().setText(Integer.toString(quantidade));
        
        this.tela.getModel().addNovoProduto(new Produto(nome,valor,quantidade,descricao));
        
    }
    
}
