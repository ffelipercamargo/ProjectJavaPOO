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
public class Curso {
    private String siglaCurso;
    private String nome;
    private int cargaHoraria;
    private double valor;
    private String dtVigencia;
    private double valHrInstrutor;
    private String programa;
    private ArrayList<Turma> turmas;

    public Curso(String siglaCurso, String nome) {
        this.siglaCurso = siglaCurso;
        this.nome = nome;        
        turmas = new ArrayList<Turma>();
    }

    public String getSiglaCurso() {
        return siglaCurso;
    }

    public void setSiglaCurso(String siglaCurso) {
        this.siglaCurso = siglaCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDtVigencia() {
        return dtVigencia;
    }

    public void setDataVigencia(String dataVigencia) {
        this.dtVigencia = dataVigencia;
    }

    public double getValHrInstrutor() {
        return valHrInstrutor;
    }

    public void setValHrInstrutor(double valHrInstrutor) {
        this.valHrInstrutor = valHrInstrutor;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }



}
