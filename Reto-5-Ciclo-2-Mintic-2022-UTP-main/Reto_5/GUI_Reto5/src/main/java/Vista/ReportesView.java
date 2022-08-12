/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ReportesController;
import Modelo.Vo.HomecenterSalentoVo;
import Modelo.Vo.ListaLideresVo;
import Modelo.Vo.ProyectosCasaCampestreVo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
//import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zoydam
 */
public class ReportesView extends JFrame implements ActionListener {

    public static ReportesController controller;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem primerInf, segundoInf, tercerInf;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta;
    private JTable tabla;

    public ReportesView() {
        controller = new ReportesController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();
    }

    public void tabla() {
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 200));
        
        tabla.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        tabla.setShowGrid(true);
        tabla.setRowMargin(1);
        tabla.setGridColor(Color.LIGHT_GRAY);
        tabla.setRowHeight(tabla.getRowHeight() + 5);

        add(tabla);
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);
    }

    public void etiqueta1() {
        lblTitulo = new JLabel("Reto 5");
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        add(lblTitulo);
    }

    public void etiqueta2() {
        lblConsulta = new JLabel("");
        lblConsulta.setPreferredSize(new Dimension(500, 30));
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblConsulta);
    }

    public void menu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Informes - Reto 5");
        menuBar.add(menu);
        primerInf = new JMenuItem("Primer Informe");
        segundoInf = new JMenuItem("Segundo Informe");
        tercerInf = new JMenuItem("Tercer Informe");
        menu.add(primerInf);
        menu.add(segundoInf);
        menu.add(tercerInf);

        primerInf.addActionListener(this);
        segundoInf.addActionListener(this);
        tercerInf.addActionListener(this);
    }
    
    public void primerInforme() {

        try {
            List<ListaLideresVo> lideres = controller.listarLideres();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Lider");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apedllido");
            modelo.addColumn("Ciudad");

            for (ListaLideresVo lider : lideres) {
                Object[] fila = new Object[4];
                fila[0] = lider.getId();
                fila[1] = lider.getNombre();
                fila[2] = lider.getApellido();
                fila[3] = lider.getCiudad();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged(); //actualiza el modelo de la tabla
            
        } catch (Exception ex) {
            System.err.println("Error " + ex);
        }

    }

    public void segundoInforme() {

        try {
            List<ProyectosCasaCampestreVo> proyectos2 = controller.listarCasaCampestre();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Proyecto");
            modelo.addColumn("Constructora");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");

            for (ProyectosCasaCampestreVo proyecto2 : proyectos2) {
                Object[] fila = new Object[4];
                fila[0] = proyecto2.getId();
                fila[1] = proyecto2.getConstructora();
                fila[2] = proyecto2.getHabitaciones();
                fila[3] = proyecto2.getCiudad();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged(); //actualiza el modelo de la tabla
        } catch (Exception ex) {
            System.err.println("Error " + ex);
        }
    }

    public void tercerInforme() {

        try {
            List<HomecenterSalentoVo> proyectos3 = controller.listarHomecenter();
            
            modelo = new DefaultTableModel();
            modelo.addColumn("Id Compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco Vinculado");

            for (HomecenterSalentoVo proyecto3 : proyectos3) {
                Object[] fila = new Object[3];
                fila[0] = proyecto3.getId_compra();
                fila[1] = proyecto3.getConstructora();
                fila[2] = proyecto3.getBanco();
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged(); //actualiza el modelo de la tabla
        } catch (Exception ex) {
            System.err.println("Error " + ex);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == primerInf) {
            primerInforme();
            lblConsulta.setText("Informe de Líderes");
        }        
        if (e.getSource() == segundoInf) {
            segundoInforme();
            lblConsulta.setText("Informe Proyectos Casa Campestre");
        }        
        if (e.getSource() == tercerInf) {
            tercerInforme();
            lblConsulta.setText("Informe de Proyectos HomeCenter");
        }
    }

}
