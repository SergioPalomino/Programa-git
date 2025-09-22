/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasificacion_triage;
import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class eliminar {
    public static void main(String[] args) {
        conexion con = new conexion();
        int idEliminar = 1; // ID del registro a eliminar

        try {
            // ✅ Usa el driver actualizado
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error al cargar el driver de MySQL");
            ex.printStackTrace();
            return;
        }

        // ✅ Manejo de recursos seguro con try-with-resources
        try (Connection cn = con.getConection()) {

            // ✅ Eliminar el registro con el ID especificado
            String sqlEliminar = "DELETE FROM clasificacion_triage WHERE id = ?";
            try (PreparedStatement ps = cn.prepareStatement(sqlEliminar)) {
                ps.setInt(1, idEliminar);
                int filas = ps.executeUpdate();

                if (filas > 0) {
                    System.out.println("✅ Registro eliminado correctamente.");
                } else {
                    System.out.println("⚠️ No se encontró el registro con id = " + idEliminar);
                }
            }

            // ✅ Mostrar los registros restantes
            String sqlMostrar = "SELECT * FROM clasificacion_triage";
            try (PreparedStatement ps2 = cn.prepareStatement(sqlMostrar);
                 ResultSet rs = ps2.executeQuery()) {

                System.out.println("📋 Registros actuales en la tabla:");
                while (rs.next()) {
                    System.out.println(
                        rs.getInt("id") + ": " +
                        rs.getString("antecedentes") + " - " +
                        rs.getString("urgencia_inmediata_rojo") + " - " +
                        rs.getString("urgencia_calificada_amarillo") + " - " +
                        rs.getString("urgencia_consulta_verde")
                    );
                }
            }

        } catch (SQLException ex) {
            System.err.println("❌ Error al ejecutar la operación en la base de datos");
            ex.printStackTrace();
        }
    }
}