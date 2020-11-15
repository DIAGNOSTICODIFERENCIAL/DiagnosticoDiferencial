package java;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.ArrayList;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;
import diagnosisTools.*;
import structures.*;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "prueba/cien";
    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if(call.method.equals("main")){
                                /*String greetings = helloFromNativeCode();
                                result.success(greetings);*/
                                try {
                                    ArrayList<String> sintomas = call.argument("sintomas");
                                    ArrayList<String> signos = call.argument("signos");
                                    ArrayList<String> database = call.argument("database");
                                    ArrayList<ArrayList<String>>[] resultado = main(sintomas,signos,database);
                                    result.success(resultado);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                );
    }
    private ArrayList<ArrayList<String>>[] main(ArrayList<String> sintomas,ArrayList<String> signos,ArrayList<String> database) throws IOException {
        dataReader dr = new dataReader();
        doubleLinkedList<enfermedad> enfermedades = dr.readArrayList(database);
        System.out.println(enfermedades.getK(1).signos.toString());
        //enfermedad enfermedadP = dr.readOne();
        //System.out.println(enfermedades.length());
        //System.out.println(enfermedades);
        //System.out.println(enfe1);
        //enfermedad enfermedadPaciente = dr2.readOne();
        /*enfermedad enfermedadPaciente = createEnfermedad(sintomas,signos);
        System.out.println(enfermedadPaciente);
        diagnosticoArrays diagnostico = new diagnosticoArrays();
        diagnostico.diagnostico(enfermedadPaciente,enfermedades);
        diagnostico.resultadoDiagnostico.sort();
        ArrayList<ArrayList<String>>[] matrizResultado = diagnostico.getMatriz();*/
        return null;
        //BinaryHeap monti = new BinaryHeap();
    }

    private enfermedad createEnfermedad(ArrayList<String> sintomas,ArrayList<String> signos){
        enfermedad enfermedadP = new enfermedad();
        enfermedadP.name = "Desconocida";
        enfermedadP.signos = new stringDoubleLinkedList(signos);
        enfermedadP.sintomas = new stringDoubleLinkedList(sintomas);
        return enfermedadP;
    }



}
