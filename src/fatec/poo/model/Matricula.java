
package fatec.poo.model;

/**
 * Felipe Camargo  RA: 0030481813029
 * Vinicius Bistão RA: 0030481813011
 */
public class Matricula {
    
    private String data;
    private int qtdeFaltas;
    private double nota;
    private APrazo aprazo;
    private AVista avista;

    public Matricula(String data) {
        this.data = data;
    }

    public void setQtdeFaltas(int qtdeFaltas) {
        this.qtdeFaltas = qtdeFaltas;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setAprazo(APrazo aprazo) {
        this.aprazo = aprazo;
    }

    public void setAvista(AVista avista) {
        this.avista = avista;
    }
   
    
}
