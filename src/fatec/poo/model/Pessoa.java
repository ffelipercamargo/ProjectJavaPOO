/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 * Felipe Camargo  RA: 0030481813029
 * Vinicius Bistão RA: 0030481813011
 */
public abstract class Pessoa {
    private String nome;
    private String dtNasc;
    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String telRes;
    private String celular;
    private String sexo;
    private String estadoCivil;
    private String rg;
    private String cpf;
    private String email;
    
    public Pessoa(String cpf, String nome) {
    this.cpf = cpf;
    this.nome = nome;
    }
  
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getCelular() {
        return celular;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getRg() {
        return rg;
    }

    public String getEmail() {
        return email;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getTelRes() {
        return telRes;
    }

    public void setTelRes(String telRes) {
        this.telRes = telRes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }    
    
    public static boolean validarCPF(String cpf){
        cpf = retiraCaracteres(cpf);
        int firstDigit = 0;
        int secondDigit = 0;
        
        char[] arrCPF = new char[11];
        arrCPF = cpf.toCharArray();
        
        for(int i = 0; i < arrCPF.length-2; i++){
         firstDigit += Character.getNumericValue(arrCPF[i])* (i+1);
         secondDigit += Character.getNumericValue(arrCPF[i]) * (11-i);
        }
        firstDigit %= 11;
        
        if (firstDigit == 10) {
            firstDigit = 0;
        }
        
        secondDigit = ((secondDigit  + firstDigit *2) * 10) % 11;
        
        if (secondDigit == 10) {
            secondDigit = 0;
        }
        
        return firstDigit == Character.getNumericValue(arrCPF[9]) && secondDigit == Character.getNumericValue(arrCPF[10]);
    }
    
    public static String retiraCaracteres(String cpf) {
        return cpf.replace(".", "").replace("-", "").replace(" ", "");
    }
}
