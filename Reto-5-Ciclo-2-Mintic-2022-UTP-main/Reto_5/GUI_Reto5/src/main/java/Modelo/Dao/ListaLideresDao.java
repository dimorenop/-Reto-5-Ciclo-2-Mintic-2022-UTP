/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;


import Modelo.Vo.ListaLideresVo;
import Util.JDBCUtilities;
import java.sql.Statement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaLideresDao {
    public List<ListaLideresVo> listar() throws SQLException {
        ArrayList<ListaLideresVo> respuesta = new ArrayList<ListaLideresVo>();        
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Lider as id, Nombre, Primer_Apellido as apellido, Ciudad_Residencia as ciudad " +
                          "FROM Lider l " +
                           "order by Ciudad_Residencia ";

        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                ListaLideresVo objeto = new ListaLideresVo();
                objeto.setId(rs.getInt("id"));
                objeto.setNombre(rs.getString("nombre"));
                objeto.setApellido(rs.getString("apellido"));
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

