import Vista.ReportesView;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zoydam
 */
public class App {
    public static void main( String[] args )
    {
        var reportesView = new ReportesView();
        reportesView.setLayout(new FlowLayout());
        reportesView.setSize(600,400);
        reportesView.setResizable(false);
        reportesView.setVisible(true);
        reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportesView.setLocation(null);
        reportesView.setTitle("Informes - Reto 5");
        
    }
}
