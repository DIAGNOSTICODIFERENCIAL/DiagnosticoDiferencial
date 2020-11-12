import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:diagnostico_diferencial/pages/checkButton.dart';
import 'package:diagnostico_diferencial/pages/MyModel.dart';
import 'dart:core';
import 'package:provider/provider.dart';

class Sintomas extends StatelessWidget {
  @override


  Widget build(BuildContext context) {

    final appState = Provider.of<AppState>(context);

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Sintomas:"),
          centerTitle: true,
          elevation: 0,
          leading: IconButton(
            icon: Icon(Icons.arrow_back),
            onPressed: () => Navigator.pop(context, false),
          ),
        ),
        body:SingleChildScrollView(
          child: Column(
            children: sintomas.map((dato){
              if(appState.sintomas.contains(dato)){
                return CustomImageCheckbox(dato,true,"sintoma");
              }
              else{
                return CustomImageCheckbox(dato,false,"sintoma");
              }
          }).toList(),
          ),
        ),
      ),
    );
  }



  List<String> sintomas = [
    "dolor de abdomen",
    "dolor de espalda",
    "dolor de pecho",
    "dolor de oído",
    "dolor de cabeza",
    "dolor de pelvis",
    "dolor de dientes",
    "dolor de recto",
    "dolor de piel",
    "no puede respirar normalmente",
    "no puede escuchar normalmente",
    "no puede ver normalmente",
    "no puede mover un lado",
    "no puede defecar",
    "no puede orinar",
    "no puede dormir",
    "no puede oler",
    "no puede tragar",
    "no puede saborear",
    "no puede sentir",
    "no puede hablar",
    "escalofríos",
    "fiebre",
    "parestesia",
    "aturdimiento",
    "presincope",
    "boca seca",
    "nausea",
    "desaliento",
    "somnolencia",
    "sudoración",
    "sed",
    "cansancio",
    "debilidad",

  ];

}