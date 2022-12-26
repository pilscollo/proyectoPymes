

package mx.com.gm.jdbc.proyectojulita;



//import igu.InicionSesion;
import archivo.Archivo;
import igu.NewJFrame;
import igu.libro;
import igu.producto;
import java.io.File;
import javax.swing.*;

public class Proyectojulita {


    public static void main(String[] args) {


       /* appPP ap = new appPP();
        appMov app = new appMov();

        try {

            ap.agregar("pablo");
            ap.agregar("martin");
            ap.agregar("cx3","martin",10,1,100,10);
            ap.agregar("cx2","pablo",11,1,100,10);
            ap.agregar("cx1","martin",10,1,100,10);


            LocalDate fecha1= LocalDate.now();
            LocalDate fecha2= LocalDate.of(2002,12,10);
            LocalDate fecha3= LocalDate.of(2002,12,9);
            app.entrada(fecha1,1,"venta de producto cx3",ap.buscar("cx3"));
            app.entrada(fecha1,1,"venta de producto cx3",ap.buscar("cx3"));
            app.entrada(fecha2,3,"venta de producto cx3",ap.buscar("cx2"));
            app.entrada(fecha3,4,"venta de producto cx3",ap.buscar("cx2"));
            app.salida(fecha3,"venta de producto cx3",100);
            app.eliminar(1);
            System.out.println(app.monto());
            ArrayList<Movimiento> libro= app.listar();
            for (Movimiento m : libro)
            {
                System.out.println(m);

            }

            ArrayList<Producto> products = ap.productosMasVendidos();
            for(Producto p: products)
            {
                System.out.println(p);

            }
             json j= new json();
            JSONArray jsonArray = j.MovimientosarrayList(app.listar());
            System.out.println(jsonArray);
            ArrayList<Movimiento> movimientos= j.arrayListMovimientos(jsonArray);
            for(Movimiento movimiento: movimientos)
            {

                System.out.println(movimiento);
            }


        } catch (error e) {
            System.out.println(e.getMessage());;
        }*/

       
       Archivo.crearArchivo("caja.bin");
       Archivo.crearArchivo("libro.bin");
       Archivo.crearArchivo("producto.bin");
       Archivo.crearArchivo("provedor.bin");
       try
       {
        NewJFrame panta = new NewJFrame();
        panta.setVisible(true);
        panta.setLocationRelativeTo(null);
        
       }catch(Exception ex)
       {
           System.out.print(ex);
       }
       
       
       /*
       try
       {
        producto panta = new producto();
        panta.setVisible(true);
        panta.setLocationRelativeTo(null);
        
       }catch(Exception ex)
       {
           System.out.print(ex);
       }*/
       

    }
    
}
