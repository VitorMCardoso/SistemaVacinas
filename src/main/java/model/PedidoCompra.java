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
    private Laboratorio laboratorio;
    private Vacinas vacinas;
    private boolean ativo;

    public PedidoCompra() {
    }

    public PedidoCompra(int id, Date data, int quantidadeVac, Laboratorio laboratorio, Vacinas vacinas, boolean ativo) {
        this.id = id;
        this.data = data;
        this.quantidadeVac = quantidadeVac;
        this.laboratorio = laboratorio;
        this.vacinas = vacinas;
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Vacinas getVacinas() {
        return vacinas;
    }

    public void setVacinas(Vacinas vacinas) {
        this.vacinas = vacinas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
