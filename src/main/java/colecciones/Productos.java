package colecciones;

import excepciones.error;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import logica.clases.Producto;


public class Productos {
      private ArrayList <Producto> lista;

    public Productos(ArrayList<Producto> lista) {
        this.lista = lista;
    }
    
     public Productos() {
        this.lista = new ArrayList<Producto>();
    }

    public ArrayList<Producto> getLista() {
        return lista;
    }

    public ArrayList<Producto> listarOrden()
    {
        TreeMap<Integer,Producto> productos = new TreeMap<Float,Producto>();
        for(Producto p: lista)
        {
            productos.put(p.getCantidadVentas(), p);
        }
        Iterator iterator = productos.entrySet().iterator();
        
        ArrayList<Producto> productosEnOrden= new ArrayList<Producto>();
        while(iterator.hasNext())
        {
            Map.Entry<Integer, Producto> entrada = (Entry<Integer, Producto>) iterador.next();
            productosEnOrden.add(entrada.getValue());
        }
        return productosEnOrden;
    }
    public void setLista(ArrayList<Producto> lista) {
        this.lista = lista;
    }
    public Producto buscar(String nombre)
    {
        Producto aux = new Producto(nombre);
        Producto rta = null;
        for(Producto p : lista)
        {
            if(p.equals(aux))
            {
                rta= p;
            }
        }
        return rta;
    }
    
    public void agregar(Producto provedor) throws error
    {
        if(buscar(provedor.getName())!= null)
        {
            throw new error("Error al agregar");
        }else
        {
            
            lista.add(provedor);
        }
    }
    
      public void eliminar(Producto provedor) throws error
    {
        if(buscar(provedor.getName())== null)
        {
            throw new error("Error al eliminar");
        }else
        {
            
            lista.remove(provedor);
        }
    }
       public void cambiar(Producto viejo, Producto nuevo) throws error
    {
        
        
        try
        {
            eliminar(viejo);
            agregar(nuevo);
            
        }catch(error e)
        {
            throw new error("error cambiando al provedoor");
        }
        
    }
       
      public ArrayList<Producto> devolverProductosLista()
      {
          TreeMap<Integer,Producto> lista2 = new TreeMap<Integer,Producto>();
          
          for(Producto p: lista)
          {
             lista2.put(p.getCantidadVentas(), p);
          }
          
          ArrayList<Producto> result = new ArrayList<Producto>();
          
          Iterator it= lista2.entrySet().iterator();
           while(it.hasNext())
           {
            Map.Entry<Integer,Producto> en= (Map.Entry<Integer,Producto>) it.next();
            result.add(en.getValue());
           }
         
        return result;
        
      }
    
}
