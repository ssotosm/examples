package com.tienda;

public class Producto {

    public String nombre;
    
    public int caducidad;

    public int valor;

    public Producto(String nombre, int caducidad, int valor) {
        this.nombre = nombre;
        this.caducidad = caducidad;
        this.valor = valor;
    }

   @Override
   public String toString() {
        return this.nombre + ", " + this.caducidad + ", " + this.valor;
    }
}
