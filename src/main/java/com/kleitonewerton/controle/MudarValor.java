/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.controle;

import com.kleitonewerton.controledeestoque.Produto;
import com.kleitonewerton.views.Tela;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author KleitonEwerton
 * 
 * @brief Classe que modifica os valores dos campos de input de acordo com o produto selecionado na tabela
 */
public class MudarValor  implements ListSelectionListener{

    private Tela tela;

    public MudarValor(Tela tela) {
        this.tela = tela;
    }
    
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        int indexLinha = this.tela.getTable().getSelectedRow();
        
        if( indexLinha < 0)return;
        
        try{
            
                Produto produto = this.tela.getModel().getProduto(indexLinha);
                tela.getNomeInput().setText(produto.getNome());
                tela.getValorInput().setText(Double.toString(produto.getValor()));
                tela.getQuantidadeInput().setText(Integer.toString(produto.getQuantidade()));
                tela.getDescricaoInput().setText(produto.getDescricao());
            
            
        }catch(Exception ex){
            
            System.out.println("ERRO");
            
        }
        
    }
    
}
