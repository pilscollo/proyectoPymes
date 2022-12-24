package logica.clases;

import java.time.LocalDate;

public class Ingreso extends Movimiento {
    private Producto producto;
    private int cantidad;
    private float monto;//se saca con el precio del producto y la cantidad

    public Ingreso(int id,LocalDate fecha,int cantidad, String detalle, Producto producto) {
        super(id,fecha,detalle,1);

        this.cantidad=cantidad;
        this.producto = producto;
        this.monto = producto.getPrecioActual()* cantidad;
    }
    public Ingreso(int id,LocalDate fecha,int cantidad, String detalle, Producto producto,boolean estado) {
        super(id,fecha,detalle,estado,1);

        this.cantidad=cantidad;
        this.producto = producto;
        this.monto = producto.getPrecioActual()* cantidad;
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

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return super.toString() +"Ingreso{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                ", monto=" + monto +
                '}';
    }
}
