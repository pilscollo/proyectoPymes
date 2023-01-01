package logica.clases;

import java.time.LocalDate;
import java.util.Objects;

public class Movimiento implements Comparable<Movimiento> {
    private LocalDate fecha;
    private int id;


    private String detalle;
    private boolean estado;
    private int tipo;
    private float monto;
    public Movimiento(int id,LocalDate fecha, String detalle,int tipo,float cant) {
        this.fecha = fecha;
        this.id=id;
        this.detalle = detalle;
        this.estado= true;
        this.tipo=tipo;
        this.monto= cant;

    }
     public Movimiento() {
       

    }
    public Movimiento(int id,LocalDate fecha, String detalle,boolean estado,int tipo,float cant) {
        this.fecha = fecha;
        this.id=id;
        this.detalle = detalle;
        this.estado= estado;
        this.tipo=tipo;
        this.monto= cant;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Movimiento o) {
        if(o.getFecha().compareTo(fecha)>-1)
        {
            return -1;
        }
        else if(o.getFecha().compareTo(fecha)>0)
        {
            return 0;
        }else
        {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "fecha=" + fecha +
                ", detalle='" + detalle + '\'' +
                ", estado=" + estado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimiento that = (Movimiento) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
