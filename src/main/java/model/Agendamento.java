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
    private Paciente paciente;
    private Vacinas vacinas;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente idPaciente) {
        this.paciente = idPaciente;
    }

    public Vacinas getVacinas() {
        return vacinas;
    }

    public void setVacinas(Vacinas idVacinas) {
        this.vacinas = idVacinas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
