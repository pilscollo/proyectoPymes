package colecciones;

import logica.clases.Egreso;
import logica.clases.Ingreso;
import logica.clases.Movimiento;

import java.util.ArrayList;
import java.util.Collections;

public class Libro{
    private ArrayList<Movimiento> movimientos;

    public Libro(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    public Libro()
    {
        this.movimientos = new ArrayList<Movimiento>();
    }

    /*
    agregar venta
    agregar egreso
    eliminar venta
    eliminar egreso
     */

    public int cantidad()
    {
        return movimientos.size();
    }
    public  void agregar(Ingreso venta)
    {
        movimientos.add(venta);
    }
    public void  agregar(Egreso egreso)
    {
        movimientos.add(egreso);
    }
    public void eliminar(int id)
    {

        Movimiento m= buscar(id);
        if(m!=null) {
            movimientos.remove(m);
        }
    }
    public Movimiento buscar(int id)
    {
        Movimiento rta= null;
        for(Movimiento m : movimientos)
        {
            if(m.getId()==id)
            {
                rta= m;
            }
        }
        return rta;
    }
    public  void eliminar(Egreso egreso)
    {
        movimientos.remove(egreso);
    }

    public ArrayList<Movimiento> movimientosLibro()
    {
        Collections.sort(movimientos);
        ArrayList<Movimiento> movimientosActivos = new ArrayList<Movimiento>();
        for (Movimiento m : movimientos)
        {
            if(m.isEstado())
            {
                movimientosActivos.add(m);
            }
        }

        return movimientosActivos;
    }

}
