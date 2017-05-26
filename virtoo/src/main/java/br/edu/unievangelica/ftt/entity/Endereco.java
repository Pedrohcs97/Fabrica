package br.edu.unievangelica.ftt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "endereco")

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @NotEmpty
    @Size(min = 3, max = 60)
    @Column(name = "provincia", nullable = false, length = 60)
    private String provincia;

    @NotEmpty
    @Size(min = 5, max = 60)
    @Column(name = "logradouro", nullable = false, length = 60)
    private String logradouro;

    @NotEmpty
    @Size(min = 3, max = 50)
    @Column(name = "bairro", nullable = false, length = 50)
    private String bairro;

    @NotEmpty
    @Size(max = 10)
    @Column(name = "numero", nullable = false, length = 10)
    private String numero;

    @NotEmpty
    @Size(min = 3, max = 60)
    @Column(name = "municipio", nullable = false, length = 60)
    private String municipio;

    @NotEmpty
    @Size(min = 3, max = 10)
    @Column(name = "caixa_postal", nullable = false, length = 10)
    private String caixaPostal;

    @NotNull
    @OneToOne
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    private Pais pais;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "endereco")
    private Mantenedora mantenedora;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "endereco")
    private Instituicao instituicao;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "endereco")
    private Unidade unidade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCaixaPostal() {
        return caixaPostal;
    }

    public void setCaixaPostal(String caixaPostal) {
        this.caixaPostal = caixaPostal;
    }

    public Mantenedora getMantenedora() {
        return mantenedora;
    }

    public void setMantenedora(Mantenedora mantenedora) {
        this.mantenedora = mantenedora;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}
