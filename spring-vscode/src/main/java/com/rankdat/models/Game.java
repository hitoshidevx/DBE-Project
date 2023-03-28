package com.rankdat.models;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Game {

    private Long id;
    private BigDecimal valorJogo;
    private LocalDate dataLancamento;
    private String descricaoJogo;
    private String nomeJogo;

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