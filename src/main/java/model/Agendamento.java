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
public class Agendamento {
    private int id;
    private Date dataDose;
    private int quantidade;
    private int idPaciente;
    private int idVacinas;
    private boolean ativo;

    public Agendamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataDose() {
        return dataDose;
    }

    public void setDataDose(Date dataDose) {
        this.dataDose = dataDose;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public int getPaciente() {
        return idPaciente;
    }

    public void setPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getVacinas() {
        return idVacinas;
    }

    public void setVacinas(int idVacinas) {
        this.idVacinas = idVacinas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
