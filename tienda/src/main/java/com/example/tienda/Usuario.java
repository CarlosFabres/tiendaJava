package com.example.tienda;

import java.util.List;



public class Usuario {

    //Atributos
    private Integer id;
    private String nombre;
    private String correo;
    private String rol;
    private List<Direccion> direcciones;



    public Usuario(int id, String nombre, String correo, String rol, List<Direccion> direcciones){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.direcciones = direcciones;
    }



    // Métodos Getters para acceder a los atributos de la clase
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRol(){
        return rol;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }


}
