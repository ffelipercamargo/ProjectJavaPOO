package fatec.poo.control;

import fatec.poo.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Felipe Camargo  RA: 0030481813029
 * Vinicius Bistão RA: 0030481813011
 */

public class DaoCurso {
    private Connection conn;

    public DaoCurso(Connection conn) {
        this.conn = conn;
    }

    //Inserir
    public void inserir(Curso curso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TBCURSO (SIGLACURSO, "
                                                          + "NOME, "
                                                          + "CARGAHORARIA, "
                                                          + "VALOR, "  
                                                          + "DTVIGENCIA, "                  
                                                          + "VALHRINSTRUTOR, "
                                                          + "PROGRAMA) "
                                                + " VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, curso.getSiglaCurso());
            ps.setString(2, curso.getNome());
            ps.setInt(3, curso.getCargaHoraria());
            ps.setDouble(4, curso.getValor());
            ps.setString(5, curso.getDtVigencia());
            ps.setDouble(6, curso.getValHrInstrutor());
            ps.setString(7, curso.getPrograma());
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Alterar
    public void alterar(Curso curso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE TBCURSO SET NOME = ?, "
                                                         + "CARGAHORARIA = ?, "
                                                         + "VALOR = ?, "
                                                         + "DTVIGENCIA = ?, "
                                                         + "VALHRINSTRUTOR = ?, "
                                                         + "PROGRAMA = ? "
                                                   + "WHERE SIGLACURSO = ?");
            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getCargaHoraria());
            ps.setDouble(3, curso.getValor());
            ps.setString(4, curso.getDtVigencia());
            ps.setDouble(5, curso.getValHrInstrutor());
            ps.setString(6, curso.getPrograma());
            ps.setString(7, curso.getSiglaCurso());
            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Consultar
    public Curso consultar(String siglaCurso) {
        Curso c = null;
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM TBCURSO " + 
                                               "WHERE SIGLACURSO = ?");
            ps.setString(1, siglaCurso);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                c = new Curso(siglaCurso, rs.getString("NOME"));                
                c.setCargaHoraria(rs.getInt("CARGAHORARIA"));
                c.setValor(rs.getDouble("VALOR"));
                c.setDataVigencia(rs.getString("DTVIGENCIA"));
                c.setValHrInstrutor(rs.getDouble("VALHRINSTRUTOR"));
                c.setPrograma(rs.getString("PROGRAMA"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (c);
    }

    //Excluir
    public void excluir(Curso curso) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM TBCURSO " + 
                                             "WHERE SIGLACURSO = ?");
            ps.setString(1, curso.getSiglaCurso());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    } 
    
    public ArrayList<String> listarSiglas() {
        PreparedStatement ps = null;
        ArrayList<String> siglasCursos = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT SIGLACURSO FROM TBCURSO");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                siglasCursos.add(rs.getString("SIGLACURSO"));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());                    
        }
        
        return siglasCursos;        
    }
}
