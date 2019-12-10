package fatec.poo.control;

import fatec.poo.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Felipe Camargo  RA: 0030481813029
 * Vinicius Bistão RA: 0030481813011
 */
public class DaoAluno {
    private Connection conn;

    public DaoAluno(Connection conn) {
        this.conn = conn;
    }

    //Inserir
    public void inserir(Aluno aluno) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TBALUNO (CPF, "
                                                          + "NOME, "
                                                          + "DTNASC, "
                                                          + "ENDERECO, "
                                                          + "NUMERO, "
                                                          + "BAIRRO, "
                                                          + "CIDADE, "
                                                          + "ESTADO, "
                                                          + "CEP, "
                                                          + "TELRES, "
                                                          + "CELULAR, "
                                                          + "SEXO, "
                                                          + "ESTADOCIVIL, "
                                                          + "RG, "
                                                          + "EMAIL, "
                                                          + "ESCOLARIDADE)"
                                                          + " VALUES "
                                                          + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getDtNasc());
            ps.setString(4, aluno.getEndereco());
            ps.setInt(5, aluno.getNumero());
            ps.setString(6, aluno.getBairro());
            ps.setString(7, aluno.getCidade());
            ps.setString(8, aluno.getEstado());
            ps.setString(9, aluno.getCep());            
            ps.setString(10, aluno.getTelRes());
            ps.setString(11, aluno.getCelular());
            ps.setString(12, aluno.getSexo());
            ps.setString(13, aluno.getEstadoCivil());
            ps.setString(14, aluno.getRg()); 
            ps.setString(15, aluno.getEmail());                       
            ps.setString(16, aluno.getEscolaridade());   
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Alterar
    public void alterar(Aluno aluno) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE TBALUNO SET NOME = ?, "
                                                        + "DTNASC = ?, "
                                                        + "ENDERECO = ?, "
                                                        + "NUMERO = ?, "
                                                        + "BAIRRO = ?, "
                                                        + "CIDADE = ?, "
                                                        + "ESTADO = ?, "
                                                        + "CEP = ?, "
                                                        + "TELRES = ?, "
                                                        + "CELULAR = ?, "
                                                        + "SEXO = ?, "
                                                        + "ESTADOCIVIL = ?, "
                                                        + "RG = ?, "
                                                        + "EMAIL = ?, "                    
                                                        + "ESCOLARIDADE = ? "
                                                        + "WHERE CPF = ?");
            
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getDtNasc());
            ps.setString(3, aluno.getEndereco());
            ps.setInt(4, aluno.getNumero());
            ps.setString(5, aluno.getBairro());
            ps.setString(6, aluno.getCidade());
            ps.setString(7, aluno.getEstado());
            ps.setString(8, aluno.getCep());            
            ps.setString(9, aluno.getTelRes());
            ps.setString(10, aluno.getCelular());
            ps.setString(11, aluno.getSexo());
            ps.setString(12, aluno.getEstadoCivil());
            ps.setString(13, aluno.getRg()); 
            ps.setString(14, aluno.getEmail());                       
            ps.setString(15, aluno.getEscolaridade());
            ps.setString(16, aluno.getCpf());
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    //Consultar

    public Aluno consultar(String cpf) {
        Aluno a = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM TBALUNO WHERE "
                    + "CPF = ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                a = new Aluno(cpf, rs.getString("NOME"));
                a.setDtNasc(rs.getString("DTNASC"));
                a.setEndereco(rs.getString("ENDERECO"));
                a.setNumero(rs.getInt("NUMERO"));
                a.setBairro(rs.getString("BAIRRO"));
                a.setCidade(rs.getString("CIDADE"));
                a.setEstado(rs.getString("ESTADO"));
                a.setCep(rs.getString("CEP"));
                a.setTelRes(rs.getString("TELRES"));
                a.setCelular(rs.getString("CELULAR"));
                a.setSexo(rs.getString("SEXO"));
                a.setEstadoCivil(rs.getString("ESTADOCIVIL"));
                a.setRg(rs.getString("RG"));
                a.setEmail(rs.getString("EMAIL"));
                a.setEscolaridade(rs.getString("ESCOLARIDADE"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (a);
    }

    //Excluir
    public void excluir(Aluno aluno) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM TBALUNO WHERE CPF = ?");

            ps.setString(1, aluno.getCpf());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}