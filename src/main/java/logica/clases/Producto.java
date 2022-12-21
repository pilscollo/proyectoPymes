
package logica.clases;

import java.util.Objects;


public class Producto {
    /*
    cosas que necesita el producto: 
    *nombre
    *provedoor c0
    *cantidad de ventas
    *cantidad total
    *costo
    *porcentaje de ganancia*/

    private String name;
    private Provedoor provedor;
    private int cantidadVentas;
    private int cantidadStok;
    private float costo;
    private float porcentaje;
    private float precioActual;

    public Producto(String name, Provedoor provedor, int cantidadVentas, int cantidadStok, float costo, float porcentaje) {
        
        this.name = name;
        this.provedor = provedor;
        this.cantidadVentas = cantidadVentas;
        this.cantidadStok = cantidadStok;
        this.costo = costo;
        this.porcentaje = porcentaje;
        this.precioActual = actualizarPrecio();
    }

        public Producto(String name) {
        
        this.name = name;
      
    }

    public String getName() {
        return name;
    }

    public Provedoor getProvedor() {
        return provedor;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public int getCantidadStok() {
        return cantidadStok;
    }

    public float getCosto() {
        return costo;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public float getPrecioActual() {
        return precioActual;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProvedor(Provedoor provedor) {
        this.provedor = provedor;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public void setCantidadStok(int cantidadStok) {
        this.cantidadStok = cantidadStok;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }
    private void setPrecioActual(float precio)
    {
        this.precioActual = precio;
    }
    public float actualizarPrecio()
    {
        float p = costo * (porcentaje/100);
        float precio= p+ costo;
        setPrecioActual(precio);
        return precio;
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
       if(obj instanceof Producto)
       {
           
               Producto aux = (Producto) obj;
               if(aux.getName().equals(name))
               {
                   rta= true;
               }
           }
       }
       return rta;
    }

    @Override
    public String toString() {
        return "Producto{" + "name=" + name + ", provedor=" + provedor + ", cantidadVentas=" + cantidadVentas + ", cantidadStok=" + cantidadStok + ", costo=" + costo + ", porcentaje=" + porcentaje + ", precioActual=" + precioActual + '}';
    }

    
    
}
