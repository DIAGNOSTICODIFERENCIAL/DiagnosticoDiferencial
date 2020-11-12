import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter/services.dart';
import 'package:diagnostico_diferencial/pages/checkButton.dart';
import 'dart:convert';
import 'dart:core';

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {


  List<String> signos = [];
  List<String> sintomas = [];

  Widget wSignos;
  Widget wSintomas;

  int mainBlue = 0xff048AEC;

  int mainRed = 0xffED201C;

  int softBlue = 0xffE7F3FC;

  double buttonsHeight = 50;

  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
          appBar: AppBar(
            title: Text("Diagnóstico diferencial"),
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
                    Navigator.pushNamed(context, '/resultado');
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


}
