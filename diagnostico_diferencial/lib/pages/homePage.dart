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

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  String _dataBasePath = "assets/muestra.txt";

  final id = TextEditingController();

  int mainBlue = 0xff048AEC;

  int mainRed = 0xffED201C;

  int softBlue = 0xffE7F3FC;

  double buttonsHeight = 50;

  List resultado;
  List historial;

  var platform = MethodChannel("prueba/cien");
  String hiText = "";

  InlineSpan get textSpan => null;

  void _hi(signos, sintomas, database) async {
    List response;
    try {
      response = await platform.invokeMethod("main",
          {"signos": signos, "sintomas": sintomas, "database": database});
      //print("RESPONSEEEE");
      //print(response);
      setState(() {
        resultado = response;
        hiText = "Success!";
      });
    } on Exception {
      setState(() {
        hiText = "Failed";
      });
    }
  }

  Widget build(BuildContext context) {
    final appState = Provider.of<AppState>(context);

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          //title: Text("Diagnóstico diferencial"),
          title: Text(hiText),
          centerTitle: true,
        ),
        backgroundColor: Color(softBlue),
        drawer: Drawer(
          child: ListView(
            padding: EdgeInsets.zero,
            children: [
              DrawerHeader(
                decoration: BoxDecoration(color: Colors.blue),
              ),
              ListTile(
                leading: Icon(Icons.person),
                title: Text("Perfil"),
                onTap: () {},
              ),
              ListTile(
                leading: Icon(Icons.app_registration),
                title: Text("Registros"),
                onTap: () {
                        Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => new Registros().build(context)),
      );
                },
              ),
              ListTile(
                leading: Icon(Icons.pending_actions_rounded),
                title: Text("Historial de diagnosticos"),
                onTap: () {
                  actaulizarhistorial();
                },
              ),
            ],
          ),
        ),
        body: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Container(
                margin: EdgeInsets.fromLTRB(20, 50, 10, 0),
                alignment: Alignment(20, 30),
                child: Text.rich(
                  TextSpan(
                      text: "Bienvenido, ",
                      style: TextStyle(fontWeight: FontWeight.bold),
                      children: [
                        TextSpan(
                          text: "Usuario \n",
                          style: TextStyle(fontWeight: FontWeight.normal),
                        ),
                        TextSpan(
                            text:
                                "app ofrece una evaluación general de los signos y síntomas presentes en el paciente. A continuación seleccione los signos y sintomas observados en su evaluación médica, despues proceda pulsar el botón de diagnostico.",
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
                          Navigator.pushNamed(context, '/sintomas');
                        },
                        child: Text(
                          "SÍNTOMAS",
                          style: TextStyle(
                            color: Colors.black,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
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
                          Navigator.pushNamed(context, '/signos');
                        },
                        child: Text(
                          "SIGNOS",
                          style: TextStyle(
                            color: Colors.black,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ),
                    ),
                    ButtonTheme(
                      minWidth: 200.0,
                      height: 50,
                      child: RaisedButton(
                        color: Colors.red[200],
                        splashColor: Colors.black,
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(18.0),
                            side: BorderSide(color: Colors.blue)),
                        onPressed: () {
                          readCounter(_dataBasePath, appState.signos,
                              appState.sintomas, id.text);
                        },
                        child: Text(
                          "DIAGNÓSTICO",
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            color: Colors.black,
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () {
           ;
          },
          child: Icon(Icons.pending_actions),
        ),
      ),
    );
  }

  Future<String> readCounter(path, signos, sintomas, id) async {
    WidgetsFlutterBinding.ensureInitialized();
    try {
      String contents = await rootBundle.loadString(path);
      LineSplitter ls = new LineSplitter();
      List<String> lines = ls.convert(contents);
      //_hi(signos,sintomas,lines);
      List response;
      try {
        response = await platform.invokeMethod("main", {
          "signos": signos,
          "sintomas": sintomas,
          "id": id,
          "database": lines
        });
        setState(() {
          resultado = response;
          hiText = "Success!";
        });
      } on Exception {
        print(Exception);
        setState(() {
          hiText = "Failed";
        });
      }
      Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => Resultado(resultado)),
      );
      return ("Well Done");
    } catch (e) {
      print(e);
      // If encountering an error, return 0.
      return "F";
    }
  }

  Future<String> actaulizarhistorial() async {
    WidgetsFlutterBinding.ensureInitialized();
    try {
      List response;
      try {
        response = await platform.invokeListMethod("gethistorial");
        historial = response;
        print(historial);
        setState(() {
          historial = response;
          hiText = "Success!";
        });
      } on Exception {
        print(Exception);
        setState(() {
          hiText = "Failed";
        });
      }
      Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => Historial(historial)),
      );
    } catch (e) {
      print(e);
      // If encountering an error, return 0.
      return "F";
    }
  }
  
}
