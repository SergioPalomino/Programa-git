/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package historia_clinica;
import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milto
 */
public class agregar {
    public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    String nombre = "vanessa";
    String fecha_nacimiento = "14/09/25";
    String  sexo = "femenino";
    String lugar_residencia = "neiva";
    String ocupacion = "ingeniero";
    String estado_civil = "soltera";
    String familiar_responsable = "rosa patiño";
    String telefono = "3206508979";
    String motivo_consulta = "enferfmedad";
    String sql = "INSERT INTO historia_clinica (nombre, fecha_nacimiento, sexo,  lugar_residencia, ocupacion, estado_civil, familiar_responsable, telefono, motivo_consulta) values ('"+nombre+"','"+fecha_nacimiento+"','"+sexo+"','"+lugar_residencia+"','"+ocupacion+"','"+estado_civil+"','"+familiar_responsable+"','"+telefono+"','"+motivo_consulta+"')";
    try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM historia_clinica ");
    rs.next();
    
    do{
    System.out.println(rs.getInt("id")+":"+rs.getString("nombre")+"-"+rs.getString("fecha_nacimiento")+"-"+rs.getString("sexo")+"-"+rs.getString("lugar_residencia")+"-"+rs.getString("ocupacion")+"-"+rs.getString("estado_civil")+"-"+rs.getString("familiar_responsable")+"-"+rs.getString("telefono")+"-"+rs.getString("motivo_consulta"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
