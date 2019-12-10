
package fatec.poo.control;

import fatec.poo.model.Instrutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Felipe Camargo  RA: 0030481813029
 * Vinicius Bistão RA: 0030481813011
 */
public class DaoInstrutor {
    
    private Connection conn;

    public DaoInstrutor(Connection conn) {
        this.conn = conn;
    }

    //Inserir
    public void inserir(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TBINSTRUTOR(CPF, "
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
                                                             + "FORMACAO, "
                                                             + "AREAATU)"
                                                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, instrutor.getCpf());
            ps.setString(2, instrutor.getNome());
            ps.setString(3, instrutor.getDtNasc());
            ps.setString(4, instrutor.getEndereco());
            ps.setInt(5, instrutor.getNumero());
            ps.setString(6, instrutor.getBairro());
            ps.setString(7, instrutor.getCidade());
            ps.setString(8, instrutor.getEstado());
            ps.setString(9, instrutor.getCep());            
            ps.setString(10, instrutor.getTelRes());
            ps.setString(11, instrutor.getCelular());
            ps.setString(12, instrutor.getSexo());
            ps.setString(13, instrutor.getEstadoCivil());
            ps.setString(14, instrutor.getRg());
            ps.setString(15, instrutor.getEmail());                        
            ps.setString(16, instrutor.getFormacao());
            ps.setString(17, instrutor.getAreaAtu()); 
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Alterar
    public void alterar(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE TBINSTRUTOR SET NOME = ?, "
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
                                                            + "FORMACAO = ?, "
                                                            + "AREAATU = ? "
                                                      + "WHERE CPF = ?");
            
            ps.setString(1, instrutor.getNome());
            ps.setString(2, instrutor.getDtNasc());
            ps.setString(3, instrutor.getEndereco());
            ps.setInt(4, instrutor.getNumero());
            ps.setString(5, instrutor.getBairro());
            ps.setString(6, instrutor.getCidade());
            ps.setString(7, instrutor.getEstado());
            ps.setString(8, instrutor.getCep());            
            ps.setString(9, instrutor.getTelRes());
            ps.setString(10, instrutor.getCelular());
            ps.setString(11, instrutor.getSexo());
            ps.setString(12, instrutor.getEstadoCivil());
            ps.setString(13, instrutor.getRg());
            ps.setString(14, instrutor.getEmail());                        
            ps.setString(15, instrutor.getFormacao());
            ps.setString(16, instrutor.getAreaAtu()); 
            ps.setString(17, instrutor.getCpf());
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    //Consultar

    public Instrutor consultar(String cpf) {
        Instrutor i = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM TBINSTRUTOR WHERE "
                    + "CPF = ?");

            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                i = new Instrutor(cpf, rs.getString("NOME"));
                i.setDtNasc(rs.getString("DTNASC"));
                i.setEndereco(rs.getString("ENDERECO"));
                i.setNumero(rs.getInt("NUMERO"));
                i.setBairro(rs.getString("BAIRRO"));
                i.setCidade(rs.getString("CIDADE"));
                i.setEstado(rs.getString("ESTADO"));
                i.setCep(rs.getString("CEP"));
                i.setTelRes(rs.getString("TELRES"));
                i.setCelular(rs.getString("CELULAR"));
                i.setSexo(rs.getString("SEXO"));
                i.setEstadoCivil(rs.getString("ESTADOCIVIL"));
                i.setRg(rs.getString("RG"));
                i.setEmail(rs.getString("EMAIL"));
                i.setFormacao(rs.getString("FORMACAO"));
                i.setAreaAtu(rs.getString("AREAATU"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (i);
    }

    //Excluir
    public void excluir(Instrutor instrutor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM TBINSTRUTOR WHERE CPF = ?");

            ps.setString(1, instrutor.getCpf());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public ArrayList<String> listarInstrutores() throws SQLException{
        PreparedStatement ps = null;
        ArrayList<String> nomesInstrutores = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement("SELECT NOME FROM TBINSTRUTOR");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                nomesInstrutores.add(rs.getString("NOME"));
            }
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return nomesInstrutores;
    }   
}