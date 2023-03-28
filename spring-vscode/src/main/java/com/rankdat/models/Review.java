package com.rankdat.models;

public class Review {

    private Long id;
    private String tituloReview;
    private String descricaoReview;

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
