
package src.main;


import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.TableColumnModel;

public class Window extends JFrame {
    String data;

    public Window(String data){
        this.data=data;
        setSize(500,700); // se establece el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);// Para que el programa se  cierre al darle a la x
        setTitle("Diagnóstico Diferencial");
        setLocationRelativeTo(null);//centrar ventana
        setBackground(Color.blue);
        Components();
       
        
    }
    public void Components(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);

        JLabel titulo = new JLabel("Diagnóstico Diferencial");
        titulo.setBounds(170, 10, 300, 20);;
        //titulo.setFont();
        panel.add(titulo);

        JButton Bfind = new JButton("Buscar enfermedad asociada");
        Bfind.setBounds(100, 100, 300, 20);
        panel.add(Bfind);

        JTextField Tinput = new JTextField();
        Tinput.setBounds(100, 70, 300, 20);
        panel.add(Tinput);

        JTable table = new JTable();
        table.setBounds(100, 140, 300, 300);

        ActionListener accion = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae){
                String sinSaltos = data.replaceAll("\n", "<br> ");
                String[] parts = sinSaltos.split("Enfermedad:");
                Object [][] datap = {
                    {"opción 1","<html>"+parts[1],"%"},
                    {"opción 2","<html>"+parts[2],"%"},
                    {"opción 3","<html>"+parts[3],"%"},
                    
                    
                    };
                showdata(datap,panel);
            }
        };

        Bfind.addActionListener(accion);

    }

    public void showdata(Object[][] datos, JPanel panel) {
        String[] columnas = {"Enfermedad", 
        "Signos", 
        "Sintomas"};
        
        JTable table = new JTable(datos, columnas);
       
        panel.add(table);
        //panel.add(table.getTableHeader());
        //table.getTableHeader().setBounds(100, 130, 300, 20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        TableColumnModel colModel=table.getColumnModel(); 
        colModel.getColumn(1).setPreferredWidth(400);
        table.setRowHeight(180);

        
        table.setBounds(50, 150, 420, 500);
 

    }
        
 

}