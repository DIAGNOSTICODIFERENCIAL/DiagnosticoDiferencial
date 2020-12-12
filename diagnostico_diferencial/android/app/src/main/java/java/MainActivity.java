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
    hashTable ht = new hashTable();
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
                                    String id = call.argument("id");
                                    ArrayList resultado = main(sintomas,signos,id,database);
                                    //System.out.println("resultaaaado "+resultado);
                                    result.success(resultado);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if(call.method.equals("gethistorial")){
                                /*String greetings = helloFromNativeCode();
                                result.success(greetings);*/
                                ArrayList resultado = gethistorial();
                                //System.out.println("resultaaaado 2222"+resultado);
                                result.success(resultado);
                            }
                            if(call.method.equals("gethistorialperson")){
                                /*String greetings = helloFromNativeCode();
                                result.success(greetings);*/
                                String id = call.argument("id");
                                ArrayList respuesta = gethistorialperson(id);
                                //System.out.println("resultaaaado 2222"+resultado);
                                result.success(respuesta);
                            }
                        }
                );
    }
    private ArrayList main(ArrayList<String> sintomas, ArrayList<String> signos, String id, ArrayList<String> database) throws IOException {
        System.out.println("la ideeeeeeee"+id);
        paciente p = new paciente(id);
        
        dataReader dr = new dataReader();
        doubleLinkedList<enfermedad> enfermedades = dr.readArrayList(database);
        enfermedad enfermedadPaciente = createEnfermedad(sintomas,signos);
        diagnosticoArrays diagnostico = new diagnosticoArrays();
        diagnostico.diagnostico(enfermedadPaciente,enfermedades);
        
        //ArrayList arrayListResultadoDiagnostico = diagnostico.getDiagnostico().toArrayList();
        //arrayListResultadoDiagnostico.add(historial.toArrayList());
        PQueue resultado = diagnostico.getDiagnostico2();
        ArrayList arrayListResultadoDiagnostico = resultado.toArrayList();
        historial.addSearch(enfermedadPaciente.toString(),arrayListResultadoDiagnostico);
        p.añadirDiagnostico(enfermedadPaciente.toString(),arrayListResultadoDiagnostico);
        ht.insert(ht.hash(p.cedula),p);
        //paciente p2=(paciente)ht.search("1234");
        //System.out.println("HASHMAP AAAAAAA");
        //System.out.println("HASHMAP"+p2.diagnosticos.toArrayList().toString());
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
        //System.out.println("Se creaaaaa pacienteeee"+enfermedadP);
        return enfermedadP;
    }
    private ArrayList gethistorial(){
        ArrayList registros = historial.toArrayList();
        return registros;
    }
    
    private  ArrayList gethistorialperson(String id){
        ArrayList arr = new ArrayList();
        if(ht.search(id)!=null){
            paciente p=(paciente)ht.search(id);
            arr =p.diagnosticos.toArrayList();
        }else{
            arr.add("vacío");
        }
        return arr;

    }

}
