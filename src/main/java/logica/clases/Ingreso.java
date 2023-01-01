package logica.clases;

import java.time.LocalDate;

public class Ingreso extends Movimiento {
    private Producto producto;
    private int cantidad;


    public Ingreso(int id,LocalDate fecha,int cantidad, Producto producto) {

        super(id,fecha,"se vendio "+String.valueOf(cantidad)+" de "+ producto.getName(),true,1,producto.getPrecioActual()* cantidad);
        this.cantidad=cantidad;
        this.producto = producto;
    }
    public Ingreso(int id,LocalDate fecha,int cantidad, String detalle, Producto producto,boolean estado) {
        super(id,fecha,detalle,estado,1,producto.getPrecioActual()* cantidad);

        this.cantidad=cantidad;
        this.producto = producto;

    }

    public Ingreso() {
        super(1,LocalDate.now(),"",true,1,0);
         this.cantidad=0;
        this.producto = new Producto();

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }



    @Override
    public String toString() {
        return super.toString() +"Ingreso{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                ", monto=" +
                '}';
    }
}
