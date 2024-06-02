package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Emprestimo;

public class EmprestimoDAO extends BaseDAO {

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