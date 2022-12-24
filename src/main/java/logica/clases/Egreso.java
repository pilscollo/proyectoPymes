package logica.clases;

import java.time.LocalDate;
import java.util.Objects;

public class Egreso extends Movimiento{
    private float monto;//se saca con el precio del producto y la cantidad

    public Egreso(int id,LocalDate fecha, String detalle, Float monto ) {
        super(id,fecha,detalle,2);
        this.monto = monto;
    }
    public Egreso(int id,LocalDate fecha, String detalle, Float monto,boolean estado) {
        super(id,fecha,detalle,estado,2);
        this.monto = monto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return super.toString() +"Egreso{" +
                "monto=" + monto +
                '}';
    }


}
