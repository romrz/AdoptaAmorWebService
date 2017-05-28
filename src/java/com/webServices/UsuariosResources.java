/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webServices;

import com.datalayer.Controlador;
import com.datalayer.Mascota;
import com.datalayer.Usuario;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import javax.json.Json;
import javax.ws.rs.PathParam;
import java.io.StringReader;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * REST Web Service
 *
 * @author Abraham
 */
@Path("usuarios_ws")
public class UsuariosResources {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuariosResources
     */
    public UsuariosResources() {
    }

    /**
     * Retrieves representation of an instance of com.webservices.UsuariosResources
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String index() {
        return "Index de usuarios";
    }

    @Path("todos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String todos() {
        
        try {
            Controlador manejador = new Controlador();
            ArrayList<Mascota> mascota = manejador.consultarMascotas();
            String resultado = "";
            for (Mascota obj : mascota){
                    resultado = "\nNombre: "+ obj.getNombre();
                    resultado += "\nDescricion: "+obj.getDescripcion();
                    
                    resultado += "\n----------\n";
            }
            manejador.cerrar();
            return resultado;           
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Error.\n" +e;
        }


    }
    
    @Path("login/{data_login}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@PathParam ("data_login") String data_login) {
        /*data_login = data_login.replace("(", "{").replace(")","}");
        try {
            StringReader sr = new StringReader(data_login);
            JsonReader jsonReader = Json.createReader(sr);
            JsonObject json = jsonReader.readObject();
            
            Manejador manejador = new Manejador();
            
            boolean resultado = manejador.existeUsuario(json.getString("usr"), json.getString("pass"));
            
            manejador.cerrar();
            
            return ""+ resultado;
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
*/
        return "Hi";
    }
    
    @Path("registro/{usuario}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String registro(@PathParam ("usuario") String usuario) {
        
        /*try {
            StringReader sr = new StringReader(usuario);
            JsonReader jsonReader = Json.createReader(sr);
            JsonObject json = jsonReader.readObject();
            
            Manejador manejador = new Manejador();
            
            boolean resultado = manejador.agregaUsuario(
                    json.getString("usr"),
                    json.getString("pass"),
                    json.getString("nombre"),
                    json.getString("sexo"),
                    json.getString("fecha")
                    );
             
            manejador.cerrar();
            
            return ""+ resultado;
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }*/
        return "Adios";
    }
}
