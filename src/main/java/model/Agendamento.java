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
    private int quantidadeVac;
    private Paciente paciente;
    private Vacinas vacinas;
    private boolean ativo;

    public Agendamento() {
    }

    public Agendamento(int id, Date dataDose, int quantidadeVac, Paciente paciente, Vacinas vacinas, boolean ativo) {
        this.id = id;
        this.dataDose = dataDose;
        this.quantidadeVac = quantidadeVac;
        this.paciente = paciente;
        this.vacinas = vacinas;
        this.ativo = ativo;
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

    public int getQuantidadeVac() {
        return quantidadeVac;
    }

    public void setQuantidadeVac(int quantidadeVac) {
        this.quantidadeVac = quantidadeVac;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
