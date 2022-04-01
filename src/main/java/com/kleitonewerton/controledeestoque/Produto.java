/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.controledeestoque;

/**
 *
 * @author KleitonEwerton
 * 
 * @brief Classe dos produtos
 */
public class Produto {
    
    String nome;
    double valor;
    int quantidade;
    String descricao;

    /**
     * @brief Construtor da classe produto
     * 
     * @param nome              Nome do produto
     * @param valor             Valor do produto
     * @param quantidade        Quantidade desse produto
     * @param descricao         Descrição desse produto
    */
    public Produto(String nome, double valor, int quantidade, String descricao) {
        
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    /**
    * @brief        Método get do nome 
    * @return       Nome
    */
    public String getNome() {
        return nome;
    }

    /**
     * @brief       Método set do nome
     * 
     * @param nome  novo nome
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
    * @brief        Método get do nome 
    * @return       Valor
    */
    public double getValor() {
        return valor;
    }

    /**
    * @brief       Método set do valor
    * 
    * @param valor  novo valor
    */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
    * @brief        Método get da quantidade 
    * @return       Quantidade
    */
    public int getQuantidade() {
        return quantidade;
    }

    /**
    * @brief       Método set da quantidade
    * 
    * @param quantidade     nova quantidade
    */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
    * @brief        Método get da descrição
    * @return       Descricao
    */
    public String getDescricao() {
        return descricao;
    }

    /**
    * @brief       Método set da descrição
    * 
    * @param descricao nova descricao
    */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
