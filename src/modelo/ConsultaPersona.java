
package modelo;

import java.sql.*;

public class ConsultaPersona extends Conexion {
    PreparedStatement ps;
    ResultSet rs;
    Connection conexion;
    
    public boolean insertar(Persona persona){
        conexion = getConnection();
        
        try {
            ps = conexion.prepareStatement("insert into persona (clave, nombre, domicilio, celular, correo, fecha_nacimiento, genero) values (?,?,?,?,?,?,?)");
            ps.setString(1, persona.getClave());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getDomicilio());
            ps.setString(4, persona.getCelular());
            ps.setString(5, persona.getCorreo());
            ps.setDate(6, persona.getFecha_nacimiento());
            ps.setString(7, persona.getGenero());
            
            int resultado = ps.executeUpdate();
            
            if (resultado>0) {
                return true;
            }
            else{
                return false;
            }
            
            
        } catch (Exception e) {
            System.err.println("Error, "+e);
            return false;
        }finally{
            try {
                conexion.close();
            } catch (Exception e) {
                System.err.println("Error, "+e);
            }
        }
    }
    
    public boolean buscar(Persona persona){
        conexion = getConnection();
        
        try {
            ps = conexion.prepareStatement("select * from persona where clave = ?");
            ps.setString(1, persona.getClave());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setClave(rs.getString("clave"));
                persona.setNombre(rs.getString("nombre"));
                persona.setDomicilio(rs.getString("domicilio"));
                persona.setCelular(rs.getString("celular"));
                persona.setCorreo(rs.getString("correo"));
                persona.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                persona.setGenero(rs.getString("genero"));
                return true;                
            }
            else{
                return false;
            }
            
            
        } catch (Exception e) {
            System.err.println("Error, "+e);
            return false;
        }finally{
            try {
                conexion.close();
            } catch (Exception e) {
                System.err.println("Error, "+e);
            }
        }
    }
    
    public boolean modificar(Persona persona){
        conexion = getConnection();
        
        try {
            ps = conexion.prepareStatement("update persona set clave=?, nombre=?, domicilio=?, celular=?, correo=?, fecha_nacimiento=?, genero=? where idPersona=?");
            ps.setString(1, persona.getClave());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getDomicilio());
            ps.setString(4, persona.getCelular());
            ps.setString(5, persona.getCorreo());
            ps.setDate(6, persona.getFecha_nacimiento());
            ps.setString(7, persona.getGenero());
            ps.setInt(8, persona.getIdPersona());
            
            int resultado = ps.executeUpdate();
            
            if (resultado>0) {
                return true;
            }
            else{
                return false;
            }
            
            
        } catch (Exception e) {
            System.err.println("Error, "+e);
            return false;
        }finally{
            try {
                conexion.close();
            } catch (Exception e) {
                System.err.println("Error, "+e);
            }
        }
    }
    
    public boolean eliminar(Persona persona){
        conexion = getConnection();
        
        try {
            ps = conexion.prepareStatement("delete from persona where idPersona = ?");
            ps.setInt(1, persona.getIdPersona() );
            
            int resultado = ps.executeUpdate();
            
            if (resultado>0) {
                return true;
            }
            else{
                return false;
            }          
            
        }catch (Exception e) {
            System.err.println("Error, "+e);
            return false;
        }finally{
            try {
                conexion.close();
            } catch (Exception e) {
                System.err.println("Error, "+e);
            }
        } 
    }
    
}
