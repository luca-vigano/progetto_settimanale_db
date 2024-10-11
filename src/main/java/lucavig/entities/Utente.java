package lucavig.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "utente")
public class Utente {
    private String nome;
    private String cognome;
    private Date dataDiNascita;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numeroDiTessera;


    public Utente(){
    }

    public Utente(String nome, String cognome, Date dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public long getNumeroDiTessera() {
        return numeroDiTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", numeroDiTessera=" + numeroDiTessera +
                '}';
    }
}
