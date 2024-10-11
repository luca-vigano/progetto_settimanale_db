package lucavig.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @ManyToOne
    @JoinColumn(name = "utente")
    protected Utente utente;

    @OneToOne
    @JoinColumn(name = "elemento prestato")
    protected Stampa stampa;
    protected Date dataInizioPrestito;
    protected Date dataRestituzionePrevista;
    protected Date dataRestituzioneEffettiva;

    public Prestito(){
    }

    public Prestito(Utente utente, Stampa stampa, Date dataInizioPrestito, Date dataRestituzionePrevista, Date dataRestituzioneEffettiva) {
        this.utente = utente;
        this.stampa = stampa;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Stampa getStampa() {
        return stampa;
    }

    public void setStampa(Stampa stampa) {
        this.stampa = stampa;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(Date dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public Date getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(Date dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public Date getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", stampa=" + stampa +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
