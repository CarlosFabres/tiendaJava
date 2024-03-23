package com.example.tienda;

public class Direccion {

    //Atributos
    private String region;
    private String ciudad;
    private String calle;
    private Integer numero;


    public Direccion(String region, String ciudad, String calle, Integer numero){
        
        this.region = region;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
    }



    // Métodos Getters para acceder a los atributos de la clase
    public String getRegion(){
        return region;
    }

    public String getCiudad(){
        return ciudad;
    }

    public String getCalle(){
        return calle;
    }


    public Integer getNumero(){
        return numero;
    }

}
