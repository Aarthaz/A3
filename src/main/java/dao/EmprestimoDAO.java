package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Emprestimo;

public class EmprestimoDAO extends BaseDAO {
    
     public boolean insertEmprestimoBD(Emprestimo emprestimo) {
        
        String sql = "INSERT INTO tb_emprestimo (data_emprestimo, data_devolucao, id_amigo, id_ferramenta) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(emprestimo.getDataEmprestimo().getTime()));
            stmt.setDate(2, new java.sql.Date(emprestimo.getDataDevolucao().getTime()));
            stmt.setInt(3, emprestimo.getAmigo().getId());
            stmt.setInt(4, emprestimo.getFerramenta().getId());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }
   
     
    // Método para deletar um empréstimo do banco de dados pelo ID
    public boolean deleteEmprestimoBD(int id) {
        String sql = "DELETE FROM tb_emprestimo WHERE id = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }
    
}