package com.example.sony.proyecto;

/**
 * Created by SONY on 10/05/2017.
 */

public class Notificacion {

    private int fotoLibro;
    private String nombreLibro;
    private String nombreUsuario;
    private String myLibro;

    public Notificacion(int fotoLibro, String nombreLibro, String nombreUsuario, String myLibro) {
        this.fotoLibro = fotoLibro;
        this.nombreLibro = nombreLibro;
        this.nombreUsuario = nombreUsuario;
        this.myLibro = myLibro;
    }


    public int getFotoLibro() {
        return fotoLibro;
    }

    public void setFotoLibro(int fotoLibro) {
        this.fotoLibro = fotoLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getMyLibro() {
        return myLibro;
    }

    public void setMyLibro(String myLibro) {
        this.myLibro = myLibro;
    }

}
