/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.productosProvedores;

import colecciones.Productos;
import colecciones.Provedores;
import excepciones.error;
import java.util.ArrayList;
import logica.clases.Producto;
import logica.clases.Provedoor;

/**
 *
 * @author Win10
 */
public class appPP {
    
    private Provedores provedores;
    private Productos productos;

    public appPP(Provedores provedores, Productos productos) {
        this.provedores = provedores;
        this.productos = productos;
    }
    public appPP() {
        this.provedores = new Provedores();
        this.productos = new Productos();
    }

    public ArrayList listarProvedores()
    {
        return provedores.getLista();
    }
    
    public ArrayList listarProductos()
    {
        return productos.getLista();
    }
    public ArrayList productosMasVendidos()
    {
        return productos.listarOrden();
    }
    
    
    public void agregar(String name,String nombreProvedor,int cantidadVentas,int cantidadStok,float costo,float porcentaje) throws error
    {

        Provedoor provedor = provedores.buscar(nombreProvedor);

        if (provedor== null)
        {
            throw new error("error con el provedor");
        }
        productos.agregar(new Producto(name,provedor,cantidadVentas,cantidadStok,costo,porcentaje));
        
    }
    public void agregar(String nombreProvedor) throws error
    {

        Provedoor provedor = provedores.buscar(nombreProvedor);
        if (provedor!= null)
        {
            throw new error("error con el provedor");
        }
        provedores.agregar(nombreProvedor);

    }
    public void venta(String nombre,int cant) throws error
    {

        Producto pro= buscar(nombre);
        if(pro!=null && pro.isEstado() && pro.getCantidadStok()-cant>=0)
        {
            pro.setCantidadVentas(pro.getCantidadVentas()+cant);
            pro.setCantidadStok(pro.getCantidadStok()-cant);
            eliminar(nombre);
            agregar(pro.getName(),pro.getProvedor().getNombre(),pro.getCantidadVentas(),pro.getCantidadStok(),pro.getCosto(),pro.getPorcentaje());
        }else
        {throw  new error("error en la venta");}
    }
    public void modificar(String nombreViejo,String name,String nombreProvedor,int cantidadVentas,int cantidadStok,float costo,float porcentaje) throws  error
    {
        if(productos.buscar(name)==null) {
            productos.cambiar(nombreViejo, new Producto(name, provedores.buscar(nombreProvedor), cantidadVentas, cantidadStok, costo, porcentaje));
        }else
        {
            throw new error("error al modificar");
        }
        }

    public void modificar(String nombreViejo,String nombreNuevo) throws  error
    {
        if(provedores.buscar(nombreNuevo)==null) {
            provedores.cambiar(nombreViejo, nombreNuevo);
            Provedoor prov= provedores.buscar(nombreNuevo);
            for(Producto p: productos.getLista())
            {
                if(p.getProvedor().getNombre().equals(nombreViejo)) {
                    p.setProvedor(prov);
                }
                }
        }
        else
            {
                throw new error("error al modificar");
            }
    }
    public void eliminar(String nombre) throws  error
    {
        productos.eliminar(nombre);
    }
    public  void eliminarProve(String nombre) throws error
    {
        provedores.eliminar(nombre);
    }
    public Producto buscar(String nombre) throws error
    {
        return productos.buscar(nombre);
    }
    public Provedoor buscarProve(String nombre) throws error
    {
        return provedores.buscar(nombre);
    }

}
