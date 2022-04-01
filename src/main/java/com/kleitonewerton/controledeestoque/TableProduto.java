/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.controledeestoque;

import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author KleitonEwerton
 * 
 * !!! OBS: Minha referências para construção
 *                                                             https://www.devmedia.com.br/ordenando-e-filtrando-tabelas-com-o-java-se-6-0/1668
 *                                                             https://www.devmedia.com.br/implementando-seu-proprio-tablemodel/31865
 *                                                             https://www.devmedia.com.br/modificando-o-nome-de-uma-coluna-em-um-jtable/2087   
 */
public class TableProduto extends AbstractTableModel{
    
    private final String[] colunas = new String[]{"NOME","VALOR","QUANTIDADE", "DESCRIÇÃO"};
    private final List<Produto> listProduto = new ArrayList<>();    
    
   
    public TableProduto(){
        
    }
    
    @Override
    public String getColumnName(int indexColuna){
        
        return colunas[indexColuna];//Retorna a coluna
        
    }
    
    @Override 
    public int getRowCount() {
        return this.listProduto.size();//Retona o tamanho da lista de produtos
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;//Retorna a quantidade de colunas
    }

    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        
        switch(indexColuna){
            
            case 0:
                return this.listProduto.get(indexLinha).getNome();      //Retorna o nome desse produto
            case 1:
                return this.listProduto.get(indexLinha).getValor();     //Retorna o valor desse produto
            case 2:
                return this.listProduto.get(indexLinha).getQuantidade();//Retorna a quantidade desse produto
            case 3:
                return this.listProduto.get(indexLinha).getDescricao(); //Retorna a descrição desse produto
            
        }
        return null;
        
    }
    
    /**
    * @brief        Método para adicionar um novo produto a tabela
    * 
    * @param produto    O produto a ser adicionado
    */
    public void addNovoProduto(Produto produto){
        
        this.listProduto.add(produto);      //Adiciona o novo produto
        this.fireTableDataChanged();          //Atualiza a tabela
        
    }
    
    /**
    * @brief        Método para remover um produto da tabela
    * 
    * @param indexLinha index da linha do produto a ser removida
    */
    public void removeProduto(int indexLinha){
        
        this.listProduto.remove(indexLinha);                      //Remove a linha
        this.fireTableRowsDeleted(indexLinha,indexLinha);//Atualiza a tabela
        
    }
    
    /**
    * @brief                Método para remover um produto da tabela
    * 
    * @param indexProduto   Index da linha do produto selecionado
    * @return               Produto selecionado
    */
    public Produto getProduto(int indexProduto){
        return this.listProduto.get(indexProduto);
    }
}
