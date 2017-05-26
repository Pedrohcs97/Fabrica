package br.edu.unievangelica.ftt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @NotEmpty
    @Size(min = 3, max = 80)
    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @NotEmpty
    @Size(min = 3, max = 80)
    @Column(name = "nome_responsavel", nullable = false, length = 80)
    private String nome_responsavel;

    @NotEmpty
    @Column(name = "sexo", nullable = false)
    private String sexo;

    @NotEmpty
    @Size(min = 2, max = 2)
    @Column(name = "idade", nullable = false, length = 2)
    private String idade;

    @Valid
    @NotNull
    @JoinColumn(name = "unidade_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Unidade unidade;

    @Valid
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Endereco endereco;

    @NotNull
    @Valid
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Curso curso;

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

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
