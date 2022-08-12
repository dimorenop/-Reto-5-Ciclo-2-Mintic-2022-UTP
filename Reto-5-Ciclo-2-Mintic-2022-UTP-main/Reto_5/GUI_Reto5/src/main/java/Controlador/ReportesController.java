/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Dao.HomecenterSalentoDao;
import Modelo.Dao.ListaLideresDao;
import Modelo.Dao.ProyectosCasaCampestreDao;
import Modelo.Vo.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zoydam
 */

public class ReportesController {
    private ProyectosCasaCampestreDao proyectoCasaCampestre;
    private HomecenterSalentoDao homecenterSalento;
    private ListaLideresDao listaLideresDao;
    
    public ReportesController(){
        proyectoCasaCampestre = new ProyectosCasaCampestreDao();
        homecenterSalento = new HomecenterSalentoDao();
        listaLideresDao = new ListaLideresDao();
    }
    
    public List<ProyectosCasaCampestreVo> listarCasaCampestre() throws SQLException{
        return proyectoCasaCampestre.listar();
    }    

    public List<HomecenterSalentoVo> listarHomecenter() throws SQLException{
        return homecenterSalento.listar();
    }    

    public List<ListaLideresVo> listarLideres() throws SQLException{
        return listaLideresDao.listar();
    }

}