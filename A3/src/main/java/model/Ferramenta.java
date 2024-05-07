package model;

import java.util.ArrayList;
import dao.FerramentaDAO;

public class Ferramenta extends Base {
    
    //atributos
    private String marca;
    private double custo;

    //construtor de objeto sem parametros
    public Ferramenta() {
        this(0, "", "", 0);
    }

    //construtor com parametros
    public Ferramenta(int id, String nome, String marca, double custo) {
        super(id, nome);
        this.marca = marca;
        this.custo = custo;
    }

    //getters e setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    @Override
    public String toString() {
        return super.toString() + "marca=" + marca + ", custo=" + custo;
    }
    
    //abaixo os metodos para uso junto com o dao simulando a estrutura de camadas do banco de dados
    
    //retorna a lista de ferramentas
    public ArrayList<Ferramenta> getMinhaLista(){
        return FerramentaDAO.getMinhaLista();
    }
    
    //cadastra nova ferramenta
    public boolean insertFerramentaBD(String nome, String marca, double custo){
        int id = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo);
        FerramentaDAO.minhaLista.add(objeto);
        return true;
    }
    
    //deleta uma ferramenta especifica pelo id
    public boolean deleteFerramentaBD(int id){
        int indice = this.procuraIndice(id);
        FerramentaDAO.minhaLista.remove(indice);
        return true;
    }
    
    //edita uma ferramenta especifica pelo id
    public boolean updateFerramentaBD(int id, String nome, String marca, double custo){
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo);
        int indice = this.procuraIndice(id);
        FerramentaDAO.minhaLista.set(indice, objeto);
        return true;
    }
    
    //procura o indice de objeto da minhaLista que tem o id enviado
    private int procuraIndice(int id){
        int indice = -1;
        for(int i = 0; i < FerramentaDAO.minhaLista.size(); i++){
            if(FerramentaDAO.minhaLista.get(i).getId() == id){
                indice = i;
            }
        }
        return indice;
    }
    
    //carrega dados de uma ferramenta especifica pelo id
    public Ferramenta carregaFerramenta(int id){
        int indice = this.procuraIndice(id);
        return FerramentaDAO.minhaLista.get(indice);
    }
    
    //retorna o maior id do BD
    public int maiorID(){
        return FerramentaDAO.maiorID();
    }
}
