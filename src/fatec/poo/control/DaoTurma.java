package fatec.poo.control;

import fatec.poo.model.Turma;
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
public class DaoTurma {
    
    private Connection conn;

    public DaoTurma(Connection conn) {
        this.conn = conn;
    }

    //Inserir
    public void inserir(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TBTURMA (SIGLATURMA, "
                                                          + "DESCRICAO, "
                                                          + "DTINICIO, "
                                                          + "DTTERMINO, "
                                                          + "PERIODO, "
                                                          + "QTDEVAGAS,"
                                                          + "SIGLACURSO) "
                                                          + "VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, turma.getSiglaTurma());
            ps.setString(2, turma.getDescricao());
            ps.setString(3, turma.getDtInicio());
            ps.setString(4, turma.getDtTermino());
            ps.setString(5, turma.getPeriodo());
            ps.setInt(6, turma.getQtdeVagas());
            ps.setString(7, turma.getCurso().getSiglaCurso());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Alterar
    public void alterar(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE TBTURMA SET DESCRICAO = ?,"
                                                        + "DTINICIO = ?, "
                                                        + "DTTERMINO = ?, "
                                                        + "PERIODO = ?, "
                                                        + "QTDEVAGAS = ?, "
                                                        + "SIGLACURSO = ? "
                                                        + "WHERE SIGLATURMA = ?");

            ps.setString(1, turma.getDescricao());
            ps.setString(2, turma.getDtInicio());
            ps.setString(3, turma.getDtTermino());
            ps.setString(4, turma.getPeriodo());
            ps.setInt(5, turma.getQtdeVagas());
            ps.setString(6, turma.getCurso().getSiglaCurso());
            ps.setString(7, turma.getSiglaTurma());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    //Consultar

    public Turma consultar(String siglaTurma) {
        Turma t = null;
        Curso c = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM TBTURMA WHERE "
                    + "SIGLATURMA = ?");

            ps.setString(1, siglaTurma);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                t = new Turma(siglaTurma, rs.getString("SIGLATURMA"));
                t.setDescricao(rs.getString("DESCRICAO"));
                t.setDtInicio(rs.getString("DTINICIO"));
                t.setDtTermino(rs.getString("DTTERMINO"));
                t.setQtdeVagas(rs.getInt("QTDEVAGAS"));
                t.setPeriodo(rs.getString("PERIODO"));
                //verificar 
                c = new Curso(rs.getString("SIGLACURSO"), rs.getString("NOME"));
                t.setCurso(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (t);
    }

    //Excluir
    public void excluir(Turma turma) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM TBTURMA WHERE SIGLATURMA = ?");

            ps.setString(1, turma.getSiglaTurma());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }  
    
    public ArrayList<String> listarSiglas() throws SQLException{
        PreparedStatement ps = null;
        ArrayList<String> siglasTurmas = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT SIGLATURMA FROM TBTURMA");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                siglasTurmas.add(rs.getString("SIGLATURMA"));
            }
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return siglasTurmas;
    }      
           
}
