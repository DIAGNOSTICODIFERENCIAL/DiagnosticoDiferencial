import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'dart:convert';
import 'dart:core';


class Signos extends StatefulWidget {
  @override
  _SignosState createState() => _SignosState();
}

class _SignosState extends State<Signos> {
  @override
  List<String> signos = [];

  Widget build(BuildContext context) {
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
      ),
    );
  }

  fetchFileSignos() async{
    String responseText;
    responseText = await rootBundle.loadString('assets/signos.txt');
    List<String> response;
    setState(() {
      LineSplitter ls = new LineSplitter();
      response = ls.convert(responseText);
      signos = response;
    });
  }


}
