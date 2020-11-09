import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

void main() {
  runApp(MyApp());
}
class MyApp extends StatelessWidget{

  int mainBlue = 0xff048AEC;
  int mainRed = 0xffED201C;
  int softBlue = 0xffE7F3FC;

  Widget build(BuildContext context){
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
                    decoration: BoxDecoration(
                      color: Colors.blue
                    ),

                  ),

                  ListTile(
                    leading: Icon(Icons.person),
                    title: Text("Perfil"),
                    onTap:() {},
                  ),
                  ListTile(
                    leading: Icon(Icons.medical_services),
                    title: Text("Diagnosticar"),
                    onTap:() {},
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
            mainAxisSize: MainAxisSize.max,
            children: <Widget>[
              Container(
                margin: EdgeInsets.fromLTRB(10, 0, 10, 0),
                alignment: Alignment(20, 30),
                child:Text.rich(
                  TextSpan(
                      text: "Bienvenido, ",
                      style: TextStyle(fontWeight: FontWeight.bold),
                      children: [
                        TextSpan(
                          text: "Usuario ",
                          style: TextStyle(fontWeight: FontWeight.normal),
                        )
                      ]),
                  style: TextStyle(fontSize:50),
                ),
              ),


              Container(
                margin: EdgeInsets.fromLTRB(10, 0, 10, 0),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: <Widget>[

                    Container(
                      child: TextField(
                        decoration: InputDecoration(
                          prefixIcon: Icon(Icons.search, size: 18,),
                          border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(10),
                          ),
                          hintText: "Ingrese sintomas y signos",
                        ),
                      ),
                    ),
                    Container(
                      child: RaisedButton(
                        onPressed: (){},
                        child:Text(
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
                ),
              ),

            ],
          ),
      ),
    );
  }

  Text buildText() => Text("");
