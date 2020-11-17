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
    history historial = new history();
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
                                    ArrayList resultado = main(sintomas,signos,database);
                                    System.out.println("resultaaaado "+resultado);
                                    result.success(resultado);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                );
    }
    private ArrayList main(ArrayList<String> sintomas,ArrayList<String> signos,ArrayList<String> database) throws IOException {
        dataReader dr = new dataReader();
        doubleLinkedList<enfermedad> enfermedades = dr.readArrayList(database);
        enfermedad enfermedadPaciente = createEnfermedad(sintomas,signos);
        diagnosticoArrays diagnostico = new diagnosticoArrays();
        diagnostico.diagnostico(enfermedadPaciente,enfermedades);
        ArrayList arrayListResultadoDiagnostico = diagnostico.getDiagnostico().toArrayList();
        //arrayListResultadoDiagnostico.add(historial.toArrayList());
        return arrayListResultadoDiagnostico;
        //BinaryHeap monti = new BinaryHeap();
    }

    private enfermedad createEnfermedad(ArrayList<String> sintomas,ArrayList<String> signos){
        enfermedad enfermedadP = new enfermedad();
        enfermedadP.name = "Desconocida";
        enfermedadP.signos = new stringDoubleLinkedList(signos);
        enfermedadP.sintomas = new stringDoubleLinkedList(sintomas);
        //System.out.println("Se creaaaaa pacienteeee sin ordenar"+enfermedadP);
        enfermedadP.sort();
        historial.addSearch(enfermedadP.toString());
        //System.out.println("Se creaaaaa pacienteeee"+enfermedadP);
        return enfermedadP;
    }



}
