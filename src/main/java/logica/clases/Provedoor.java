/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.clases;

/**
 *
 * @author Win10
 */
public class  Provedoor {
    private String nombre;

    public Provedoor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean rta= false;
        if(obj!=null)
           {
       if(obj instanceof Provedoor)
       {
           
               Provedoor aux = (Provedoor) obj;
               if(aux.getNombre().equals(nombre))
               {
                   rta= true;
               }
           }
       }
       return rta;
    }

    @Override
    public String toString() {
        return "Provedoor{" + "nombre=" + nombre + '}';
    }
    
    
    
}
