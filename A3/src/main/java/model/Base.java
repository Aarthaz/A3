
package model;


public class Base {
    //atributos
    private int id;
    private String nome;
    
    //construtor de objeto sem parametros
    public Base(){
        this(0,"");
    }
    
    //construtor de objeto com parametros
    public Base(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    //gets e sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return "id= " + id + ", nome= " + nome;
    }
}
