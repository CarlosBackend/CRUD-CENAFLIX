package AcessoDB;
import java.sql.Date;

public class Filmes {
    private String nome;
    private Date datalancamento;
    private String categoria;

    public Filmes(String nome, Date datalancamento, String categoria) {
        this.nome = nome;
        this.datalancamento = datalancamento;
        this.categoria = categoria;
    }
    
    public  Filmes(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
