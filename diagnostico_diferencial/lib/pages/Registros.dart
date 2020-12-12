import 'dart:io';

import 'package:diagnostico_diferencial/pages/resultadoDiagnostico.dart';
import 'package:diagnostico_diferencial/pages/historial.dart';
import 'package:diagnostico_diferencial/pages/Registros.dart';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter/services.dart';
import 'package:diagnostico_diferencial/pages/checkButton.dart';
import 'package:provider/provider.dart';
import 'dart:convert';
import 'dart:core';

import 'MyModel.dart';

class Registros {
  final id = TextEditingController();
  var platform = MethodChannel("prueba/cien");
  List diagnosticos;
  String hiText = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Second Route"),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          Container(
            margin: EdgeInsets.fromLTRB(20, 50, 10, 0),
            alignment: Alignment(20, 30),
            child: Text.rich(
              TextSpan(
                  text: "Base de datos, ",
                  style: TextStyle(fontWeight: FontWeight.bold),
                  children: [
                    TextSpan(
                      text: "\n",
                      style: TextStyle(fontWeight: FontWeight.normal),
                    ),
                    TextSpan(
                        text:
                            "A continuación introduzca el número de identificación del paciente para buscar su historial de diagnosticos.",
                        style: TextStyle(
                            fontSize: 20.0, fontWeight: FontWeight.w300))
                  ]),
              style: TextStyle(fontSize: 50),
            ),
          ),
          Container(
            margin: EdgeInsets.fromLTRB(20, 50, 10, 0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                TextField(
                  controller: id,
                  decoration: InputDecoration(
                    icon: Icon(Icons.perm_identity),
                    hintText: "Id del paciente",
                    filled: true,
                    fillColor: Colors.blue[100],
                  ),
                ),
                ButtonTheme(
                  minWidth: 200.0,
                  height: 50,
                  child: RaisedButton(
                    color: Colors.blue[200],
                    splashColor: Colors.black,
                    shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(18.0),
                        side: BorderSide(color: Colors.blue)),
                    onPressed: () {
                      buscarRegistro(id.text);
                            Navigator.push(
                              context,
                                MaterialPageRoute(builder: (context) => Historial(diagnosticos)),
                          );
                    },
                    child: Text(
                      "BUSCAR",
                      style: TextStyle(
                        color: Colors.black,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }

  Future<String> buscarRegistro(String id) async {
    WidgetsFlutterBinding.ensureInitialized();
    try {
      List response;
      try {
        response =
            await platform.invokeListMethod("gethistorialperson", {"id": id});
        print("responseeeeeeee");
        print(response);
        diagnosticos = response;
      } on Exception {
        print(Exception);
        return "Paciente con id: " + id + "no se encuentra registrado ";
      }
    } catch (e) {
      print(e);
      // If encountering an error, return 0.
      return "F";
    }
  }
}
