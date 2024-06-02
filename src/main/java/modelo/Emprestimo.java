package modelo;

import dao.EmprestimoDAO;
import java.util.Date;

public class Emprestimo extends ModeloBase {
    
    // Atributos
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Amigo amigo;
    private Ferramenta ferramenta;
    private EmprestimoDAO dao;

    // Construtores
    public Emprestimo() {
        this(0, null, null, null, null);
    }

    public Emprestimo(int id, Date dataEmprestimo, Date dataDevolucao, Amigo amigo, Ferramenta ferramenta) {
        super(id, "");
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.amigo = amigo;
        this.ferramenta = ferramenta;
    }
    
    
    // Getters e Setters
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
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