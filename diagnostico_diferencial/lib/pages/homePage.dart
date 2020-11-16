import 'dart:io';

import 'package:diagnostico_diferencial/pages/resultadoDiagnostico.dart';
import 'package:diagnostico_diferencial/pages/historial.dart';
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

  int mainBlue = 0xff048AEC;

  int mainRed = 0xffED201C;

  int softBlue = 0xffE7F3FC;

  double buttonsHeight = 50;

  List resultado;

  var platform = MethodChannel("prueba/cien");
  String hiText = "";

  void _hi(signos,sintomas,database) async {

    List response;
    try{
      response = await platform.invokeMethod("main",{"signos":signos,"sintomas":sintomas,"database":database});
      print("RESPONSEEEE");
      print(response);
      setState(() {
        resultado = response;
        hiText = "Success!";
      });
    } on Exception{
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
                  leading: Icon(Icons.medical_services),
                  title: Text("Diagnosticar"),
                  onTap: () {},
                ),
                ListTile(
                  leading: Icon(Icons.pending_actions_rounded),
                  title: Text("Historial de diagnosticos"),
                  onTap: (){
                    Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => Historial(resultado)),
                    );
                  },
                ),
              ],
            ),
          ),
          body: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Container(
                margin: EdgeInsets.fromLTRB(10, 0, 10, 0),
                alignment: Alignment(20, 30),
                child: Text.rich(
                  TextSpan(
                      text: "Bienvenido, ",
                      style: TextStyle(fontWeight: FontWeight.bold),
                      children: [
                        TextSpan(
                          text: "Usuario ",
                          style: TextStyle(fontWeight: FontWeight.normal),
                        )
                      ]),
                  style: TextStyle(fontSize: 50),
                ),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  ButtonTheme(
                    minWidth: 100.0,
                    height: buttonsHeight,
                    child: RaisedButton(
                      onPressed: () {
                        Navigator.pushNamed(context, '/sintomas');
                      },
                      child: Text(
                        "SÍNTOMAS",
                        style: TextStyle(
                          color: Colors.white,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      color: Color(mainBlue),
                    ),
                  ),
                  ButtonTheme(
                    minWidth: 100.0,
                    height: buttonsHeight,
                    child: RaisedButton(
                      onPressed: () {
                        Navigator.pushNamed(context, '/signos');
                      },
                      child: Text(
                        "SIGNOS",
                        style: TextStyle(
                          color: Colors.white,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      color: Color(mainBlue),
                    ),
                  ),
                ],
              ),
              ButtonTheme(
                minWidth: 150.0,
                height: 80,
                child: RaisedButton(
                  onPressed: () {
                    readCounter(_dataBasePath,appState.signos,appState.sintomas);

                  },
                  child: Text(
                    "DIAGNÓSTICO",
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                    ),
                  ),
                  color: Color(mainRed),
                ),
              ),
            ],
          )),
    );
  }



  Future<String> readCounter(path,signos,sintomas) async {
    WidgetsFlutterBinding.ensureInitialized();
    try {
      String contents = await rootBundle.loadString(path);
      LineSplitter ls = new LineSplitter();
      List<String> lines = ls.convert(contents);
      print("-------------------------------LINES------------------------------------");
      print(lines);
      print("-------------------------------LINES------------------------------------");
      //_hi(signos,sintomas,lines);
      List response;
      try{
        response = await platform.invokeMethod("main",{"signos":signos,"sintomas":sintomas,"database":lines});
        print("RESPONSEEEE");
        print(response);
        setState(() {
          resultado = response;
          hiText = "Success!";
        });
      } on Exception{
        setState(() {
          hiText = "Failed";
        });
      }
      Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => Resultado(resultado)),
      );
      return("Well Done");
    } catch (e) {
      print(e);
      // If encountering an error, return 0.
      return "F";
    }
  }



}
