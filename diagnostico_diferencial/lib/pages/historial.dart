import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:expansion_card/expansion_card.dart';
import 'package:flutter/services.dart';

import 'resultadoDiagnostico.dart';



class Historial extends StatefulWidget {
  @override
  List registros;


  Historial(registro) {
    registros = registro;
    LineSplitter ls = new LineSplitter();
    List newResult =[];
    int contador = 0;
    var platform = MethodChannel("prueba/cien");

    print(registros);

    if (registros!=null){
      registros.forEach((enfermedad){
        String busqueda = enfermedad[0]; //busqueda realizada
        busqueda=busqueda.replaceAll("Enfermedad: Desconocida", "Busqueda #"+contador.toString()); //contador de busquedas
        List resultados = enfermedad[1]; //resultados
        newResult.add([Text(busqueda, style: TextStyle(color: Colors.black),), resultados]);
        contador++;
      });
    }
    this.registros = newResult;
  }

  _HistorialState createState() {
    return new _HistorialState(registros);
  }
}

class _HistorialState extends State<Historial> {
  @override
  int contador =0;
  List resultado;
  int softBlue = 0xffE7F3FC;
  int mainBlue = 0xff048AEC;
  int mainRed = 0xffED201C;
  _HistorialState(this.resultado);

  Widget build(BuildContext context) {

    return MaterialApp(
      home: Scaffold(
        backgroundColor: Color(softBlue),
        appBar: AppBar(
          title: Text("Historial"),
          centerTitle: true,
          elevation: 0,
          leading: IconButton(
            icon: Icon(Icons.arrow_back),
            onPressed: () => Navigator.pop(context, false),
          ),
        ),

        body: SingleChildScrollView(
            child: Column(
              children: resultado.map((enfermedad) {
                return ExpansionCard(
                  initiallyExpanded: false,

                  title: RaisedButton(
                    color: Colors.blue[300],
                    splashColor: Colors.black, shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(18.0),
                      side: BorderSide(color: Colors.blue)
                  ),
                    onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => Resultado(enfermedad[1])),
                      );
                    },
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        enfermedad[0],

                      ],
                    ),
                  ),
                  children: <Widget>[
                    Container(
                      margin: EdgeInsets.symmetric(horizontal: 7),
                      child: enfermedad[0],
                    ),
                  ]
                );
              }).toList(),
            )),
      ),
    );
  }
}
