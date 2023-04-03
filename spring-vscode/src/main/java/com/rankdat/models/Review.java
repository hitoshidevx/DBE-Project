package com.rankdat.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(min=5, max=50)
    private String tituloReview;
    @NotBlank @Size(min=5, max=255)
    private String descricaoReview;

    protected Review() {}

    public Review(Long id, String tituloReview, String descricaoReview) {
        this.id = id;
        this.tituloReview = tituloReview;
        this.descricaoReview = descricaoReview;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloReview() {
        return tituloReview;
    }

    public void setTituloReview(String tituloReview) {
        this.tituloReview = tituloReview;
    }

    public String getDescricaoReview() {
        return descricaoReview;
    }

    public void setDescricaoReview(String descricaoReview) {
        this.descricaoReview = descricaoReview;
    }
    
    @Override
    public String toString() {
        return "Review [tituloReview=" + tituloReview + ", descricaoReview=" + descricaoReview + "]";
    }
}
