package json;

import logica.clases.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;

public  class json {

    /*
    * json-provedor>
    * provedor-json>
    * producto-json>
    * json-producto>
    *  egreso- json
    * json- egreso
    * ingreso- json
    * json- ingreso
    * caja-json
    * json-caja
     */
    public JSONArray cajaAJson(Caja caja)
    {
        JSONArray jsonCaja = new JSONArray();
        try {
            jsonCaja.put(caja.getMonto());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonCaja;
    }

    public Caja jsonACaja(JSONArray caja)
    {
        Caja cajaofi=new Caja(0);
        try {
            
            int num= caja.length();
            if(num!=0)
            {
                System.out.println(num);
            cajaofi= new Caja((float)caja.getDouble(num-1));
            }else
            {
                cajaofi= new Caja(0);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cajaofi;
    }

    public JSONObject provedorAJson(Provedoor provedor)
    {
        JSONObject jsonProvedor = new JSONObject();
        try {
            jsonProvedor.put("nombre",provedor.getNombre());
            jsonProvedor.put("estado",provedor.isEstado());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonProvedor;
    }

    public Provedoor jsonAProvedor(JSONObject jsonP)
    {
        Provedoor provedoor=null;
        try {
            provedoor = new Provedoor(jsonP.getString("nombre"),jsonP.getBoolean("estado"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  provedoor;
    }

    public JSONObject productoAjson(Producto producto)
    {

        JSONObject jsonProducto = new JSONObject();

        try {
            jsonProducto.put("name",producto.getName());
            jsonProducto.put("provedor",provedorAJson(producto.getProvedor()));
            jsonProducto.put("ventas",producto.getCantidadVentas());
            jsonProducto.put("stok",producto.getCantidadStok());
            jsonProducto.put("porcentaje",producto.getPorcentaje());
            jsonProducto.put("costo",producto.getCosto());
            jsonProducto.put("estado",producto.isEstado());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return  jsonProducto;
    }

    public Producto jsonAproducto(JSONObject jsonProduct)
    {
        Producto producto=null;
        try {
            producto= new Producto(jsonProduct.getString("name"),jsonAProvedor(jsonProduct.getJSONObject("provedor")),jsonProduct.getInt("ventas"),jsonProduct.getInt("stok"),(float) jsonProduct.getDouble("costo"),(float)jsonProduct.getDouble("porcentaje"),jsonProduct.getBoolean("estado"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return producto;
    }
/*
    private LocalDate fecha;
    private int id;
    private String detalle;
    private boolean estado;
     private Producto producto;
    private int cantidad;
    private float monto;//se saca con el precio del producto y la cantidad
 */
    public JSONObject ingresoAjson(Ingreso ingreso)
    {
        JSONObject json= new JSONObject();
        try {
            json.put("id",ingreso.getId());
            json.put("ano",ingreso.getFecha().getYear());
            json.put("mes",ingreso.getFecha().getMonthValue());
            json.put("dia",ingreso.getFecha().getDayOfMonth());
            json.put("cantidad",ingreso.getCantidad());
            json.put("detalle",ingreso.getDetalle());
            json.put("producto",productoAjson(ingreso.getProducto()));
            json.put("estado",ingreso.isEstado());
            json.put("tipo",ingreso.getTipo());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return  json;
    }
    public JSONObject egresoAjson(Egreso ingreso)
    {
        JSONObject json= new JSONObject();
        try {
            json.put("id",ingreso.getId());
            json.put("ano",ingreso.getFecha().getYear());
            json.put("mes",ingreso.getFecha().getMonthValue());
            json.put("dia",ingreso.getFecha().getDayOfMonth());
            json.put("detalle",ingreso.getDetalle());
            json.put("monto",ingreso.getMonto());
            json.put("estado",ingreso.isEstado());
            json.put("tipo",ingreso.getTipo());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return  json;
    }

    public Ingreso jsonAIngreso(JSONObject jsonIngreso)
    {
        Ingreso ingreso = new Ingreso();
        try {
            ingreso = new Ingreso(jsonIngreso.getInt("id"), LocalDate.of(jsonIngreso.getInt("ano"),jsonIngreso.getInt("mes"),jsonIngreso.getInt("dia")),jsonIngreso.getInt("cantidad"),jsonIngreso.getString("detalle"),jsonAproducto(jsonIngreso.getJSONObject("producto")),jsonIngreso.getBoolean("estado"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ingreso;
    }
    /*public Movimiento jsonAMovimiento(JSONObject jsonIngreso)
    {
        Movimiento ingreso = null;
        try {
            ingreso = new Movimiento(jsonIngreso.getInt("id"), LocalDate.of(jsonIngreso.getInt("año"),jsonIngreso.getInt("mes"),jsonIngreso.getInt("dia")),jsonIngreso.getString("detalle"),jsonIngreso.getBoolean("estado"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ingreso;
    }*/
    public Egreso jsonAEgreso(JSONObject jsonIngreso){

        Egreso egreso = null;
        try {
            egreso = new Egreso(jsonIngreso.getInt("id"), LocalDate.of(jsonIngreso.getInt("ano"),jsonIngreso.getInt("mes"),jsonIngreso.getInt("dia")),jsonIngreso.getString("detalle"),(float)jsonIngreso.getDouble("monto"),jsonIngreso.getBoolean("estado"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  egreso;
    }
    public ArrayList<Provedoor> arrayListProvedores(JSONArray array)
    {
        ArrayList<Provedoor> aux = new ArrayList<Provedoor>();
        for (int i = 0; i <array.length();i++)
        {
            try {
                aux.add(jsonAProvedor(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aux;
    }
    public ArrayList<Producto> arrayListProducto(JSONArray array)
    {
        ArrayList<Producto> aux = new ArrayList<Producto>();
        for (int i = 0; i <array.length();i++)
        {
            try {
                aux.add(jsonAproducto(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return aux;
    }
    public ArrayList<Movimiento> arrayListMovimientos(JSONArray array)
    {
        ArrayList<Movimiento> aux = new ArrayList<Movimiento>();
        JSONObject obj= null;
        for (int i = 0; i <array.length();i++)
        {
            try {
                obj = array.getJSONObject(i);
                if(obj.getInt("tipo")==1)
                {
                    aux.add(jsonAIngreso(array.getJSONObject(i)));
                }else
                {
                    aux.add(jsonAEgreso(array.getJSONObject(i)));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return aux;
    }
    public JSONArray ProvedoresarrayList(ArrayList<Provedoor> array)
    {
        JSONArray aux = new JSONArray();
        for (Provedoor p: array)
        {
            aux.put(provedorAJson(p));
        }
        return aux;
    }
    public JSONArray ProductoarrayList(ArrayList<Producto> array)
    {
        JSONArray aux = new JSONArray();
        for (Producto p: array)
        {
            aux.put(productoAjson(p));
        }
        return aux;
    }
    public  JSONArray MovimientosarrayList(ArrayList<Movimiento> array)
    {
        JSONArray aux = new JSONArray();

        for (Movimiento obj: array)
        {
                if(obj instanceof Ingreso)
                {
                    aux.put(ingresoAjson((Ingreso) obj));
                }else if(obj instanceof Egreso)
                {
                    aux.put(egresoAjson((Egreso) obj));
                }
        }
        return aux;
    }

    public User jsonAUser(JSONObject jsonUser)
    {
        User user = null;

        try {
            user= new User(jsonUser.getString("nombre"),jsonUser.getString("password"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }

    public JSONObject userAJson(User user)
    {
        JSONObject obj = new JSONObject();

        try {
            obj.put("nombre",user.getUsername());
            obj.put("password",user.getPassword());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  obj;
    }
}
