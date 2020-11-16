import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:provider/provider.dart';
import 'dart:convert';
import 'dart:core';

import 'MyModel.dart';
import 'checkButton.dart';


class Signos extends StatelessWidget {
  @override

  Widget build(BuildContext context) {

    final appState = Provider.of<AppState>(context);

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Signos:"),
          centerTitle: true,
          elevation: 0,
          leading: IconButton(
            icon: Icon(Icons.arrow_back),
            onPressed: () => Navigator.pop(context, false),
          ),
        ),
        body:SingleChildScrollView(
          child: Column(
            children: signos.map((dato){
              if(appState.signos.contains(dato)){
                return CustomImageCheckbox(dato,true,"signo");
              }
              else{
                return CustomImageCheckbox(dato,false,"signo");
              }
            }).toList(),
          ),
        ),
      ),
    );
  }

  List<String> signos = [
    "masa abdominal",
    "obesidad",
    "alogia",
    "anasarca",
    "hematoma",
    "alucinaciones",
    "manchas",
    "presión intracraneal",
    "hedor hepatico",
    "cianosis",
    "chancro",
    "crepitación",
    "linea nigra",
    "rectorragia",
    "exantema",
    "emesis",
    "gingivorragia",
    "gliosis",
    "goma granulomatosa",
    "gránulos de schüffner",
    "hematemesis",
    "hematocele",
    "hematoma",
    "hematuria",
    "hemoptisis",
    "hemorragia",
    "hemorragia digestiva baja",
    "hemorragia gastrointestinal",
    "hepatomegalia",
    "hinchazón",
    "hinchazón abdominal",
    "hiperfosfatemia",
    "hiperglucemia",
    "hipertelorismo"
  ];



}
