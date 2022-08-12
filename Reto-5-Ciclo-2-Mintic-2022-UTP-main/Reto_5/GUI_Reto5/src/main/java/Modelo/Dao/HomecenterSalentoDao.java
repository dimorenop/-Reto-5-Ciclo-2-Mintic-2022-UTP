/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;


import Modelo.Vo.HomecenterSalentoVo;
import Util.JDBCUtilities;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class HomecenterSalentoDao {
    public List<HomecenterSalentoVo> listar() throws SQLException {
        ArrayList<HomecenterSalentoVo> respuesta = new ArrayList<HomecenterSalentoVo>();        
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Compra, p.Constructora , p.Banco_Vinculado " +
                          "FROM Compra c " +
                          "JOIN Proyecto p " +
                          "ON c.ID_Proyecto  = p.ID_Proyecto " +
                          "WHERE Proveedor  = 'Homecenter' AND p.Ciudad  = 'Salento' ";

        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                HomecenterSalentoVo objeto = new HomecenterSalentoVo();
                objeto.setId_compra(rs.getInt("ID_Compra"));
                objeto.setConstructora(rs.getString("Constructora"));
                objeto.setBanco(rs.getString("Banco_Vinculado"));
              
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
