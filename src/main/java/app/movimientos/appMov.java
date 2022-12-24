package app.movimientos;

import colecciones.Libro;
import logica.clases.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class appMov {

    private Caja caja;
    private Libro libro;

    public appMov(Caja caja, Libro libro) {
        this.caja = caja;
        this.libro = libro;
    }
    public appMov() {
        this.caja = new Caja(0);
        this.libro = new Libro();
    }
    /*
    *agregar entrada
    * agregar salida
    * mostrar caja
    * mostrar libro por fecha
     */
    public ArrayList<Movimiento> listar()
    {
       return libro.movimientosLibro();
    }
    public float monto()
    {
        return caja.getMonto();
    }

    public void entrada(LocalDate fecha, int cantidad, String detalle, Producto producto)
    {
        Ingreso entrada = new Ingreso(libro.cantidad(),fecha,cantidad,detalle,producto);
        libro.agregar(entrada);
        caja.setMonto(caja.getMonto()+entrada.getMonto());
    }
    public void salida(LocalDate fecha, String detalle,float monto)
    {
        Egreso entrada = new Egreso(libro.cantidad(),fecha,detalle,monto);
        libro.agregar(entrada);
        caja.setMonto(caja.getMonto()-entrada.getMonto());
    }

    public void eliminar(int id)
    {
        Movimiento m= libro.buscar(id);
        if(m instanceof Egreso)
        {
            caja.setMonto(caja.getMonto()+((Egreso) m).getMonto());
        }else if(m instanceof Ingreso)
        {
            caja.setMonto(caja.getMonto()-((Ingreso) m).getMonto());
        }
        libro.eliminar(id);

    }
    public  Movimiento buscar(int id)
    {
        return libro.buscar(id);
    }


}
