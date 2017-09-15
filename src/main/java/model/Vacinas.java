/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author vitor
 */
public class Vacinas {

    private int id;
    private Date dataValidade;
    private Date dataFabricacao;
    private String nome;
    private String tipo;
    private int quantidade;
    private int idLote;

    public Vacinas(int id, Date dataValidade, Date dataFabricacao, String nome, String tipo, int quantidade, int idLote) {
        this.id = id;
        this.dataValidade = dataValidade;
        this.dataFabricacao = dataFabricacao;
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.idLote = idLote;
    }

    public Vacinas() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

}
