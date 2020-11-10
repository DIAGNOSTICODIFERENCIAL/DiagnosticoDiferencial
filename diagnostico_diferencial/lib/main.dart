import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:diagnostico_diferencial/pages/homePage.dart';
import 'package:diagnostico_diferencial/pages/checklistSignos.dart';
import 'package:diagnostico_diferencial/pages/checklistSintomas.dart';
import 'package:diagnostico_diferencial/pages/resultadoDiagnostico.dart';



void main() => runApp(MaterialApp(
  initialRoute: '/',
  routes:{
    "/": (context) => Home(),
    '/signos' :(context) => Signos(),
    '/sintomas' :(context) => Sintomas(),
    '/resultado' :(context) => Resultado(),
  }
));
