/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasificacion_triage;
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
    
    String antecedentes = "cefalea";
    String urgencia_inmediata_rojo = "fractura";
    String urgencia_calificada_amarillo = "nauseas";
    String urgencia_consulta_verde = "dolor pie derecho";
    String sql = "INSERT INTO clasificacion_triage (antecedentes, urgencia_inmediata_rojo, urgencia_calificada_amarillo,  urgencia_consulta_verde) values ('"+antecedentes+"','"+urgencia_inmediata_rojo+"','"+urgencia_calificada_amarillo+"','"+urgencia_consulta_verde+"')";
    try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM clasificacion_triage ");
    rs.next();
    
    do{
    System.out.println(rs.getInt("id")+":"+rs.getString("antecedentes")+"-"+rs.getString("urgencia_inmediata_rojo")+"-"+rs.getString("urgencia_calificada_amarillo")+"-"+rs.getString("urgencia_consulta_verde"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}