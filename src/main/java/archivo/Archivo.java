package archivo;

import java.io.File;
import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;

public class Archivo {
    public static void grabar(JSONArray array,String nombre) {
        try {
            FileWriter file = new FileWriter(nombre);
            file.write(array.toString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String leer(String nombre)
    {
        String contenido = "";
        try
        {
            contenido = new String(Files.readAllBytes(Paths.get(nombre)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contenido;
    }
    public static void crearArchivo(String nombre)
    {
           try {

        File New_File = new File(nombre);

        if (New_File.createNewFile()){
            System.out.println("The file is created successfully!");
            try {
                Archivo.grabar(new JSONArray("[]"), nombre);
            } catch (JSONException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("The file already exists.");
        }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
