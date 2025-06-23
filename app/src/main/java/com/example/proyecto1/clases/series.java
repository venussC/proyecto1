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

    // Constructor vacío
    public series() {
    }

    // Constructor original
    public series(String foto, String titulo, String user, int contador, String trailerUrl) {
        this.foto = foto;
        this.titulo = titulo;
        this.user = user;
        this.contador = contador;
        this.trailerUrl = trailerUrl;
    }

    // Constructor separado para sinopsis y información adicional
    public series(String foto, String titulo, String user, int contador, String trailerUrl,
                  String infoPrincipal, String reparto, String sinopsis) {
        this.foto = foto;
        this.titulo = titulo;
        this.user = user;
        this.contador = contador;
        this.trailerUrl = trailerUrl;
        this.infoPrincipal = infoPrincipal;
        this.reparto = reparto;
        this.sinopsis = sinopsis;
    }

    // Getters y Setters originales
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

    // Getters y Setters para los nuevos parámetros
    public String getInfoPrincipal() { return infoPrincipal; }
    public void setInfoPrincipal(String infoPrincipal) { this.infoPrincipal = infoPrincipal; }

    public String getReparto() { return reparto; }
    public void setReparto(String reparto) { this.reparto = reparto; }

    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    // Método original
    public void incrementar() {
        this.contador = this.contador + 1;
    }
}