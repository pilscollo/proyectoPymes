

package mx.com.gm.jdbc.proyectojulita;

import colecciones.Productos;
import excepciones.error;
import igu.Pantalla;
import java.util.ArrayList;
import logica.clases.Producto;
import logica.clases.Provedoor;

public class Proyectojulita {

    public static void main(String[] args) {
        Productos productos = new Productos();
        Producto p1 = new Producto("Cx3",new Provedoor("juan"),0,10, (float) 100.00,10);
        Producto p2 = new Producto("Cx5",new Provedoor("juan"),3,10, (float) 100.00,10);
        Producto p3 = new Producto("Cx4",new Provedoor("juan"),2,10, (float) 100.00,10);
        try{
        productos.agregar(p1);
        productos.agregar(p2);
        productos.agregar(p3);
       
        
        ArrayList<Producto> productos1 = productos.devolverProductosLista();
        for(int i=productos1.size()-1; i>=0;i--)
        {
            System.out.println(productos1.get(i));
        }
        }catch(error e)
        {
            System.out.print(e);
        }
        /*Pantalla panta = new Pantalla();
        panta.setVisible(true);
        panta.setLocationRelativeTo(null);*/
    }
}
