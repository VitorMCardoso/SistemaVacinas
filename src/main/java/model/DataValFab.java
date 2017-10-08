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
public class DataValFab {
    private int id;
    private Date dataValidade;
    private Date dataFabricacao;    
    private LoteVacinas lote;

    public DataValFab(int id, Date dataValidade, Date dataFabricacao, LoteVacinas lote) {
        this.id = id;
        this.dataValidade = dataValidade;
        this.dataFabricacao = dataFabricacao;
        this.lote = lote;
    }

    public DataValFab(int id) {
        this.id = id;
    }

    public DataValFab() {
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

    public LoteVacinas getLote() {
        return lote;
    }

    public void setLote(LoteVacinas lote) {
        this.lote = lote;
    }
    
}
