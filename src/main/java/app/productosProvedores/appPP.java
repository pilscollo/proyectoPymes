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

/**
 *
 * @author Win10
 */
public class appPP {
    
    private Provedores provedores;
    private Productos productos;
    
     /*
       listar
       agregar productos
       agregar provedores
       eliminar producto 
       eliminar provedor
       modificar producto 
       eliminar provedor
    */

    public appPP(Provedores provedores, Productos productos) {
        this.provedores = provedores;
        this.productos = productos;
    }

    public ArrayList listarProvedores()
    {
        return provedores.getLista();
    }
    
    public ArrayList listarProductos()
    {
        return provedores.getLista();
    }
    public ArrayList productosMasVendidos()
    {
        return productos.devolverProductosLista();
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
    
}
