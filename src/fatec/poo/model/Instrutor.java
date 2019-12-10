/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.util.ArrayList;

/**
 * Felipe Camargo  RA: 0030481813029
 * Vinicius Bistão RA: 0030481813011
 */
public class Instrutor extends Pessoa{
    private String formacao;
    private String areaAtu;
    private ArrayList<Turma> turmas;
    private Turma turma;

    public Instrutor(String cpf, String nome) {
        super(cpf, nome);        
        this.turmas = new ArrayList<Turma>();
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getFormacao() {
        return formacao;
    }

    public String getAreaAtu() {
        return areaAtu;
    }

    public void setAreaAtu(String areaAtu) {
        this.areaAtu = areaAtu;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    

}
