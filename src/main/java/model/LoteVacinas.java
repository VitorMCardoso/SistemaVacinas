/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vitor
 */
public class LoteVacinas {

    private int id;
    private int quantidadeVac;
    private Laboratorio laboratorio;
    private Vacinas vacina;
    private boolean ativo;

    public LoteVacinas(int id, int quantidadeVac, Laboratorio laboratorio, Vacinas vacina, boolean ativo) {
        this.id = id;
        this.quantidadeVac = quantidadeVac;
        this.laboratorio = laboratorio;
        this.vacina = vacina;
        this.ativo = ativo;
    }

    public LoteVacinas(int id) {
        this.id = id;
    }

    public LoteVacinas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Vacinas getVacina() {
        return vacina;
    }

    public void setVacina(Vacinas vacina) {
        this.vacina = vacina;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
