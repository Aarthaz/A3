package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Ferramenta;

//simulando a persistencia de dados
public class FerramentaDAO {

    public ArrayList<Ferramenta> minhaLista = new ArrayList<>();

    public ArrayList<Ferramenta> getMinhaLista() {
        minhaLista.clear();

        try {
            Statement stmt = this.getConexao().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double custo = res.getDouble("custo");

                Ferramenta objeto = new Ferramenta(id, nome, marca, custo);
                minhaLista.add(objeto);
            }

            stmt.close();
        } catch (SQLException ex) {
        }
        return minhaLista;
    }

    //public void setMinhaLista(ArrayList<Ferramenta> MinhaLista) {
    //}
    //cadastra uma ferramenta
    public boolean insertFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO tb_ferramentas(id,nome,marca,custo) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getCusto());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    //Carrega um aluno pelo ID
    public Ferramenta carregaAluno(int id) {

        Ferramenta objeto = new Ferramenta();
        objeto.setId(id);
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas WHERE id = " + id);

            res.next();
            objeto.setNome(res.getString("nome"));
            objeto.setMarca(res.getString("idade"));
            objeto.setCusto(res.getDouble("curso"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }

    //altera uma ferramenta
    public boolean updateFerramentaBD(Ferramenta objeto) {
        String sql = "UPDATE tb_ferramentas set nome = ? , marca = ? , custo = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setDouble(3, objeto.getCusto());
            stmt.setInt(4, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    //deleta uma ferramenta
    public boolean deleteFerramentaBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();

            stmt.executeUpdate("DELETE FROM tb_ferramentas WHERE id =" + id);

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("erro: " + erro);
        }
        return true;
    }

    public int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_ferramentas");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("erro: " + ex);
        }

        return maiorID;
    }

    public Connection getConexao() {
        Connection connection = null; //instância da conexão
        try {

            //carregamento do jdbc driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            //configurando a conexão
            String server = "localhost";
            String database = "db_ferramentas";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "1234";

            //conectando
            connection = DriverManager.getConnection(url, user, password);

            //testando
            if (connection != null) {
                System.out.println("connectado");
            } else {
                System.out.println("nao conectado");
            }

            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("driver nao foi encontrado");
            return null;

        } catch (SQLException e) {
            System.out.println("nao foi possivel connectar");
            return null;
        }
    }
}
