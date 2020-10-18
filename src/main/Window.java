
package src.main;

import src.diagnosisTools.diagnosticoArrays;
import src.diagnosisTools.enfermedad;
import structures.doubleLinkedList;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DefaultStyledDocument;

public class Window extends JFrame {
    String data;
    String name;
    dataReader dr;
    dataReader dr2;
    history historial;
    doubleLinkedList<enfermedad> enfermedades;
    enfermedad enfermedadPaciente;

    public Window(String name){
        dr = new dataReader("muestra2.txt");
        dr2 = new dataReader("enfermedadPaciente.txt");
        this.name=name;
        setSize(700,900); // se establece el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);// Para que el programa se  cierre al darle a la x
        setTitle("Diagnóstico Diferencial");
        setLocationRelativeTo(null);//centrar ventana
        setBackground(Color.blue);
        historial = new history();
        Components();
    }

    public void Components(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        this.getContentPane().add(panel);

        JLabel titulo = new JLabel("Diagnóstico Diferencial");
        titulo.setBounds(240, 10, 300, 20);
        titulo.setFont(new Font("Serif", Font.PLAIN, 20));
        

        //titulo.setFont();
        panel.add(titulo);

        JButton BLoad = new JButton("Cargar Base de Datos");
        BLoad.setBounds(100, 630, 200, 20);
        panel.add(BLoad);


        JButton Bfind = new JButton("Diagnóstico");
        Bfind.setBounds(230, 660, 200, 20);
        panel.add(Bfind);

        JButton BPaciente = new JButton("Cargar enfermedad Paciente");
        BPaciente.setBounds(380, 630, 200, 20);
        panel.add(BPaciente);

        JTextArea Tinput = new JTextArea();
        Tinput.setBounds(100, 70, 480, 200);
        try {
            Tinput.setText(dr2.readPlain());
        } catch (IOException e) {
            e.printStackTrace();
        }
        panel.add(Tinput);

        JButton BHistorial = new JButton("Historial de Diagnosticos");
        BHistorial.setBounds(180, 40, 300, 20);
        panel.add(BHistorial);

        JTable table = new JTable();
        table.setBounds(100, 140, 450, 300);

        JButton Bprev = new JButton("volver");
        Bprev.setBounds(490, 40, 90, 20);
        Bprev.setVisible(false);
        panel.add(Bprev);

        ActionListener mostrarinput = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Tinput.setVisible(false);
            }
        };
        Bfind.addActionListener(mostrarinput);

        ActionListener mostrartabla = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                table.setVisible(false);
                Tinput.setVisible(true);
                
            }
        };

        Bprev.addActionListener(mostrartabla);
        

        ActionListener mostrarHistorial = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //mostrar Historial
            }
        };
        BHistorial.addActionListener(mostrarHistorial);
        ActionListener cargarPaciente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    FileWriter fw = new FileWriter ("enfermedadPaciente.txt");
                    Tinput.write(fw);
                    fw.close();
                    dr2 = new dataReader("enfermedadPaciente.txt");
                    enfermedadPaciente = dr2.readOne();
                    System.out.println("Data Loaded");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        BPaciente.addActionListener(cargarPaciente);
        ActionListener accion = new ActionListener(){//Hace la busqueda y muestra los resultados
            @Override
            public void actionPerformed(ActionEvent ae){
                Bprev.setVisible(true);
                table.setVisible(true);

                diagnosticoArrays diagnostico = new diagnosticoArrays();
                diagnostico.diagnostico(enfermedadPaciente,enfermedades);
                diagnostico.resultadoDiagnostico.sort();
                historial.addSearch(diagnostico.resultadoDiagnostico);
                data = diagnostico.resultadoDiagnostico.toString();
                String sinSaltos = data.replaceAll("\n", "<br> ");
                String[] parts = sinSaltos.split("Enfermedad:");
                Object [][] datap = {
                    {"opción 1","<html>"+parts[1],"%"},
                    {"opción 2","<html>"+parts[2],"%"},
                    {"opción 3","<html>"+parts[3],"%"},
                    
                    
                    };
                showdata(datap,panel, table);
            }
        };
        Bfind.addActionListener(accion);

        ActionListener loadData = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                enfermedades = null;
                try {
                    dr = new dataReader("muestra2.txt");
                    enfermedades = dr.readList();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Database loaded");
            }
        };
        BLoad.addActionListener(loadData);
    }

    public void showdata(Object[][] datos, JPanel panel, JTable table) {
        String[] columnas = {"Enfermedad", 
        "Signos", 
        "Sintomas"};
        
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        table.setModel(modelo);
        panel.add(table);
        //panel.add(table.getTableHeader());
        //table.getTableHeader().setBounds(100, 130, 300, 20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        TableColumnModel colModel=table.getColumnModel(); 
        colModel.getColumn(1).setPreferredWidth(400);
        table.setRowHeight(180);

        
        table.setBounds(100, 130, 480, 500);
 

    }
        
 

}