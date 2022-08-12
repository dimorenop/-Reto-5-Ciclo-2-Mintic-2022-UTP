/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import Modelo.Vo.ProyectosCasaCampestreVo;
//import Modelo.Vo.ProyectosCasaCampestreVo;
import Util.JDBCUtilities;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProyectosCasaCampestreDao {
    public List<ProyectosCasaCampestreVo> listar() throws SQLException {
        ArrayList<ProyectosCasaCampestreVo> respuesta = new ArrayList<ProyectosCasaCampestreVo>();        
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Proyecto  as id, Constructora , Numero_Habitaciones as habitaciones, Ciudad " +
                          "FROM Proyecto p  " +
                          "WHERE Clasificacion = 'Casa Campestre' AND Ciudad in('Santa Marta', 'Cartagena', 'Barranquilla') ";

        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                ProyectosCasaCampestreVo objeto = new ProyectosCasaCampestreVo();
                objeto.setId(rs.getInt("id"));
                objeto.setConstructora(rs.getString("constructora"));
                objeto.setHabitaciones(rs.getInt("habitaciones"));
                objeto.setCiudad(rs.getString("ciudad"));
                
                respuesta.add(objeto);
            }
        }finally{
            if (rs != null) {
                rs.close();        
            }
            if (stmt != null) {
                stmt.close();        
            }
            if (conn != null) {
                conn.close();        
            }
        }   
        return respuesta;            
    }
}
