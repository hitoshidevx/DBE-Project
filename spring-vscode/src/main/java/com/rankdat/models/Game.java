package com.rankdat.models;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value=0, message="O valor do jogo deve ser positivo (maior que 0).")
    private BigDecimal valorJogo;
    @NotNull(message = "A data do jogo não pode estar vazia.")
    private LocalDate dataLancamento;
    @NotBlank(message = "A descrição do jogo não pode estar vazia.")
    @Size(min = 5, max = 255)
    private String descricaoJogo;
    @NotBlank(message = "O nome do jogo não pode estar vazio.")
    @Size(min = 5, max = 50)
    private String nomeJogo;

    protected Game() {}

    public Game(BigDecimal valorJogo, LocalDate dataLancamento, String descricaoJogo, String nomeJogo) {
        this.valorJogo = valorJogo;
        this.dataLancamento = dataLancamento;
        this.descricaoJogo = descricaoJogo;
        this.nomeJogo = nomeJogo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorJogo() {
        return valorJogo;
    }

    public void setValorJogo(BigDecimal valorJogo) {
        this.valorJogo = valorJogo;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDescricaoJogo() {
        return descricaoJogo;
    }

    public void setDescricaoJogo(String descricaoJogo) {
        this.descricaoJogo = descricaoJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    @Override
    public String toString() {
        return "Game [valorJogo=" + valorJogo + ", dataLancamento=" + dataLancamento + ", descricaoJogo=" + descricaoJogo + ", nomeJogo=" + nomeJogo + "]";
    }

}