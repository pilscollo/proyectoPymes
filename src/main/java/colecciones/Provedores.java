/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

import excepciones.error;

import logica.clases.Provedoor;
import java.util.ArrayList;

/**
 *
 * @author Win10
 */
public class Provedores{
    private ArrayList <Provedoor> lista;

    public Provedores(ArrayList<Provedoor> lista) {
        this.lista = lista;
    }
    
     public Provedores() {
        this.lista = new ArrayList<Provedoor>();
    }

    public ArrayList<Provedoor> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Provedoor> lista) {
        this.lista = lista;
    }
    public Provedoor buscar(String nombre)
    {
        Provedoor aux = new Provedoor(nombre);
        Provedoor rta = null;
        for(Provedoor p : lista)
        {
            if(p.equals(aux))
            {
                rta= p;
            }
        }
        return rta;
    }
    
    public void agregar(Provedoor provedor) throws error
    {
        if(buscar(provedor.getNombre())!= null)
        {
            throw new error("Error al agregar");
        }else
        {
            lista.add(provedor);
        }
    }
    
      public void eliminar(Provedoor provedor) throws error
    {
        if(buscar(provedor.getNombre())== null)
        {
            throw new error("Error al eliminar");
        }else
        {
            lista.remove(provedor);
        }
    }
       public void cambiar(String nombreViejo, String nombreNuevo) throws error
    {
        Provedoor viejo = new Provedoor(nombreViejo);
        Provedoor nuevo = new Provedoor(nombreNuevo);
        
        try
        {
            eliminar(viejo);
            agregar(nuevo);
            
        }catch(error e)
        {
            throw new error("error cambiando al provedoor");
        }
        
    }
    

    
}
