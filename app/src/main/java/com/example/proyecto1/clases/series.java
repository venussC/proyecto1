package com.example.proyecto1.clases;

public class series {
    private String foto;
    private String titulo;
    private String user;
    private int contador;
    private String trailerUrl;

    private String infoPrincipal;
    private String reparto;
    private String sinopsis;
    private String mensaje;

    public series() {
    }

    public series(String foto, String titulo, String user, int contador, String trailerUrl) {
        this.foto = foto;
        this.titulo = titulo;
        this.user = user;
        this.contador = contador;
        this.trailerUrl = trailerUrl;

    }


    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public int getContador() { return contador; }
    public void setContador(int contador) { this.contador = contador; }

    public String getTrailerUrl() { return trailerUrl; }
    public void setTrailerUrl(String trailerUrl) { this.trailerUrl = trailerUrl; }


    public void incrementar() {
        this.contador = this.contador + 1;
    }
}