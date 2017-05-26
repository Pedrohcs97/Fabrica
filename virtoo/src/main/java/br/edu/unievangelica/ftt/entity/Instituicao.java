package br.edu.unievangelica.ftt.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "instituicao")
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @NotEmpty
    @Size(min = 2, max = 80)
    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @NotEmpty
    @Column(name = "numero_fiscal", nullable = false, length = 10)
    private String numeroFiscal;

    @Valid
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Endereco endereco;

    @Valid
    @NotNull
    @JoinColumn(name = "mantenedora_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Mantenedora mantenedora;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "instituicao")
    private List<Unidade> unidades;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroFiscal() {
        return numeroFiscal;
    }

    public void setNumeroFiscal(String numeroFiscal) {
        this.numeroFiscal = numeroFiscal;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Mantenedora getMantenedora() {
        return mantenedora;
    }

    public void setMantenedora(Mantenedora mantenedora) {
        this.mantenedora = mantenedora;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }

}
