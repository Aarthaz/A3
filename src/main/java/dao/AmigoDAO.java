package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Amigo;

public class AmigoDAO {

    public ArrayList<Amigo> minhaLista = new ArrayList<>();

    public ArrayList<Amigo> getMinhaLista() {

        /**
         * limpa a lista para adicionar novos amigos
         */
        minhaLista.clear();

        try {
            Statement stmt = this.getConexao().createStatement();

            //Faz uma consulta para selecionar todos os registros da tabela tb_amigo
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigo");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String telefone = res.getString("telefone");

                Amigo objeto = new Amigo(id, nome, telefone);
                minhaLista.add(objeto);
            }

            stmt.close();
        } catch (SQLException ex) {
        }
        return minhaLista;
    }

    /**
     * Método para inserir um novo amigo no banco de dados
     */
    public boolean insertAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO tb_amigo(id,nome,telefone) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            //Define os valores dos parâmetros na instrução SQL
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {

            /*
            Se ocorrer um erro ele mostra
             */
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Método para excluir um amigo do banco de dados com base no ID
     */
    public boolean deleteAmigoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();

            //Executa uma instrução SQL para excluir o amigo com o ID fornecido
            stmt.executeUpdate("DELETE FROM tb_amigo WHERE id =" + id);

            stmt.close();
        } catch (SQLException erro) {

            //Se ocorrer um erro ele mostra
            System.out.println("erro: " + erro);
        }
        return true;
    }

    /**
     * Método para atualizar as informações de um amigo no banco de dados
     */
    public boolean updateAmigoBD(Amigo objeto) {
        String sql = "UPDATE tb_amigo set nome = ? , telefone = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            //Define os valores dos parâmetros na instrução SQL
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTelefone());
            stmt.setInt(3, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {

            //Se ocorrer um erro ele mostra
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Método para obter o maior ID presente na tabela tb_amigo
     */
    public int maiorID() {
        int maiorID = 0;
        try {

            //Executa uma consulta para obter o maior ID presente na tabela
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_amigo");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {

            // Se ocorrer um erro ele mostra
            System.out.println("erro: " + ex);
        }

        return maiorID;
    }

    /**
     * Método para obter uma conexão com o banco de dados
     */
    public Connection getConexao() {
        Connection connection = null;
        try {

            /**
             * Carrega o driver JDBC para o MySQL
             */
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";
            String database = "db_ferramentas";
            String url = "jdbc:mysql://" + server + ":3306/"
                    + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "1234";

            // Estabelece a conexão com o banco de dados
            connection = DriverManager.getConnection(url, user, password);

            // Verifica se a conexão foi bem-sucedida
            if (connection != null) {
                System.out.println("connectado");
            } else {
                System.out.println("nao conectado");
            }

            return connection;

        } catch (ClassNotFoundException e) {

            // Se o driver não for encontrado, imprime um erro
            System.out.println("driver nao foi encontrado");
            return null;

        } catch (SQLException e) {

            // Se não for possível conectar, imprime um erro
            System.out.println("nao foi possivel connectar");
            return null;
        }
    }

}
