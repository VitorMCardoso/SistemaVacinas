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
public class PedidoCompra {
    private int id;
    private Date data;
    private int quantidadeVac;
    private int idLaboratorio;
    private int idVacinas;
    private boolean ativo;

    public PedidoCompra() {
    }

    public PedidoCompra(int id, Date data, int quantidadeVac, int idLaboratorio, int idVacinas, boolean ativo) {
        this.id = id;
        this.data = data;
        this.quantidadeVac = quantidadeVac;
        this.idLaboratorio = idLaboratorio;
        this.idVacinas = idVacinas;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidadeVac() {
        return quantidadeVac;
    }

    public void setQuantidadeVac(int quantidadeVac) {
        this.quantidadeVac = quantidadeVac;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public int getIdVacinas() {
        return idVacinas;
    }

    public void setIdVacinas(int idVacinas) {
        this.idVacinas = idVacinas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
