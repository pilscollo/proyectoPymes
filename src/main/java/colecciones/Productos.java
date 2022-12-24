package colecciones;

import excepciones.error;

import java.util.*;

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
        Collections.sort(lista);
        ArrayList<Producto> listaActivo= new ArrayList<>();

        for(Producto p : lista)
        {
            if(p.isEstado())
            {
                listaActivo.add(p);
            }
        }
        return listaActivo;
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
    
    public void agregar(Producto producto) throws error
    {
        if(buscar(producto.getName())!= null)
        {
            throw new error("Error al agregar");
        }else
        {

            lista.add(producto);
        }
    }
    
      public void eliminar(String producto) throws error
    {
        if(buscar(producto)== null)
        {
            throw new error("Error al eliminar");
        }else
        {
            
            lista.remove(new Producto(producto));
        }
    }
       public void cambiar(String viejo, Producto nuevo) throws error
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
