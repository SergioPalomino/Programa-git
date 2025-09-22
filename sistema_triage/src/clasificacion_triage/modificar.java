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
public class modificar {
    public static void main (String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(modificar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try{
            cn = con.getConection();
            st = cn.createStatement();

            // ✅ MODIFICAR (ejemplo: del id_usuario = 2)
            String sqlModificar = "UPDATE clasificacion_triage SET antecedentes = 'escalofrio' WHERE id = 1";
            int filas = st.executeUpdate(sqlModificar);
            if (filas > 0) {
                System.out.println("✅ Registro modificado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el registro para modificar.");
            }

            // ✅ MOSTRAR los registros después de la modificación
            rs = st.executeQuery("SELECT * FROM clasificacion_triage");
            while (rs.next()){
                System.out.println(
                    rs.getInt("id")+": "+
                    rs.getString("antecedentes")+" - "+
                    rs.getString("urgencia_inmediata_rojo")+" - "+
                    rs.getString("urgencia_calificada_amarillo")+" - "+
                    rs.getString("urgencia_consulta_verde")
                );
            }

        }catch (SQLException ex){
            Logger.getLogger(modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
