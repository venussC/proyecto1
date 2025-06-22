package com.example.proyecto1.clases;

public class series {
    private String foto;
    private String titulo;
    private String user;
    private int contador;

    public series() {
    }

    public series(String foto, String titulo, String user, int contador) {
        this.foto = foto;
        this.titulo = titulo;
        this.user = user;
        this.contador = contador;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void incrementar(){
        this.contador=this.contador+1;

    }
}
