package modelo;

import java.util.Date;

public class Emprestimo extends ModeloBase {
    
    /*
     * Atributos
     */
    
    private int id;
    private Date dtEmprestimo;
    private Date dtDevolucao;
    private Amigo amigo;
    private Ferramenta ferramenta;

    /*
     * Construtores
     */
    
    public Emprestimo() {
        this(0, null, null, null, null);
    }

      public Emprestimo(int id, Date dtEmprestimo, Date dtDevolucao, Amigo amigo, Ferramenta ferramenta) {
        this.id = id;
        this.dtEmprestimo = dtEmprestimo;
        this.dtDevolucao = dtDevolucao;
        this.amigo = amigo;
        this.ferramenta = ferramenta;
    }
    
    
    /*
     * Getters e Setters
     */
    public Date getDtEmprestimo() {
        return dtEmprestimo;
    }

    public void setDtEmprestimo(Date dtEmprestimo) {
        this.dtEmprestimo = dtEmprestimo;
    }

    public Date getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(Date dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }
    
    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }
}