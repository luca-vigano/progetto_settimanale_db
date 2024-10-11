package lucavig.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


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
    protected LocalDate dataInizioPrestito;
    protected LocalDate dataRestituzionePrevista;
    protected LocalDate dataRestituzioneEffettiva;

    public Prestito(){
    }

    public Prestito(Utente utente, Stampa stampa, LocalDate dataInizioPrestito, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.stampa = stampa;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
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

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
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
