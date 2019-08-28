package com.juniorrodrigues.recycleview.model;

public class FilmesModel {

    private String title;
    private String genero;
    private String year;

    public FilmesModel() {//posso instalciar sem passar parametros
    }

    public FilmesModel(String title, String genero, String year) {
        this.title = title;
        this.genero = genero;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
