import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:diagnostico_diferencial/pages/checkButton.dart';
import 'dart:convert';
import 'dart:core';


class Sintomas extends StatefulWidget {
  @override
  _SintomasState createState() => _SintomasState();
}

class _SintomasState extends State<Sintomas> {
  @override
  List<String> sintomas = [];

  Widget build(BuildContext context) {
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
              return CustomImageCheckbox(dato);
          }).toList(),
          ),
        ),
      ),
    );
  }

  fetchFileSintomas() async{
    String responseText;
    responseText = await rootBundle.loadString('assets/sintomas.txt');
    List<String> response;
    setState(() {
      LineSplitter ls = new LineSplitter();
      response = ls.convert(responseText);
      sintomas  = response;
    });
  }
  void initState(){
    fetchFileSintomas();
    super.initState();
  }
}