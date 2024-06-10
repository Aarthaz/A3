package dao;

import modelo.Emprestimo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

    public class EmprestimoDAO extends BaseDAO {
    
        private static final String URL = "jdbc:mysql://localhost:3306/db_ferramentas";
        private static final String USER = "root"; 
        private static final String PASSWORD = "1234"; 

        private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
     
     /*
      * Método para obter a lista de todos os empréstimos
      */
        
     public List<Emprestimo> getMinhaLista() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM tb_emprestimos";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {   
            while (rs.next()) {               
            }           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }      
        return emprestimos;
    }
     
     /*
      * Método para inserir um novo empréstimo no banco de dados
      */
     
     public boolean insertEmprestimoBD(Emprestimo emprestimo) {
        String sql = "INSERT INTO tb_emprestimos (idA, dtEmprestimo, dtDevolucao) VALUES (?, ?, ?)";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, emprestimo.getAmigo().getId());
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            pstmt.setString(2, sdf.format(emprestimo.getDtEmprestimo()));
            pstmt.setString(3, sdf.format(emprestimo.getDtDevolucao()));
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /*
     * Método para deletar um empréstimo do banco de dados pelo ID
     */
    public boolean deleteEmprestimoBD(int id) {
        String sql = "DELETE FROM tb_emprestimos WHERE idE = ?";
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
    
     /*
      * Metodo para obter o maior ID de empréstimo no banco de dados
      */
    public int maiorID() {
        String sql = "SELECT MAX(id) AS max_id FROM tb_emprestimos";
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int maxID = rs.getInt("max_id");
            stmt.close();
            return maxID;
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }
    
       /*
        * Método que atualiza um registro de empréstimo no banco de dados   
        */
    
       public boolean updateEmprestimoBD(Emprestimo emprestimo) {
        String sql = "UPDATE tb_emprestimos SET dtEmprestimo = ?, dtDevolucao = ?, idA = ? WHERE idE = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(emprestimo.getDtEmprestimo().getTime()));
            stmt.setDate(2, new java.sql.Date(emprestimo.getDtDevolucao().getTime()));
            stmt.setInt(3, emprestimo.getAmigo().getId());
            stmt.setInt(4, emprestimo.getFerramenta().getId());

            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException(erro);
        }
    }
}
