
package com.datalayer;


import java.sql.DriverManager;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Abraham
 */
public class Controlador {
      private Statement sentencia;
    private Connection conexion;
    
    public Controlador() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hackaton","root", null);
        sentencia = (Statement) conexion.createStatement();
    }
    
    public void cerrar() throws Exception {
        sentencia.close();
        conexion.close();
    }
    
    public ArrayList<Usuario> consultaUsuarios() throws Exception 
    {
        
        String qry = "Select * from usuario";
        ResultSet rs = sentencia.executeQuery(qry);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        while(rs.next()){
            Usuario obj = new Usuario();
            obj.setId_usuario(rs.getInt("id_usuario"));
            obj.setNombre(rs.getString("nombreU"));
            obj.setApellido(rs.getString("apellido"));
            obj.setCorreo(rs.getString("correo"));
            obj.setEdad(rs.getInt("edad"));
            obj.setEstado(rs.getString("estado"));
            obj.setCiudad(rs.getString("ciudad"));
            obj.setColonia(rs.getString("colonia"));
            obj.setCalle(rs.getString("calle"));
            obj.setNumero(rs.getString("numero"));
            usuarios.add(obj);
        }
          rs.close();
        return usuarios;
    }
        
    
    public ArrayList<Mascota> ConultGatoPerro(boolean bol) throws Exception
    {
     
        
        String qry = "  \n" +
"select mascota.*, razas.*, galeria.* from mascota \n" +
"inner join razas on mascota.raza = razas.id_raza \n" +
"inner join galeria on mascota.id_galeria = galeria.id_galeria\n" +
"where mascota.tipo="+bol+";" ;
        
        //qry = "SELECT mascota.*, razas.* , galeria.* FROM mascota INNER JOIN razas on mascota.raza = razas.id_raza INNER JOIN galeria ON mascota.id_galeria = galeria.id_galeria";

        ResultSet rs = sentencia.executeQuery(qry);
        ArrayList<Mascota> mascotas = new ArrayList<>();
        
        while(rs.next()){
            Mascota obj = new Mascota();
            obj.setId_mascota(rs.getInt("id_mascota"));
            obj.setNombre(rs.getString("nombreM"));
            obj.setTipo(rs.getBoolean("tipo"));
            obj.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            obj.setGenero(rs.getBoolean("genero"));
            obj.setPeso(rs.getFloat("peso"));
            obj.setColor(rs.getString("color"));
            obj.setEstado(rs.getString("estado"));
            obj.setDescripcion(rs.getString("descripcion"));
            obj.setFecha_ingreso(rs.getString("fecha_ingreso"));
            obj.setRaza_nombre(rs.getString("descripcionRaza"));
            obj.setFoto1(rs.getString("imagen1"));
            obj.setFoto2(rs.getString("imagen2"));
            
                
            mascotas.add(obj);
            
          
        }
        rs.close();
        return mascotas;
      
        
    }
    
    
  public Mascota consultaMascotaSola(int id) throws Exception 
    {
        
        
        String qry ="select mascota.*, razas.*, galeria.* from mascota \n" +
"inner join razas on mascota.raza = razas.id_raza \n" +
"inner join galeria on mascota.id_galeria = galeria.id_galeria\n" +
"where mascota.id_mascota=" +
+id+";";
        ResultSet rs = sentencia.executeQuery(qry);
        Mascota obj = new Mascota();
        while(rs.next()){
            obj.setId_mascota(rs.getInt("id_mascota"));
            obj.setNombre(rs.getString("nombreM"));
            obj.setTipo(rs.getBoolean("tipo"));
            obj.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            obj.setGenero(rs.getBoolean("genero"));
            obj.setPeso(rs.getFloat("peso"));
            obj.setColor(rs.getString("color"));
            obj.setEstado(rs.getString("estado"));
            obj.setDescripcion(rs.getString("descripcion"));
            obj.setFecha_ingreso(rs.getString("fecha_ingreso"));
            obj.setRaza_nombre(rs.getString("descripcionRaza"));
            obj.setFoto1(rs.getString("imagen1"));
            obj.setFoto2(rs.getString("imagen2"));
        }
            rs.close();
            return obj;
            
          
    }
    
    public Galeria getImagenporId (int id) throws Exception{
        
        String qry ="Select * from galeria where id_galeria ="+id+";";
        ResultSet rs = sentencia.executeQuery(qry);
        Galeria obj = new Galeria();
        while(rs.next()){
            obj.setId_galeria(rs.getInt("id_galeria"));
            obj.setImagen1(rs.getString("imagen1"));
            obj.setImagen2(rs.getString("imagen2"));
            
        }
        rs.close();
        return obj;
    }
    
    
   public  ArrayList<Mascota> consultarMascotas() throws Exception
    {
        
        String qry = "SELECT mascota.*, razas.* , galeria.* FROM mascota INNER JOIN razas on mascota.raza = razas.id_raza INNER JOIN galeria ON mascota.id_galeria = galeria.id_galeria";
        
        ResultSet rs = sentencia.executeQuery(qry);
        ArrayList<Mascota> mascotas = new ArrayList<>();
        
        while(rs.next()){
            Mascota obj = new Mascota();
            obj.setId_mascota(rs.getInt("id_mascota"));
            obj.setNombre(rs.getString("nombreM"));
            obj.setTipo(rs.getBoolean("tipo"));
            obj.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            obj.setGenero(rs.getBoolean("genero"));
            obj.setPeso(rs.getFloat("peso"));
            obj.setColor(rs.getString("color"));
            obj.setEstado(rs.getString("estado"));
            obj.setDescripcion(rs.getString("descripcion"));
            obj.setFecha_ingreso(rs.getString("fecha_ingreso"));
            obj.setRaza_nombre(rs.getString("descripcionRaza"));
            obj.setId_galeria(rs.getInt("id_galeria"));
            obj.setFoto1(rs.getString("imagen1"));
            obj.setFoto2(rs.getString("imagen2"));
            mascotas.add(obj);
   
        }
        rs.close();
        return mascotas;
    }
   
   public  ArrayList<Prospecto> consultarProspecto() throws Exception
    {
        
        
        String qry = " select prospecto.* , usuario.nombreU, \n" +
" mascota.nombreM from prospecto \n" +
" inner join usuario on usuario.id_usuario=prospecto.id_usuario\n" +
" inner join mascota on\n" +
" mascota.id_mascota =prospecto.id_mascota\n" +
" ; ";
        ResultSet rs = sentencia.executeQuery(qry);
        ArrayList<Prospecto> prospecto = new ArrayList<>();
        
        while(rs.next()){
            Prospecto obj = new Prospecto();
            obj.setId_prospecto(rs.getInt("id_prospecto"));
            obj.setFecha(rs.getString("fecha"));
            obj.setId_mascota(rs.getInt("id_mascota"));
            obj.setStatus(rs.getBoolean("status"));
            obj.setId_usuario(rs.getInt("id_usuario"));
            obj.setUsuario(rs.getString("nombreU"));
            obj.setMascota(rs.getString("nombreM"));
            
            prospecto.add(obj);
          
        }
        rs.close();
        return prospecto;
    }
   
   public  ArrayList<Razas> consultarRazas() throws Exception
    {
        String qry = "Select * from razas";
        ResultSet rs = sentencia.executeQuery(qry);
        ArrayList<Razas> razas = new ArrayList<>();
        
        while(rs.next()){
            Razas obj = new Razas();
            obj.setId_raza(rs.getInt("id_raza"));
            obj.setRaza(rs.getString("descripcionRaza"));
                     
            razas.add(obj);
          
        }
        rs.close();
        return razas;
    }
   
   public  ArrayList<Mascota> RazasPorID(int id_raza)throws Exception
   {
       
       
       //String qry = "select mascota.* from mascota where raza = "+id_raza;
        String qry = 
" select mascota.*, razas.* , galeria.* from mascota \n" +
"inner join razas on+\n" +
" mascota.raza = razas.id_raza \n" +
" INNER JOIN galeria ON\n" +
" mascota.id_galeria = galeria.id_galeria\n" +
" where mascota.raza =" +id_raza+";";
        ResultSet rs = sentencia.executeQuery(qry);
        ArrayList<Mascota> mascota = new ArrayList<>();
        
        while(rs.next()){
            Mascota obj = new Mascota();
            obj.setId_mascota(rs.getInt("id_mascota"));
            obj.setNombre(rs.getString("nombreM"));
            obj.setTipo(rs.getBoolean("tipo"));
            obj.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            obj.setGenero(rs.getBoolean("genero"));
            obj.setPeso(rs.getFloat("peso"));
            obj.setColor(rs.getString("color"));
            obj.setEstado(rs.getString("estado"));
            obj.setDescripcion(rs.getString("descripcion"));
            obj.setFecha_ingreso(rs.getString("fecha_ingreso"));
            obj.setRaza(rs.getInt("raza"));
            obj.setRaza_nombre(rs.getString("descripcionRaza"));
            obj.setId_galeria(rs.getInt("id_galeria"));
            obj.setFoto1(rs.getString("imagen1"));
            obj.setFoto2(rs.getString("imagen2"));
            
            
            mascota.add(obj);
          
        }
        rs.close();
        return mascota;
    }
   
   public Reporte ReportePorID(int id_Reporte) throws Exception{
       String qry = "select * from reporte where id_reporte="+id_Reporte+";";
       ResultSet rs = sentencia.executeQuery(qry);
       Reporte obj  = new Reporte();
       while(rs.next()){
           obj.setId_reporte(rs.getInt("id_reporte"));
           obj.setLatitud(rs.getFloat("latitud"));
           obj.setLongitud(rs.getFloat("longitud"));
           obj.setDescripcion(rs.getString("descripcion"));
           obj.setRuta_foto(rs.getString("ruta_foto"));
           obj.setFecha(rs.getString("fecha"));
       }
       rs.close();
       return obj;
   }
   
   
   
   
   public  ArrayList<Reporte> consultarReportes() throws Exception
    {
        String qry = "Select * from reporte";
        ResultSet rs = sentencia.executeQuery(qry);
        ArrayList<Reporte> reporte = new ArrayList<>();
        while(rs.next()){
            Reporte obj = new Reporte();
            obj.setId_reporte(rs.getInt("id_reporte"));
            obj.setLatitud(rs.getFloat("latitud"));
            obj.setLongitud(rs.getFloat("longitud"));
            obj.setRuta_foto(rs.getString("ruta_foto"));
            obj.setDescripcion(rs.getString("descripcion").replace("ñ", "%A4"));
            obj.setFecha(rs.getString("fecha"));
            reporte.add(obj);
          
        }
        rs.close();
        return reporte;
    }
   
       
}

