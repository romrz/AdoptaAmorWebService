package com.webServices;

import com.datalayer.Controlador;

import com.datalayer.Mascota;
import com.datalayer.Prospecto;
import com.datalayer.Razas;
import com.datalayer.Reporte;
import com.datalayer.Usuario;
import com.sun.xml.messaging.saaj.util.Base64;
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
import java.math.BigDecimal;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Abraham
 */
@Path("universal_ws")
public class UniversalResources {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuariosResources
     */
    /*public UsuariosResources() {
       
    }*/

    /**
     * Retrieves representation of an instance of com.webservices.UsuariosResources
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String index() {
        return "Pagina de inicio";
    }

    @Path("mascotas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String mascotas() {
        
        try {
            Controlador manejador = new Controlador();
            ArrayList<Mascota> mascota = manejador.consultarMascotas();
            
            JsonArrayBuilder array = Json.createArrayBuilder();
            for (Mascota obj : mascota){
                JsonObjectBuilder json = Json.createObjectBuilder();
                json.add("id_mascota", obj.getId_mascota());
                    json.add("nombreM", obj.getNombre());
                    
                    if(obj.getTipo()==false){
                    json.add("tipo", "Gato");
                    }else
                    {
                    json.add("tipo", "Perro");
                    }
                    
                    json.add("fecha_nacimiento", obj.getFecha_nacimiento());
                    
                    if(obj.getGenero()==false){
                    json.add("genero", "Macho");
                    }else
                    {
                    json.add("genero", "Hembra");
                    }
                    json.add("peso", obj.getPeso());
                    json.add("color", obj.getColor());
                    json.add("estado", obj.getEstado());
                    json.add("descripcion", obj.getDescripcion());                   
                    json.add("fecha_ingreso", obj.getFecha_ingreso());
                    json.add("raza", obj.getRaza());
                    json.add("id_galeria", obj.getId_galeria());
                    json.add("imagen1", obj.getFoto1());
                    json.add("imagen2", obj.getFoto2());
                    array.add(json);
                            
            }
            manejador.cerrar();
            return array.build().toString();           
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Error.\n" +e;
        }


    }
    
    @Path("mascotas/{tipo}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String mascotas(@PathParam("tipo") boolean tipo){
        
        try {
            Controlador manejador = new Controlador();
            ArrayList<Mascota> mascota = manejador.ConultGatoPerro(tipo);
            
            JsonArrayBuilder array = Json.createArrayBuilder();
            for (Mascota obj : mascota){
                JsonObjectBuilder json = Json.createObjectBuilder();
                    json.add("id_mascota", obj.getId_mascota());
                    json.add("nombreM", obj.getNombre());
                    
                    if(obj.getTipo()==false){
                    json.add("tipo", "Gato");
                    }else
                    {
                    json.add("tipo", "Perro");
                    }
                    
                    json.add("fecha_nacimiento", obj.getFecha_nacimiento());
                    
                    if(obj.getGenero()==false){
                    json.add("genero", "Macho");
                    }else
                    {
                    json.add("genero", "Hembra");
                    }
                    json.add("peso", obj.getPeso());
                    json.add("color", obj.getColor());
                    json.add("estado", obj.getEstado());
                    json.add("descripcion", obj.getDescripcion());
                    
                    
                    json.add("fecha_ingreso", obj.getFecha_ingreso());
                    json.add("raza", obj.getRaza());
                    json.add("id_galeria", obj.getId_galeria());
                    json.add("imagen1", obj.getFoto1());
                    json.add("imagen2", obj.getFoto2());
                    array.add(json);
                            
            }
            manejador.cerrar();
            return array.build().toString();           
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Error.\n" +e;
        }

    }
    
       
    
        

    @Path("prospecto")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String prospecto() {
        
        try {
            Controlador manejador = new Controlador();
            ArrayList<Prospecto> prospecto = manejador.consultarProspecto();
            
            JsonArrayBuilder array = Json.createArrayBuilder();
            for (Prospecto obj : prospecto){
                JsonObjectBuilder json = Json.createObjectBuilder();
                    json.add("prospecto", obj.getId_prospecto());
                    json.add("fecha", obj.getFecha());
                    json.add("id_mascota", obj.getId_mascota());
                   
                    if(obj.getStatus()==false){
                    json.add("tipo", "adoptado");
                    }else
                    {
                    json.add("tipo", "pendiente");
                    }
                    
                    json.add("id_usuario", obj.getId_usuario());
                    json.add("nombre_usuario", obj.getUsuario());
                    json.add("nombre_Mascota", obj.getMascota());
                    array.add(json);
            }
            manejador.cerrar();
            return array.build().toString();           
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Error.\n" +e;
        }


    }
    
    @Path("razas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String razas() {
        
        try {
            Controlador manejador = new Controlador();
            ArrayList<Razas> razas = manejador.consultarRazas();
            JsonArrayBuilder array = Json.createArrayBuilder();
            for (Razas obj : razas){
                JsonObjectBuilder json = Json.createObjectBuilder();     
                    json.add("id_raza", obj.getId_raza());
                    json.add("raza", obj.getRaza());
                    array.add(json);
                    
                   
            }
            manejador.cerrar();
            
            return array.build().toString();           
        } catch (Exception e) {
            e.printStackTrace();
            return "Error.\n" +e;
        }
    }
    
    
    @Path("foto,nombre")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getFoto(@PathParam("foto")String foto,@PathParam("nombre")String nombre) throws Exception{
        
         JsonObjectBuilder json = Json.createObjectBuilder();    
         
       byte[] arreglo = javax.xml.bind.DatatypeConverter.parseBase64Binary(foto);
          try { 
     java.io.OutputStream out = new java.io.FileOutputStream("C:\\Users\\Abraham\\Documents\\NO BORRAR\\glassfish4\\glassfish\\domains\\domain1\\docroot\\foto.png"); 
     out.write(arreglo); 
     out.close();         
      
   } catch (Exception e) { 
     e.printStackTrace(); 
   }         
          
     json.add("resultado", foto);
     json.build();
  return   json.toString();
    
  }

        

    
   @Path("mascotaSola/{id_Mascota}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String Mascotas(@PathParam("id_Mascota") int id_Mascota){
            try {
            Controlador manejador = new Controlador();
            Mascota mascota = manejador.consultaMascotaSola(id_Mascota);
            JsonObjectBuilder json = Json.createObjectBuilder();    
            
            json.add("id_galeria", mascota.getId_mascota());
            json.add("nombreM", mascota.getNombre());
                    if(mascota.getTipo()==false){
                    json.add("tipo", "Gato");
                    }else
                    {
                    json.add("tipo", "Perro");
                    }
            json.add("fecha_nacimiento", mascota.getFecha_nacimiento());
            if(mascota.getGenero()==false){
                    json.add("genero", "Macho");
                    }else
                    {
                    json.add("genero", "Hembra");
                    }
            json.add("color", mascota.getColor());
            json.add("estado", mascota.getEstado());
            json.add("descripcion", mascota.getDescripcion());
            
            
           json.add("fecha_ingreso", mascota.getFecha_ingreso());
            json.add("raza", mascota.getRaza());
            json.add("id_galeria", mascota.getId_galeria());
            json.add("nombreRaza", mascota.getRaza_nombre());
            json.add("imagen1", mascota.getFoto1());
            json.add("imagen2", mascota.getFoto2());
            
            
            manejador.cerrar();
            
            return json.build().toString();           
            
            
            }catch(Exception E){
            
            return "Error.\n"  + E;
            }
    
    }
    
    
   @Path("razas/{id_raza}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String razas(@PathParam("id_raza") int id_raza){
        
        try {
            Controlador manejador = new Controlador();
            ArrayList<Mascota> razas = manejador.RazasPorID(id_raza);
            JsonArrayBuilder array = Json.createArrayBuilder();
            for (Mascota obj : razas){
                JsonObjectBuilder json = Json.createObjectBuilder();     
                    json.add("id_mascota", obj.getId_mascota());
                    json.add("nombreM", obj.getNombre());
                    
                    if(obj.getTipo()==false){
                    json.add("tipo", "Gato");
                    }else
                    {
                    json.add("tipo", "Perro");
                    }
                    json.add("fecha_nacimiento", obj.getFecha_nacimiento());
                    if(obj.getGenero()==false){
                    json.add("genero", "Macho");
                    }else
                    {
                    json.add("genero", "Hembra");
                    }
                    json.add("peso", obj.getPeso());
                    json.add("color", obj.getColor());
                    json.add("estado", obj.getEstado());
                    json.add("descripcion", obj.getDescripcion());
                    
                    
                    json.add("fecha_ingreso", obj.getFecha_ingreso());
                    json.add("raza", obj.getRaza());
                    json.add("id_galeria", obj.getId_galeria());
                    json.add("nombreRaza", obj.getRaza_nombre());
                    json.add("imagen1", obj.getFoto1());
                    json.add("imagen2", obj.getFoto2());
                      
                            
                    array.add(json);
      
            }
            manejador.cerrar();
            
            return array.build().toString();           
        } catch (Exception e) {
            e.printStackTrace();
            return "Error.\n" +e;
        }


    }
    
    
    @Path("reporte")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String reporte() {
        
        try {
            Controlador manejador = new Controlador();
            ArrayList<Reporte> reporte = manejador.consultarReportes();
            JsonArrayBuilder array = Json.createArrayBuilder();
            for (Reporte obj : reporte){
                JsonObjectBuilder json = Json.createObjectBuilder();     
                    json.add("id_reporte", obj.getId_reporte());
                    json.add("latitud", obj.getLatitud());
                    json.add("longitud", obj.getLongitud());
                    json.add("ruta_foto", obj.getRuta_foto());
                    json.add("descripcion", obj.getDescripcion());
                    json.add("fecha", obj.getFecha());
                    array.add(json);
            }
            manejador.cerrar();
            return array.build().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error.\n" +e;
        }
    }
    @Path("reporte/{id_reporte}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String reporte(@PathParam("id_reporte") int id_reporte){
        try {
            
            Controlador manejador = new Controlador();
            
            Reporte reporte = manejador.ReportePorID(id_reporte);
            JsonArrayBuilder array = Json.createArrayBuilder();
             JsonObjectBuilder json = Json.createObjectBuilder();  
             json.add("id_reporte", reporte.getId_reporte());
             json.add("latitud", reporte.getLatitud());
             json.add("longitud", reporte.getLatitud());
             json.add("ruta_foto", reporte.getRuta_foto());
             json.add("descripcion", reporte.getDescripcion());
             json.add("fecha", reporte.getFecha());
            manejador.cerrar();
            array.add(json);
            return array.build().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
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
